class Node{
     int data;
     Node prev;
     Node next;
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

   
}
class MergeSortDLL{
    static Node head ;
    MergeSortDLL(){
        this.head = null;
    }
    
    void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            
        }
        else{
            Node temp = head;
            while(temp.next!= null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp; 
        }
    }

     void display(Node head){
            Node temp = head;
            while(temp!= null){
                 System.out.print(temp.data);
                    System.out.print("->");
                   temp = temp.next;

             }
             System.out.println();
           
        }

     Node mergeSort(Node head){
        if(head == null || head.next == null) return head;
        
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // System.out.println(fast.data);
        // System.out.println(slow.data);
        
        
        Node mid = slow;
        Node nextOfMid = mid.next;
        mid.next = null;
        nextOfMid.prev = null;
        display(head);
        display(nextOfMid);
        head = mergeSort(head);
        nextOfMid = mergeSort(nextOfMid);
        head = merge(head,nextOfMid);
        return head;
    }
    Node merge(Node left, Node right){
        

        if(left == null) return right;
        if(right == null) return left;
        
        if(left.data < right.data){
            left.next = merge(left.next,right);
            left.next.prev = left;
            return left;
        }
        right.next = merge(left,right.next);
        right.next.prev = right;
        return right;
    }

    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4};
        int n = arr.length;
        MergeSortDLL dll = new MergeSortDLL();
        for(int i = 0 ;  i < n ; i++){
            dll.insert(arr[i]);
            System.out.println(i);
        }
     
        dll.head = dll.mergeSort(head);
        dll.display(head);


    }


}