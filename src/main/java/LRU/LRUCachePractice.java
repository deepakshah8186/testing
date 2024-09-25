package LRU;

import java.util.HashMap;
import java.util.LinkedList;

class Node {
    int x;
    int y;
    Node next;
    Node prev;

    Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class LRUCachePractice {
    private int capacity;
    private HashMap<Integer,Node> cache;
    private LinkedList list;

    public LRUCachePractice(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        list = new LinkedList();
    }

    public int get(int y){
        if(cache.containsKey(y)){
            Node node = cache.get(y);
            list.remove(node);
            list.addFirst(node);
            return node.y;
        }
        return -1;
    }

    public void put(int key,int value) {

        if(cache.containsKey(key)){
            Node current = cache.get(key);
            list.remove(current);
            current.y = value;
            list.addFirst(current);

        } else {
            if(cache.size() >= capacity){
                 Node last  = (Node) list.removeLast();
                 cache.remove(last.x);

            }
            Node node = new Node(key,value);
            list.addFirst(node);
            cache.put(key,node);

        }
    }

    public static void main(String[] args){
        LRUCachePractice cache = new LRUCachePractice(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));



    }
}
