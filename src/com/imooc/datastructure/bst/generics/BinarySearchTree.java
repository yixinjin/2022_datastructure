package com.imooc.datastructure.bst.generics;

public class BinarySearchTree <E extends Comparable<E>>{

    private class TreeNode {
        private E val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

    private TreeNode root;
    private int size;

    // 增加一个node,
    public void add(E val) {
        this.root = add(this.root, val);
        this.size++;
    }

    // 在recursion的操作里，我们操作的都是以node为根的子树，所以
    // 每次操作完，我们还要返回新的根节点，这个根节点有可能还是以前的node
    // 但是也有可能是更新后的node
    private TreeNode add(TreeNode node, E val) {
        if (node == null)
            return new TreeNode(val);
        else if (val.compareTo(node.val) > 0) {
            node.right = add(node.right, val);
            return node;
        } else if (val.compareTo(node.val) < 0) {
            node.left = add(node.left, val);
            return node;
        }
        // 不支持插入重复元素
        return node;
    }

    public boolean contains(E val) {
        return contains(this.root, val);
    }

    private boolean contains(TreeNode node, E val) {
        if (node == null) return false;
        if (node.val == val) {
            return true;
        } else if (val.compareTo(node.val) > 0) {
            return contains(node.right, val);
        } else
            return contains(node.left, val);
    }

    public void inOrder() {
        if (isEmpty()) return;
        System.out.print("In order: ");
        this.inOrderTraverse(this.root);
        System.out.println();
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null) return;

        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }

    public E minimum() {
        if (isEmpty()) return null;
        return minNode(this.root).val;
    }

    private TreeNode minNode(TreeNode node) {
        if (node.left == null) return node;
        return minNode(node.left);
    }

    public E removeMin() {
        E min = this.minimum();
        this.root = removeMin(this.root);
        return min;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return node;
    }

    public E maximum() {
        if (isEmpty()) return null;
        return maxNode(this.root).val;
    }

    private TreeNode maxNode(TreeNode node) {
        if (node.right == null) return node;
        return maxNode(node.right);
    }

    public E removeMax() {
        E max = this.maximum();
        this.root = removeMax(this.root);
        return max;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) return node.left;
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E val) {
        this.root = remove(this.root, val);
    }

    private TreeNode remove(TreeNode node, E val) {
        // 找不到要删除的元素
        if (node == null) return null;

        if (val.compareTo(node.val) > 0) {
            node.right = remove(node.right, val);
            return node;
        }
        else if (val.compareTo(node.val) < 0) {
            node.left = remove(node.left, val);
            return node;
        }
        else {
            if (node.left == null) {
                TreeNode rightNode = node.right; // 保存节点
                size--;
                node.right = null; //释放指针
                return rightNode;
            }

            if (node.right == null) {
                TreeNode leftNode = node.left; // 保存节点
                size--;
                node.left = null; //释放指针
                return leftNode;
            }

            // 删除节点有左右孩子的情况
            // 1. 找到该节点右子树中最小的点作为successor
            // 2. 删除该节点右子树中最小的点
            // 3. 该successor替代该节点的位置，左右孩子为该节点原来的左右节点
            TreeNode successor = this.minNode(node.right);
            successor.right = this.removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
