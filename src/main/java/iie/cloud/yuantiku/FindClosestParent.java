package iie.cloud.yuantiku;

import iie.cloud.bean.Beans.*;
import iie.cloud.util.TreeUtil;

import java.util.ArrayList;

/**
 * @Author wangwenan
 * @data 2018/8/25 14:52
 * 找到普通二叉树中两个节点的最近父节点
 */
public class FindClosestParent {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree(7);
        TreeNode node1 = root.left.left;
        TreeNode node2 = root.right.left;
        TreeNode parent = find(root, node1, node2);
        System.out.println(parent == null ? -1 : parent.val);
    }

    /**
     * 方法1：直接找出root到两个节点的路径，然后比较
     */
    public static TreeNode find(TreeNode root, TreeNode node1, TreeNode node2) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        findPath(root, node1, list1);
//        System.out.println();
//        System.out.println();
        findPath(root, node2, list2);
        TreeNode parent = null;
//        System.out.println("size: " + list1.size() + " " + list2.size());
        for(int i = 0; i < list1.size() && i < list2.size(); i++) {
            parent = (list1.get(i) == list2.get(i)) ? list1.get(i) : parent;
        }
        return parent;
    }

    /**
     * 返回root到node的路径，该方法带返回值在找到时可以直接结束遍历
     * @param root
     * @param node
     * @param list
     * @return
     */
    public static ArrayList<TreeNode> findPath(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
        if (root == null) return null;
        list.add(root);
//        System.out.println(root.val);
        if (root == node) return list;
        ArrayList<TreeNode> left = findPath(root.left, node, list);;
        ArrayList<TreeNode> right = null;
        if(left == null) {
            right = findPath(root.right, node, list);
        }
        if(left == null && right == null) list.remove(root);
        return left != null ? left : right;
    }

    /**
     * 使用递归搜索的方法，当root非空时，对root->left和root->right分别进行搜索。
     * 若搜索结果均非空，说明两个节点分别位于左右子树之中，最近父节点则为root；
     * 若只有一个结果为空，则LCA是另一个非空的节点；
     * 若结果均空，则返回NULL。
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public static TreeNode findLowestAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null) return null;
        if(root == node1 || root == node2) return root;
        TreeNode left = findLowestAncestor(root.left, node1, node2);
        TreeNode right = findLowestAncestor(root.right, node1, node2);
        if(left != null && right != null) {  // 两个节点分别在当前root节点的两棵子树上
            return root;
        }
        // 左子树中或者右子树存在要找的节点，或者都没有
        return left != null ? left : right;
    }
}
