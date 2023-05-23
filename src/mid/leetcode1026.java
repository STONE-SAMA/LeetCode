package mid;

import javax.swing.tree.TreeNode;

public class leetcode1026 {
    private int ans;

//    public int maxAncestorDiff(TreeNode root) {
//        dfs(root, root.val, root.val);
//        return ans;
//    }
//
//    public void dfs(TreeNode node, int min, int max) {
//        if (node == null) {
//            return;
//        }
//        min = Math.min(min, node.val);
//        max = Math.max(max, node.val);
//        ans = Math.max(ans, Math.max(node.val - min, max - node.val));
//        dfs(node.left, min, max);
//        dfs(node.right, min, max);
//    }
}
