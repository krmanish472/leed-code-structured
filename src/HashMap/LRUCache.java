package HashMap;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head; // MRU
    private final Node tail; // LRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAtHead(node); // make it MRU
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) { // update the node value if already present
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node); // make it MRU
        } else { // if map is full...
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode); // make it MRU
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // head - 10 - 20 - X - Y ---
    private void insertAtHead(Node node) {
        // connect node with old node
        node.next = head.next;
        node.next.prev = node;

        // connect node with head
        head.next = node;
        node.prev = head;
    } // head - 20 - 10 - X -Y
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * HashMap.LRUCache obj = new HashMap.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */