import java.util.Scanner;


class BinaryTree{

    static class Node{

        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }



    static Node buildTree(String[] s){
        if(s[0] == null) return null;

        Node root = new Node(parseInt(s[0]));
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        
        int i = 1;

        while(!q.isEmpty() && i<s.length){

            Node temp = q.poll();
            String curr = s[i];
            
            if(curr != "-1"){
                temp.left = new Node(parseInt(curr));
                q.add(temp.left);
            }
            i++;
            String curr = s[i];
            if(curr != "-1"){
                temp.right = new Node(parseInt(curr));
                q.add(temp.right);
            }
            i++;

        }


        return root;


    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split();

        Node root = buildTree(s);

        System.out.println(root.data);

    }





}