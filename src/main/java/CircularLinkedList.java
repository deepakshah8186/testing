class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// check chat gpt - how to identify circular linked list in java

public class CircularLinkedList {

    // Function to detect cycle in a linked list
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If we reach here, there is no cycle
        return false;
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle for testing
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creates a cycle

        // Test if the linked list has a cycle
        System.out.println("Has Cycle: " + hasCycle(head));
    }
}
