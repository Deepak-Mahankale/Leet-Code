class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int LN = maxDepth(root.left);
        int RN = maxDepth(root.right);

        int hgt = Math.max(LN, RN) + 1;
        return hgt;
    }
}