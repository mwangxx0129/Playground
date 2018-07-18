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
var chatRooms = {};
var socketIdToRoomId = {};

var numUsers = 0;

io.on('connection', (socket) => {
  var addedUser = false;
  

  // when the client emits 'new message', this listens and executes
  socket.on('new message', (data) => {
    console.log(data);
    // we tell the client to execute 'new message'
    socket.broadcast.to(socket.roomId).emit('new message', {
      username: socket.username,
      message: data
    });

  });

  // new room
  socket.on('new room', (userInfo) => {
    console.log(userInfo);
    console.log('new room ...');
    var topic = userInfo['topic'];
    var roomId = socket.id;
    if (!(topic in chatRooms)) {
      chatRooms[topic] = [];
    }
    
    console.log(chatRooms);
    chatRooms[topic].push(roomId);
    socket.join(roomId);
    socket.roomId = roomId;
    socketIdToRoomId[socket.id] = roomId; // for sys, the room id is same as self socket id
    console.log('join to ', roomId)
    console.log(chatRooms, socketIdToRoomId);
  });

  // allocate room
  socket.on('allocate room', (userInfo) => {
    console.log(userInfo);
    console.log('allocate room ...');
    var topic = userInfo['topic'];
    if (chatRooms[topic].length > 0) {
      console.log(chatRooms);
      var roomId = chatRooms[topic].pop();
      socket.join(roomId);
      socket.roomId = roomId;
      socketIdToRoomId[socket.id] = roomId;
      console.log(userInfo['username'] + 'join to ', roomId);
      console.log(chatRooms, socketIdToRoomId);
    } else {
      console.log('no available room for topic: ', topic);
    }
  });

  // when the client emits 'add user', this listens and executes
  socket.on('add user', (username) => {
    if (addedUser) return;
    // console.log('join to ', username[0]);
    // socket.join(username[0]); 
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

      // echo globally that this client has left
      socket.broadcast.emit('user left', {
        username: socket.username,
        numUsers: numUsers
      });
    }
  });
});
