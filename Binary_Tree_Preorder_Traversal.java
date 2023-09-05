class Solution {
    List<Integer> li = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return li;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        li.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return;
    }
}