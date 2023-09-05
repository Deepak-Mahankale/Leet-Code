class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root == null) {
            return ans;
        }
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                root = st.pop();
                ans.add(root.val);
                root = root.right;

            }
        }
        return ans;
    }
}