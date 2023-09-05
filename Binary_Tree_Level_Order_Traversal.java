import java.util.*;

class Solution {
    List<List<Integer>> ll = new ArrayList<>();

    public void levelOrderList(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                sublist.add(q.remove().val);
            }
            ll.add(sublist);
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderList(root);
        return ll;

    }
}