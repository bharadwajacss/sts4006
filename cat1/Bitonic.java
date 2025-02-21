class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

class Bitonic{

    static Node insert(Node head, int data){
        Node newNode  = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            return head;
        }
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data);
            System.out.print("->");
            temp = temp.next;

        }
    }

    static Node merge(Node left, Node right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.data < right.data){
            left.next = merge(left.next, right);
            if(left.next != null){
                left.next.prev = left;
            }
            left.prev = null; // Ensure the previous pointer of the left node is null
            return left;
        }
        else{
            right.next = merge(left, right.next);
            if(right.next != null){
                right.next.prev = right;
            }
            right.prev = null; // Ensure the previous pointer of the right node is null
            return right;
        }
    }

    static Node findPeak(Node head){
        Node front = head.next;
        Node back = head;
        
        while(front!=null && front.data > back.data){
            back = front;
            front = front.next;
        }
        return back;
    }

   static  Node bitonicSort(Node head){
        Node peak = findPeak(head);
        Node newHead = peak.next;
        peak.next = null;
        newHead.prev = null;

        newHead = reverse(newHead);
        
        head = merge(head, newHead);
        return head;
    }

    static Node reverse(Node head ){
        Node one = null;
        Node two = head;
        Node three = head.next;
        
        while(three != null){
            two.prev = three;
            two.next = one;
            one = two;
            two = three;
            three = three.next;
        }
        two.prev = null;
        two.next = one;
        return two;
    }

    public static void main(String[] args){

        int[] arr = {5,6,7,8,9,4,3,2,1};
        int n = arr.length;
        
        Bitonic dll = new Bitonic();
        
        Node head = null;

        for(int i = 0 ; i  < n ; i++){
            head = insert(head,arr[i]);
        }
          printList(head);
           System.out.println();
        head = bitonicSort(head);
        printList(head);
       
    }
}