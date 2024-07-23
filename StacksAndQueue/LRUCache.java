import java.util.HashMap;

public class LRUCache {
    
    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> map;
    private int count;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1);
        head.prev = null;
        tail = new Node(-1,-1);
        tail.next = null;
        tail.prev = head;
        head.next = tail;
        this.capacity = capacity;
        this.count = 0;
    }

    public void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public void popNode() {
        Node last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
    }

    public int get(int key) {
        if(!map.containsKey(key) || map.get(key) == null) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {

        Node node = map.get(key);

        if(node == null) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            node = newNode;
            ++count;

            //deleting the tail
            if(count > capacity) {
                Node last = tail.prev;
                map.remove(last.key);
                popNode();
                count--;
            }

            moveToHead(newNode);
        }
        else {
            node.value = value;
            deleteNode(node);
            moveToHead(node);
        }
    }
}

class Node {
    public int value;
    public int key;
    public Node prev;
    public Node next;

    Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    Node(int key, int value) {
        this.value = value;
        this.key = key;
    }

    Node(){}
}
