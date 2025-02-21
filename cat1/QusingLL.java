class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next  = null;
    }
}

class QusingLL{
    static Node front;
    static Node rear;
    QusingLL(){
        this.front = null;
        this.rear = null;
    }

    static boolean isEmpty(){
        return front==null;
    }

    static void enque(int data){
        
        Node newNode = new Node(data);

        if(rear == null){
            front = newNode;
            rear = newNode;

        }

        else{

            rear.next = newNode;
            rear = newNode;
        }
    } 

    static int deque(){
        if(rear == null){
            System.out.println("Empty");
            return -1;
        }
       

        else{
            int data = front.data;
            front = front.next;
            System.out.println(data);
            return data;
        }
    }

    static int peek(){
        if(isEmpty()){
            return -1;
        }
        System.out.println(front.data);
        return front.data;
    }


    public static void main(String[] args){
        QusingLL q = new QusingLL();
        q.enque(10);
        q.enque(20);
        q.enque(30);
        q.deque();
        q.deque();
        q.deque();



        
    }
}