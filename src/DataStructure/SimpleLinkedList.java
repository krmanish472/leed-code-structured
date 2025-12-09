package DataStructure;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}


public class SimpleLinkedList {
    Node head;
    Node tail;

    public void insert(int val) {
        Node node = new Node(val);

        // if head is null, add as first node
        if (head == null) {
            head = node;
        } else {
            // else append to the last node
            tail.next = node;
        }

        tail = node;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node cur = head; // copy head in current so we don't lose head
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next; // keep track of next node
            cur.next = prev; // actual reversal

            prev = cur;
            cur = next;
        }
        return prev; // prev is new head
    }

    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Initial list");
        list.display();
        System.out.println();

        list.head = list.reverse(list.head);
        System.out.println("After reversing => ");
        list.display();
    }

}
