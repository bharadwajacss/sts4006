import java.util.*;


class Graph{
    
    LinkedList<Integer>[] adj ;

    

     Graph(int vertices) {
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int s, int d){
        adj[s].add(d);
        adj[d].add(s);
    }

    void dfs(int source){
        boolean[] isVisited = new boolean[adj.length];
        Stack<Integer> st = new Stack<>();

        st.push(source);
        isVisited[source] = true;

        while(!st.isEmpty()){
            int top = st.peek();
            System.out.println(top);
            st.pop();
            for(Integer i : adj[top]){
                if(!isVisited[i]) {
                    st.push(i);
                    isVisited[i] = true;
                }
            }
        }
        


    }

}


class TreeTraversal{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges  = sc.nextInt();
        // int vertices = 6;
        // int edges = 6;

        

        Graph g = new Graph(vertices);
        for(int i = 0 ; i < edges ; i++ ){
                int s = sc.nextInt();
                int d = sc.nextInt();
                g.addEdge(s,d);
        }
        int source = sc.nextInt();
        System.out.println("DFS Traversal");
        g.dfs(source);

    }
}