import java.util.*;

class Celebrity{


    static boolean knows(int a, int b, int[][] mat){
        return mat[a][b] == 1;
    }

    static int findCelebrity(int[][] mat,int n){
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            st.push(i);
        }

        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            if(knows(a,b,mat)){
                st.push(b);
            }
            else{
                st.push(a);
            }
        }

        int c = st.pop();

        for(int i = 0 ; i < n ; i++){

            if(i==c){
                continue;
            }
            if(!knows(i,c,mat) || knows(c,i,mat)){
                return -1;
            }
           
        }
         return c;

    }


    public static void main(String[] args){
        int n = 4;
        int[][] matrix = { { 0, 0, 1, 0 },
                           { 0, 0, 1, 0 },
                           { 0, 0, 0, 0 },
                           { 0, 0, 1, 0 } };


        int ans = findCelebrity(matrix,n);

        System.out.print(ans);

    }
}