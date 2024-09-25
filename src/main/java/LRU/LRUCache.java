package LRU;

import java.util.HashMap;
import java.util.Map;

// An LRU (Least Recently Used) Cache is a type of cache that evicts the least recently used items when the cache reaches its capacity.

// A Least Recently Used (LRU) cache is a data structure that evicts the least recently used item when the cache reaches its maximum capacity.
// It is designed to efficiently maintain a set of key-value pairs while ensuring that frequently accessed items are kept in memory,
// and those that haven’t been accessed recently are evicted.

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list; // you can use LinkedList,it was working

    // Node class for doubly linked list
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    void add(int key,int value){
        Node node = new Node(key,value);

    }

    // DoublyLinkedList class for managing nodes
    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1); // Dummy head
            tail = new Node(-1, -1); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }

        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        Node removeLast() {
            if (head.next == tail) {
                return null; // List is empty
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            list.remove(node);
            node.value = value;
            list.addFirst(node);
        } else {
            if (cache.size() >= capacity) {
                Node last = list.removeLast();
                if (last != null) {
                    cache.remove(last.key);
                }
            }
            Node newNode = new Node(key, value);
            list.addFirst(newNode);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}

