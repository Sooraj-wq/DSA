//Shortest path from source to destination

import java.util.*;

public class DijkstrasAlgo{

    //A pair class is created
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n,int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){ //A pair p2 object is compared to this pair using distance as a factor
            return this.dist - p2.dist; //Ascending order sort
        }
    }

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

            graph[0].add(new Edge(0, 1,2));
            graph[0].add(new Edge(0, 2,4));
            graph[1].add(new Edge(1, 3,7));
            graph[1].add(new Edge(1, 2,1));
            graph[2].add(new Edge(2, 4,3));
            graph[3].add(new Edge(3, 5,1));
            graph[4].add(new Edge(4, 3,2));
            graph[4].add(new Edge(4, 5,5));
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
    //O(E+ElogV) the ElogV complexity comes from priority queue
    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){
    
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int dist[] = new int[V];
        
        for(int i=0; i<V; i++){     //Initialise all distances to infinity
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove(); //Shortest
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<V; i++){
            System.out.print(dist[i]+" ");
        }

    }



    public static void main(String[] args) {
       
        int V = 6; 

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        dijkstra(graph, 0, V);
    }
}