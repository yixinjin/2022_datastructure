package com.imooc.datastructure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    private TreeNode root;
    private int size;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    // 向树中添加元素
    public void add(int val) {
        this.root = this.add(this.root, val);
        this.size++;
    }

    // 递归思想：向以node为根节点的子树添加元素
    private TreeNode add(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (node.val == val) return node;
        if (val > node.val) {
            node.right = add(node.right, val);
        } else {
            node.left = add(node.left, val);
        }
        return node;
    }

    // 查找某一个元素是不是在树中
    public boolean contains(int val) {
        return this.contains(this.root, val);
    }

    // 递归思想：在以node为根节点的子树中查找元素
    private boolean contains(TreeNode node, int val) {
        if (node == null) return false;
        if (node.val == val) return true;
        if (val > node.val) {
            return contains(node.right, val);
        } else {
            return contains(node.left, val);
        }
    }

    // 找到树中最小的节点
    public TreeNode min() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Find min failed, empty tree");
        }
        return min(this.root);
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    // 删除树中最小的节点
    public TreeNode removeMin() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Remove min failed, empty tree");
        }
        TreeNode minNode = this.min();
        this.root = removeMin(this.root);
        this.size--;
        return minNode;
    }

    // 删除以node为根节点的子树中的最小node，并且返回该根节点
    // 因为有可能根就是最小的node，所以根会变
    private TreeNode removeMin(TreeNode node) {
        // 这个地方一定要注意，在node的左叶子是空的情况下，要返回node的右叶子，而不是返回null
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return node;
    }

    // 找到树中最大的节点
    public TreeNode max() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Find max failed, empty tree");
        }
        this.size--;
        return max(this.root);
    }

    private TreeNode max(TreeNode node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    // 删除树中最大的节点
    public TreeNode removeMax() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Remove max failed, empty tree");
        }
        TreeNode maxNode = this.max();
        this.root = removeMax(this.root);
        return maxNode;
    }

    // 删除以node为根节点的子树中的最大node，并且返回该根节点
    // 因为有可能根就是最大的node，所以根会变
    private TreeNode removeMax(TreeNode node) {
        // 这个地方一定要注意，在node的右叶子是空的情况下，要返回node的左叶子，而不是返回null
        if (node.right == null) return node.left;
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(int val) {
        this.root = this.remove(this.root, val);
    }

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) return null;
        if (val > node.val ) {
            node.right = remove(node.right, val);
            return node;
        } else if (val < node.val) {
            node.left = remove(node.left, val);
            return node;
        } else { // val == node.val
            if (node.left == null) {
                TreeNode rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                TreeNode leftNode = node.left;
                size--;
                return leftNode;
            }
            // 左右子树都有元素，所以需要找到要删除的以这个node的右节点为
            // 根节点的子树的最小的node作为successor
            TreeNode successor = this.min(node.right);

            // 这一行要注意，在调用这个private removeMin方法的额时候，return node要接住
            successor.right = this.removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    // 中序遍历树
    public void inOrderTraverse() {
        if (this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }
        System.out.print("In order: ");
        this.inOrder(this.root);
        System.out.println();
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    // 前序遍历树
    public void preOrderTraverse() {
        if (this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }
        System.out.print("Pre order: ");
        this.preOrder(this.root);
        System.out.println();
    }

    private void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 后序遍历树
    public void postOrderTraverse() {
        if (this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }
        System.out.print("Post order: ");
        this.postOrder(this.root);
        System.out.println();
    }

    private void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    // 前序遍历的非递归写法
    public void preOrderNonRec() {
        if (this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }

        System.out.print("Pre order non-rec: ");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this.root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        System.out.println();
    }

    // 二分搜索树的层序遍历，将node一层一层的打印出来
    public void levelOrderTraverse() {
        if (this.isEmpty()) {
            System.out.println("Empty Tree");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this.root);

        System.out.print("Level order: ");
        while(!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            System.out.print(cur.val + " ");
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        System.out.println();

    }
}
