package useJava;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class No0144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        list.add(root.getVal());
        dfs(root.getLeft(),list);
        dfs(root.getRight(),list);
    }

    public static void main(String[] args) {
        List<Integer> integers = new No0144().preorderTraversal(TreeNode.Companion.getSampleTree());
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
