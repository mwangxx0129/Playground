package June_2019;

import java.util.*;

import static jdk.nashorn.api.scripting.ScriptUtils.convert;

public class Solution {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3","*"};
//        int res = evalRPN(tokens);
////        int res = calculate("3+2*2");
//        int[][] arr = {{0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},{6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}};
//        boolean res = isRectangleCover(arr);
//        System.out.println(res);

        int[] A = {-5,-5,-5,-42, 6,8};
        char[][] B = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        solve(B);

    }


    public static void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(m * n + 1);
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                if (board[i][j] == 'X') continue;
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    uf.union(m * n, i * n + j);
                    continue;
                }

                // System.out.println(board[i][j] + " i = " + i + "j = " + j);
                if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                    uf.union(i * n + j, (i - 1) * n + j);
                }
                if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                    uf.union(i * n + j, i * n + j - 1);
                }
                if (i + 1 < m && board[i + 1][j] == 'O') {
                    uf.union(i * n + j, (i + 1) * n + j);
                }

                if (j + 1 < n && board[i][j + 1] == 'O') {
                    uf.union(i * n + j, i * n + j + 1);
                }

            }
        }

        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                if (board[i][j] == 'O' && uf.find(i * n + j) != m * n) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    static class UF {
        int[] father;
        UF(int n) {
            father = new int[n];
            for (int i = 0; i < n; ++ i) {
                father[i] = i;
            }
        }

        int find(int x) {

            if (x == father[x]) {
                return x;
            }
            return father[x] = find(father[x]);
        }

        // set a's ancestor to b's
        void union(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            if (fa == father.length - 1 || fb == father.length - 1){
                father[fa] = father[fb] = father.length - 1;
            }
        }


    }

//
//    public static String game(int N, String S, String T) {
//        // parse T
//        String[] hits = T.split("//s+");
//
//        Set<String> hitSet = new HashSet<>(Arrays.asList(hits));
//        Set<Ship> shipSet = getShipSet(S);
//        for (String hit : hitSet) {
//            for (Ship ship : shipSet) {
//                ship.hit(hit);
//            }
//        }
//
//        return "";
//    }
//
//    private static Set<Ship> getShipSet(String s) {
//        String[] ships = s.split(",");
//        Set<Ship> shipSet = new HashSet<>();
//        for (String ship : ships) {
//            shipSet.add(new Ship(ship));
//        }
//        return shipSet;
//    }
//
//    static class Ship {
//        int size;
//        String leftTop;
//        String rightBottom;
//        Set<String> points;
//        Ship(String leftTopRightBottom) {
//            String[] strs = leftTopRightBottom.trim().split("//s+");
//            this.leftTop = strs[0];
//            this.rightBottom = strs[1];
//            int length = rightBottom.charAt(rightBottom.length() -  1) - leftTop.charAt(leftTop.length() - 1);
//            int width = Integer.parseInt(rightBottom.substring(0, rightBottom.length() - 1)) - Integer.parseInt(leftTop.substring(0, leftTop.length() - 1));
//            this.size = width * length;
//        }
//
//        boolean isHit() {
//            return this.size != points.size();
//        }
//        boolean isSink() {
//            return points.isEmpty();
//        }
//
//        public String toString() {
//            return leftTop + " " + rightBottom;
//        }
//
//        public void hit(String) {
//            points.remove()
//        }
//    }

    public static int find(int[] A) {
        int[] min = new int[A.length];
        int[] max = new int[A.length];
        min[0] = A[0];
        for (int i = 1; i < A.length; ++ i) {
            min[i] = Math.max(A[i], min[i - 1]);
        }

        max[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 1; i >= 1; -- i) {
            max[i - 1] = Math.min(max[i], A[i - 1]);
        }

        for (int i = 0; i < A.length - 1; ++ i) {
            if (min[i] < max[i + 1] && max[i] < min[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

//    public static int evalRPN(String[] tokens) {
//        String opers = "+-*/";
//        Stack<Integer> stack = new Stack<>();
//        for (String token : tokens) {
//            System.out.println(token);
//            if ('0' <= token.charAt(0) && token.charAt(0) <= '9') {
//                stack.push(Integer.parseInt(token));
//            } else {
//                int right = stack.pop();
//                int left = stack.pop();
//                if (token == "+") {
//                    stack.push(left + right);
//                } else if (token == "-") {
//                    stack.push(left - right);
//                } else if (token == "*") {
//                    stack.push(left * right);
//                } else {
//                    stack.push(left / right);
//                }
//                System.out.println(stack.peek());
//            }
//        }
//        return stack.pop();
//    }

//    public static int calculateII(String s) {
//        int len;
//        if(s==null || (len = s.length())==0) return 0;
//        Stack<Integer> stack = new Stack<Integer>();
//        int num = 0;
//        char sign = '+';
//        for(int i=0;i<len;i++){
//            if(Character.isDigit(s.charAt(i))){
//                num = num*10+s.charAt(i)-'0';
//            }
//            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
//                if(sign=='-'){
//                    stack.push(-num);
//                }
//                if(sign=='+'){
//                    stack.push(num);
//                }
//                if(sign=='*'){
//                    stack.push(stack.pop()*num);
//                }
//                if(sign=='/'){
//                    stack.push(stack.pop()/num);
//                }
//                sign = s.charAt(i);
//                num = 0;
//            }
//        }
//
//        int re = 0;
//        for(int i:stack){
//            re += i;
//        }
//        return re;
//    }

    public static int calculate(String s) {
        int n = s.length(),  num = 0, curRes = 0, res = 0;
        char opr = '+';
        for (int i = 0; i < n; ++ i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num =  num * 10 + (c - '0');
            } else if (c == '(') {
                int j = i, cnt = 0;
                for (; i < n; ++ i) {
                    if (s.charAt(i) == '(') ++ cnt;
                    if (s.charAt(i) == ')') -- cnt;
                    if (cnt == 0) break;
                }
                num = calculate(s.substring(j + 1, i));
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n -1) {
                switch(opr) {
                    case '+': curRes += num; break;
                    case '-': curRes -= num; break;
                    case '*': curRes *= num; break;
                    case '/': curRes /= num; break;
                }
                if (c == '+' || c == '-' || i == n -1) {
                    res += curRes;
                    curRes = 0;
                }
                opr = c;
                num = 0;
            }
        }

        return res;
    }
    public static boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE, y1 = Integer.MAX_VALUE, area = 0;
        Map<Integer, Map<Integer, Integer>> timelines = new HashMap<>();
        for (int[] r : rectangles) {
            x1 = Math.min(r[0], x1);
            y1 = Math.min(r[1], y1);
            x2 = Math.max(r[2], x2);
            y2 = Math.max(r[3], y2);

            Map<Integer, Integer> upRoutes = timelines.getOrDefault(r[0], new HashMap<>());
            if (upRoutes.containsKey(r[1])) {
                System.out.println("r[1]" + r[1]);
                return false;}
            upRoutes.put(r[1], r[3]);
            timelines.put(r[0], upRoutes);

            Map<Integer, Integer> downRoutes = timelines.getOrDefault(r[2], new HashMap<>());
            if (downRoutes.containsKey(r[3])) {
                System.out.println("r[3]" + downRoutes.get(r[3]));
                System.out.println("r[3]" + r[0]);
                System.out.println("r[3]" + r[3]);
                return false;
            }
            downRoutes.put(r[3], r[1]);
            timelines.put(r[2], downRoutes);
        }
        System.out.println("hello xx1= " + x1);
        // handle left line
        Map<Integer, Integer> leftUpRoutes = timelines.getOrDefault(x1, new HashMap<>());
        int curPos = y1;
        while (!leftUpRoutes.isEmpty() || curPos < y2) {
            System.out.println("hello curPos=" + curPos + "yes=" + leftUpRoutes.containsKey(curPos));
            if (!leftUpRoutes.containsKey(curPos)) return false;

            int nxPos = leftUpRoutes.get(curPos);
            leftUpRoutes.remove(curPos);
            curPos = nxPos;
        }
        if (!leftUpRoutes.isEmpty()) return false;
        System.out.println("hello");
        // handle right line
        Map<Integer, Integer> rightDownRoutes = timelines.getOrDefault(x2, new HashMap<>());
        curPos = y2;
        while (!rightDownRoutes.isEmpty() || y1 < curPos) {
            if (!rightDownRoutes.containsKey(curPos)) return false;
            int nxPos = rightDownRoutes.get(curPos);
            rightDownRoutes.remove(curPos);
            curPos = nxPos;
        }
        if (!rightDownRoutes.isEmpty()) return false;

        // handle mid lines
        for (Map.Entry<Integer, Map<Integer, Integer>> e : timelines.entrySet()) {
            curPos = y2;
            Map<Integer, Integer> line = e.getValue();
            while (!line.isEmpty()) {
                if (!line.containsKey(curPos)) return false;
                int nxPos = line.get(curPos);
                line.remove(curPos);
                curPos = nxPos;
            }
            if (!line.isEmpty()) return false;
        }
        return true;
    }
}
