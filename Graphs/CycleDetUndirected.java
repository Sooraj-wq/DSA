//Code to detect cycle in an undirected graph using modified DFS

import java.util.*;

public class CycleDetUndirected{

    static class Edge {
        
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

            graph[0].add(new Edge(0, 1));
            graph[0].add(new Edge(0, 4));
            graph[1].add(new Edge(1, 0));
            graph[1].add(new Edge(1, 2));
            graph[1].add(new Edge(1, 4));
            graph[2].add(new Edge(2, 1));
            graph[2].add(new Edge(2, 3));
            graph[3].add(new Edge(3, 2));
            graph[4].add(new Edge(4, 0));
            graph[4].add(new Edge(4, 1));
            graph[4].add(new Edge(4, 5));
            graph[5].add(new Edge(5, 4));
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

    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par){
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && e.dest != par){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleUndirected(graph, vis, e.dest, par)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
       
        int V = 6; 

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));



    }
}