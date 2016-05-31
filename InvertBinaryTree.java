/** <FROM leetcode.com>
 *   
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
            
        helperInvert(root);
        return root; 
    }
    
    
    public void helperInvert(TreeNode current) {
            TreeNode temp = current.right;
            current.right = current.left;
            current.left = temp;
            if (current.left != null)
                helperInvert(current.left);
            if (current.right != null)
                helperInvert(current.right);
    }
       
}