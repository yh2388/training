package yc.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 使用HashMap加LinkedList的方式构建
 * 2. 包含put()、get()方法
 */
public class LRU {

    //数据节点
    public static class Node {
        private String key;
        private Object value;
        private Node pre;
        private Node next;

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    //双向链表
    public static class DoublyLinkedList {
        private Node head;
        private Node tail;

        public DoublyLinkedList() {}

        public DoublyLinkedList(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }

        // 最近访问的移至队列尾
        public void moveToTail(Node node) {
            if(node == null || tail == node) {
                return;
            }
            if(head == node) {
                head = node.next;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            tail.next = node;
            node.pre = tail;
            node.next = null;
            //实际上指向的是node， 但是不能直接指向前面已经赋值过的node
            tail = tail.next;

        }

        // 新插入的插入队尾
        public void addToTail(Node node) {
            if(node == null) {
                return;
            }
            //首次添加
            if(head == null) {
                head = node;
                tail = node;
            }else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        // 删除头节点
        public Node removeHead() {
            if(head == null) {
                return null;
            }

            Node node  = head;

            if(head == tail) {
                head = null;
                head = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return node;
        }
    }

    private DoublyLinkedList linkedList;
    private Map<String, Node> map;
    private int capacity;

    public LRU(int capacity) {
        this.linkedList = new DoublyLinkedList();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    // put 操作
    public void put(String key, Object value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            //覆盖原值
            node.value = value;
            linkedList.moveToTail(map.get(key));
        } else {
            Node node = new Node(key, value);
            linkedList.addToTail(node);
            map.put(key, node);
            if(map.size() > capacity) {
                Node removed = linkedList.removeHead();
                map.remove(removed.key);
            }
        }
    }

    // get 操作
    public Node get(String key) {
        Node node = map.get(key);
        if (node != null) {
            linkedList.moveToTail(node);
        }
        return node;
    }

    public static void main(String[] args) {

        LRU lru = new LRU(2);

        lru.put("a", 1);
        lru.put("b", 2);
        System.out.println(lru.linkedList.tail);

        lru.get("a");
        System.out.println(lru.linkedList.tail);

        lru.put("c", 3);
        System.out.println(lru.linkedList.tail);
        System.out.println(lru.linkedList);

        System.out.println(lru.linkedList.tail);

    }
}
