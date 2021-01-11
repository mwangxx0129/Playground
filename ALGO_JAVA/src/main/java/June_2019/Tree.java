package June_2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<Dir> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            stack.push(new Dir(1, root));

            while (!stack.isEmpty()) {
                Dir cur = stack.pop();
                if (cur.node == null) continue;
                if (cur.dir == 0) {
                    res.add(cur.node.val);
                } else {
                    stack.push(new Dir(0, cur.node));
                    stack.push(new Dir(1, cur.node.right));
                    stack.push(new Dir(1, cur.node.left));
                }
            }
            return res;
        }

        class Dir {
            TreeNode node;
            int dir; // 0: value, 1: oper
            Dir(int dir, TreeNode node) {
                this.dir = dir;
                this.node = node;
            }
        }

        public int getShortestTime() {
            return 0;
        }
    }
}

