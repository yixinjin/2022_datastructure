package com.imooc.datastructure.map;

public class BinarySearchTree<K extends Comparable<K>, V>{

    private class TreeNode {
        private K key;
        private V value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }

    private TreeNode root;
    private int size;

    // 增加一个node,
    public void add(K key, V value) {
        this.root = add(this.root, key, value);
        this.size++;
    }

    // 在recursion的操作里，我们操作的都是以node为根的子树，所以
    // 每次操作完，我们还要返回新的根节点，这个根节点有可能还是以前的node
    // 但是也有可能是更新后的node
    private TreeNode add(TreeNode node, K key, V value) {
        if (node == null)
            return new TreeNode(key, value);
        else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
            return node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
            return node;
        }
        // 不支持插入重复元素
        return node;
    }

    public boolean contains(K key) {
        return contains(this.root, key);
    }

    private boolean contains(TreeNode node, K key) {
        if (node == null) return false;
        if (node.key.equals(key)) {
            return true;
        } else if (key.compareTo(node.key) > 0) {
            return contains(node.right, key);
        } else
            return contains(node.left, key);
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
        System.out.print(node + " ");
        inOrderTraverse(node.right);
    }

    public K minimum() {
        if (isEmpty()) return null;
        return minNode(this.root).key;
    }

    private TreeNode minNode(TreeNode node) {
        if (node.left == null) return node;
        return minNode(node.left);
    }

    public K removeMin() {
        K min = this.minimum();
        this.root = removeMin(this.root);
        return min;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return node;
    }

    public K maximum() {
        if (isEmpty()) return null;
        return maxNode(this.root).key;
    }

    private TreeNode maxNode(TreeNode node) {
        if (node.right == null) return node;
        return maxNode(node.right);
    }

    public K removeMax() {
        K max = this.maximum();
        this.root = removeMax(this.root);
        return max;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) return node.left;
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(K key) {
        this.root = remove(this.root, key);
    }

    private TreeNode remove(TreeNode node, K key) {
        // 找不到要删除的元素
        if (node == null) return null;

        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        else {
            if (node.left == null) {
                TreeNode rightNode = node.right; // 保存右节点
                size--;
                node.right = null; //释放指针
                return rightNode;
            }

            if (node.right == null) {
                TreeNode leftNode = node.left; // 保存左节点
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

    public V get(K key) {
        return this.get(this.root, key).value;
    }

    private TreeNode get(TreeNode node, K key) {
        if (node == null) return null;
        if (key.compareTo(node.key) > 0) {
            return get(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else // key equals
            return node;
    }

    public void set(K key, V value) {
        TreeNode node = this.get(this.root, key);
        node.value = value;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
