public class LinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Method to add elements to the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to create a loop in the linked list
    public void createLoop(int position) {
        if (position <= 0) return;
        Node loopNode = null;
        Node temp = head;
        int count = 1;
        while (temp.next != null) {
            if (count == position) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        if (loopNode != null) {
            temp.next = loopNode;
        }
    }

    // Method to detect loop using fast and slow pointers
    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Create a loop at position 3
        list.createLoop(3);

        // Detect loop
        if (list.detectLoop()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}