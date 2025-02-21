
import java.util.*;

class StackPermutation{
    
    
    static boolean isStackPermutation(int[] arr, int[] mem, int n){
        Stack<Integer> st = new Stack<Integer>();
        
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            st.push(arr[i]);
            while(!st.isEmpty() && mem[j]==st.peek()){
                st.pop();
                j++;
            }
        }
        
        return st.isEmpty();
    }
    
    
    public static void main(String[] args){
        
        int[] arr = {1,2,3};
        int[] mem = {3,1,2};
        if(isStackPermutation(arr,mem,arr.length)){
            System.out.println("yes");
        }else  {System.out.println("No");}
    }
}