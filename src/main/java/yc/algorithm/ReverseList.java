package yc.algorithm;

/**
 * 单向链表反转
 */
public class ReverseList {

    static Node reverse(Node list) {
        Node cur = list, pre = null, tmp;
        while (cur != null) {
            //用tmp暂存当前节点的下一个节点
            tmp = cur.next;
            //将当前节点指向pre
            cur.next = pre;
            //cur pre都向后移动一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node list = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        Node tmp = reverse(list);
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}