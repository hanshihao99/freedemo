package leetcode;

import apple.laf.JRSUIUtils;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/07/06/18:53
 */
public class TwoTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(11);

        int dep = Dep(root);
        System.out.println(dep);

    }

    public static int Dep(TreeNode root){
        return root == null ? 0 : Math.max(Dep(root.left) , Dep(root.right)) + 1;
    }
}
class TreeNode{
        int val;
        TreeNode left ;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val , TreeNode left , TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

}







