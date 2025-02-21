class Node{
    int data;
    int pr ;
    Node next;
    Node prev;
    Node(int data,int pr){
        this.data = data;
        this.pr = pr;
        this.next = null;
        this.prev = null;
    }
}
class PqUsingDll{

    
    static Node fr ;
    static Node rr ;

    PqUsingDll(){
        this.fr = null;
        this.rr = null;
    }

    void push( int data, int pr){
        Node newNode = new Node(data,pr);
       
        if(fr == null){
            fr = newNode;
            rr = newNode;
        }
        else{
            if(fr.pr <= newNode.pr){
                newNode.next = fr;
                fr.prev = newNode;
                fr = newNode;
                
                
            }
            else if(rr.pr >= newNode.pr){
                rr.next = newNode;
                newNode.prev = rr;
                rr = newNode;
               
                
            }
            else{
                Node temp = fr;
                while(temp != null && temp.pr > newNode.pr){
                    temp = temp.next;
                }
                newNode.next = temp;
                newNode.prev = temp.prev;
                newNode.prev.next = newNode;
                temp.prev = newNode;
                
               
            }
            

        }
        
        
    }
    void display(Node ff){
        Node temp = ff;
        while(temp != null){
            System.out.print(temp.data + "\t");
            System.out.println(temp.pr + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        int[] ele = {12,23,43,11,54,21,3};
        int[] priority = {3,2,1,4,7,8,6};
        int n = ele.length;
        
        PqUsingDll q = new PqUsingDll();
        for(int i = 0 ; i < n ; i++){
            q.push(ele[i],priority[i]);
        }
        
        q.display(fr);
    }

}