package yc.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrderTraverse {
    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(Node<Integer> node) {
        if (node == null)
            return;
        inOrderTraverse(node.getLeft());
        System.out.print(node.getData());
        inOrderTraverse(node.getRight());
    }

    public static void levelOrderTraverse(Node<Integer> node) {
        if(node == null) {
            return;
        }
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Node<Integer> curNode = queue.poll();
                System.out.print(curNode.getData());
                if (curNode.getLeft() != null) {
                    queue.offer(curNode.getLeft());
                }
                if (curNode.getRight() != null) {
                    queue.offer(curNode.getRight());
                }
            }
        }
    }

    public static void main(String[] args) {
//        BTree bTree1 = new BTree();
//        bTree1.buildByLinkedList();
//
//        // nodeList中第0个索引处的值即为根节点
//        Node<Integer> root1 = bTree1.nodeList.get(0);
//        System.out.println("中序遍历：");
//        inOrderTraverse(root1);
//        System.out.println();
//        System.out.println("层次遍历" + root1.getData());
//        levelOrderTraverse(root1);
//        System.out.println();



        BTree bTree2 = new BTree();
        for (int i : bTree2.array) {
            bTree2.insert(i);
        }
        Node<Integer> root2 = bTree2.root;
        System.out.println("中序遍历：");
        inOrderTraverse(root2);
        System.out.println();
        System.out.println("层次遍历" + root2.getData());
        levelOrderTraverse(root2);
        System.out.println();
    }
}
