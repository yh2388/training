package yc.algorithm.tree;

import java.util.Stack;

/**
 * 交换左右子树
 */
public class SwapTree<T> {

    /**
     * 非递归实现
     * @param root
     */
    public void swap(Node<T> root) {
        if(root == null) {
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node<T> node = stack.peek();
            if(node.getLeft() == null && node.getRight() == null) {
                node.setVisited(true);
                stack.pop();
                continue;
            }

            if(node.getLeft() != null) {
                if(!node.getLeft().isVisited()) {
                    stack.push(node.getLeft());
                }
            }

            if((node.getLeft() == null || node.getLeft().isVisited()) && node.getRight() != null) {
                if(!node.getRight().isVisited()) {
                    stack.push(node.getRight());
                }
            }

            if((node.getLeft() == null || node.getLeft().isVisited()) && (node.getRight() == null || node.getRight().isVisited())) {
                Node<T> tmp = node.getLeft();
                node.setLeft(node.getRight());
                node.setRight(tmp);
                node.setVisited(true);
                stack.pop();
            }
        }
    }


    /**
     * 递归实现
     * @param root
     */
    public void recursionSwap(Node<T> root) {
        if (root == null) {
            return;
        }

        Node<T> tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);
        recursionSwap(root.getLeft());
        recursionSwap(root.getRight());
    }

    public static void main(String[] args) {
        SwapTree<Integer> swapTree = new SwapTree<>();
        BTree bTree = new BTree();
        bTree.buildByLinkedList();

        Node<Integer> root = bTree.nodeList.get(0);
        OrderTraverse.inOrderTraverse(root);
        System.out.println();
        swapTree.swap(root);
        OrderTraverse.inOrderTraverse(root);
        System.out.println();

        // 重置
        bTree.buildByLinkedList();
        root = bTree.nodeList.get(0);
        OrderTraverse.inOrderTraverse(root);
        System.out.println();
        swapTree.recursionSwap(root);
        OrderTraverse.inOrderTraverse(root);

    }
}
