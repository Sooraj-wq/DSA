//Q1 - All paths from source to target

import java.util.*;

public class CycleDetection{

    static class Edge {
        
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

            graph[0].add(new Edge(0, 2, 1));
            graph[1].add(new Edge(1, 0, 1));
            graph[2].add(new Edge(2, 3, 1));
            graph[3].add(new Edge(3, 0, 1));
    }

    public static void bfs(ArrayList<Edge> graph[],int V, boolean vis[], int start){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false)
                dfs(graph, e.dest, vis);
        }
    }

    //O(V+E) complexity
    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            } else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec)){
                    return true;
                };
            }
        }

        rec[curr] = false; //Backtracking
        return false;
    }   

    public static void main(String[] args) {
       
        int V = 4; //Number of vertices
        /* 1----0----3
         *      \    /
         *       \  /
         *         2
         */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                boolean isCycle = isCycleDirected(graph, vis, i, rec);
                if(isCycle){
                    System.out.println(isCycle);
                    break;
                }
            }
        }

        /* Note that this also works for 
         * 0---> 1 <----2
         *            / ^
         *          V   |
         *       3----->4
         *  this directed cycle too...see how
         */
        


    }
}