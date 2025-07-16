//Q1 - All paths from source to target

import java.util.*;

public class CustomGraph2{

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

            graph[0].add(new Edge(0, 1, 1));
            graph[0].add(new Edge(0, 2, 1));
            graph[1].add(new Edge(1, 0, 1));
            graph[1].add(new Edge(1, 3, 1));
            graph[2].add(new Edge(2, 0, 1));

            graph[2].add(new Edge(2, 4, 1));
            graph[3].add(new Edge(3, 1, 1));
            graph[3].add(new Edge(3, 4, 1));
            graph[3].add(new Edge(3, 5, 1));
            graph[4].add(new Edge(4, 2, 1));
            graph[4].add(new Edge(4, 3, 1));
            graph[4].add(new Edge(4, 5, 1));
            graph[5].add(new Edge(5, 3, 1));
            graph[5].add(new Edge(5, 4, 1));
            graph[5].add(new Edge(5, 6, 1));
            graph[5].add(new Edge(6, 5, 1));
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

    //O(V^V) time complexity due to repeated recursive calls on same node
    public static void printAllPath(ArrayList<Edge> graph[],boolean vis[],int curr, String path,int tar){
        
        if(curr == tar){
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==false){
                vis[curr] = true; //to avoid visiting same node on current iteration
                printAllPath(graph, vis, e.dest, path+e.dest, tar);
                vis[curr] = false; //backtrack
            }
        }

    }

    public static void main(String[] args) {
       
        int V = 7; //Number of vertices
                /*
        1 -------3
        /       | \
        0       | 5 -- 6
        \      | /
        2 ---- 4
        */

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0, tar = 5; 
        printAllPath(graph, new boolean[V], src, "0", tar);

        //Question - print all paths from source to target
        //HINT - an extra path variable is added in dfs algorithm, visited column is not needed because we need to visit a node multiple times.



    }
}