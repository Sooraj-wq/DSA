import java.util.*;

public class CustomGraph{

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

        //METHOD - BFS
        //Works for both disconnected and connected graphs, for disconnected graphs, loops are made outside the calling function
         boolean vis[] = new boolean[V];
        /*for(int i=0; i<V; i++){
            if(vis[i] == false){
                bfs(graph, V, vis, i);
            }
        } */
        
        //METHOD - print 2's neighbours
        /*for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest+", "+e.wt);
        }*/

        dfs(graph, 0, vis);

        //Question - similar to broken links in bfs, try to devise the process to print unconnected nodes in dfs

    }
}