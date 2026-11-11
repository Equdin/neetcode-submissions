/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayList<Integer> rootArr = new ArrayList<>();
        ArrayList<Integer> subArr = new ArrayList<>();

        serialize(root, rootArr);
        serialize(subRoot, subArr);

        return Collections.indexOfSubList(rootArr, subArr) != -1;
    }

    private void serialize(TreeNode node, ArrayList<Integer> data) {
        if (node == null) {
            data.add(null);
            return;
        }

        data.add(node.val);
        serialize(node.left, data);
        serialize(node.right, data);
    }
}
