package yc.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 构建二叉搜索树
 */
public class BTree {

    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    List<Node<Integer>> nodeList = null;

    public void buildByLinkedList() {
        nodeList = new LinkedList<Node<Integer>>();
        // 将一个数组的值依次转换为Node节点
        for (int i : array) {
            nodeList.add(new Node<Integer>(i));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).setLeft(nodeList.get(parentIndex * 2 + 1));
            // 右孩子
            nodeList.get(parentIndex).setRight(nodeList.get(parentIndex * 2 + 2));
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).setLeft(nodeList.get(lastParentIndex * 2 + 1));
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).setRight(nodeList.get(lastParentIndex * 2 + 2));
        }
    }

    Node<Integer> root;

    public void insert(Integer value) {
        //封装节点
        Node<Integer> newNode = new Node<Integer>(value);
        //引用当前节点
        Node<Integer> current = root;
        //引用父节点
        Node<Integer> parent;
        //如果root为null，也就是第一插入的时候
        if(root==null) {
            root = newNode;
        }else {
            while(true) {
                //父节点指向当前节点
                parent = current;
                //如果当前节点指向的节点数据比插入的要大，则往左走
                if(current.getData() > value) {
                    current = current.getLeft();
                    if(current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                }else {
                    current = current.getRight();
                    if(current==null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

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
        inOrderTraverse(node.getRight());
        System.out.print(node.getData());
    }

    public static void main(String[] args) {
        BTree bTree1 = new BTree();
        bTree1.buildByLinkedList();

        // nodeList中第0个索引处的值即为根节点
        Node<Integer> root1 = bTree1.nodeList.get(0);
        System.out.println("中序遍历：");
        inOrderTraverse(root1);
        System.out.println();



        BTree bTree2 = new BTree();
        for (int i : bTree2.array) {
            bTree2.insert(i);
        }
        Node<Integer> root2 = bTree2.root;
        System.out.println("中序遍历：");
        inOrderTraverse(root2);
        System.out.println();
    }

}
