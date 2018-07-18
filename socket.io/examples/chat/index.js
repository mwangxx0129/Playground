// Setup basic express server
var express = require('express');
var app = express();
var path = require('path');
var server = require('http').createServer(app);
var io = require('../..')(server);
var port = process.env.PORT || 3000;

server.listen(port, () => {
  console.log('Server listening at port %d', port);
});

// Routing
app.use(express.static(path.join(__dirname, 'public')));

// chatRooms
/*
chatRooms = {
  'topic1':[roomId_1, roomId_2]
  'topic2':[]
}
*/
var chatRooms = {};
var dialogInfo = {};

var numUsers = 0;

io.on('connection', (socket) => {
  var addedUser = false;
  
  // when the client emits 'new message', this listens and executes
  socket.on('new message', (data) => {
    // we tell the client to execute 'new message'
    socket.broadcast.to(socket.roomId).emit('new message', {
      username: socket.username,
      message: data
    });
    dialogInfo[socket.id]['context'].push({
      "value": data,
      "role": socket.userInfo.role,
      "worker_id": socket.id,
      "timestamp": Date.now(),
      "terminal": false
    });
    console.log(socket.id + " -> "+ socket.roomId + ": " + data);
  });

  // new room
  socket.on('new room', (userInfo) => {
    socket.userInfo = userInfo;
    
    var topic = userInfo['topic'];
    var roomId = socket.id;
    if (!(topic in chatRooms)) {
      chatRooms[topic] = [];
    }
    
    chatRooms[topic].push(roomId);
    socket.join(roomId);
    socket.roomId = roomId;// for sys, the room id is same as self socket id

    // init system dialog
    dialogInfo[socket.id] = {
      "context": [],
      "system_profile_id": socket.id,
      "user_profile_id":''
    };
    
  });

  // allocate room
  socket.on('allocate room', (userInfo) => {

    socket.userInfo = userInfo;
    var topic = userInfo['topic'];

    if (chatRooms[topic].length > 0) {
      
      // allocate based on topic
      var roomId = chatRooms[topic].pop();
      socket.join(roomId);
      socket.roomId = roomId;
      
      // init user dialog
      dialogInfo[socket.id] = {
        "context": [],
        "system_profile_id": roomId,
        "user_profile_id":socket.id
      };
      
      // set system's user_profile_id is current socketid
      dialogInfo[roomId]['user_profile_id'] = socket.id;
    } else {
      // not available 
      console.log('no available room for topic: ', topic);
    }
  });

  // when the client emits 'add user', this listens and executes
  socket.on('add user', (username) => {
    if (addedUser) return;
    // we store the username in the socket session for this client    
    socket.username = username;
    ++numUsers;
    addedUser = true;
    socket.emit('login', {
      numUsers: numUsers
    });
    // echo globally (all clients) that a person has connected
    socket.broadcast.emit('user joined', {
      username: socket.username,
      numUsers: numUsers
    });
  });

  // when the client emits 'typing', we broadcast it to others
  socket.on('typing', () => {
    socket.broadcast.emit('typing', {
      username: socket.username
    });
  });

  // when the client emits 'stop typing', we broadcast it to others
  socket.on('stop typing', () => {
    socket.broadcast.emit('stop typing', {
      username: socket.username
    });
  });

  // when the user disconnects.. perform this
  socket.on('disconnect', () => {
    if (addedUser) {
      --numUsers;
      // call save api to backup dialog
      if (dialogInfo[socket.id] !== undefined && dialogInfo[socket.id]['context'] !== undefined && dialogInfo[socket.id]['context'].length > 0) {
        var context = dialogInfo[socket.id]['context'];
        context[context.length - 1]['terminal'] = true;
        console.log(dialogInfo[socket.id]);
      }

      // echo globally that this client has left
      socket.broadcast.emit('user left', {
        username: socket.username,
        numUsers: numUsers
      });
    }
  });
});
