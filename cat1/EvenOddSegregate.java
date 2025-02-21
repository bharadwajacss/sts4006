class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }

}

class EvenOddSegregate{


    static Node insert(Node head, int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }

    static void display(Node head){
       Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
                System.out.print("->");
                temp = temp.next;

        }
    }

    public static void main(String[] args){

        int[] arr = {1,12,3,13,4,3,32,31};
        int n = arr.length;
        Node evenStart = null;
        Node oddStart = null;
        Node evenEnd = null;
        Node oddEnd = null;
        Node head = null;
        for(int i = 0 ; i < n ; i++){
            head = insert(head, arr[i]);
        }
        Node temp = head;
        while(temp != null ){
            if (temp.data % 2 == 0 ){
                if(evenStart == null){
                    evenStart = temp;
                    temp = temp.next;
                    evenStart.next = null;
                }else {
                    if(evenEnd == null){
                        evenEnd = temp;
                        temp = temp.next;
                        evenEnd.next = null;
                        evenStart.next = evenEnd;
                    }
                    else{
                        evenEnd.next = temp;
                        evenEnd = temp;
                        temp = temp.next;
                        evenEnd.next = null;
                    }
                }
            }else{
                if(oddStart == null){
                    oddStart = temp;
                    temp = temp.next;
                    oddStart.next = null;
                }else {
                    if(oddEnd == null){
                        oddEnd = temp;
                        temp = temp.next;
                        oddEnd.next = null;
                        oddStart.next = oddEnd;
                    }
                    else{
                        oddEnd.next = temp;
                        oddEnd = temp;
                        temp = temp.next;
                        oddEnd.next = null;
                    }
                }
            }
        }


   
        //odd after even 
        oddEnd.next = evenStart;
        display(oddStart);
    }

    
    
}