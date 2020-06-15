import java.util.*;

public class DijkstraAlgorithm {

    static class GraphNode implements Comparator<GraphNode> {
        int node;
        int cost;

        public GraphNode() {};

        public GraphNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(GraphNode node1, GraphNode node2) {
            if(node1.cost < node2.cost) return -1;
            if(node1.cost > node2.cost) return 1;
            return 0;
        }
    }

    private int distance[];
    private Set<Integer> settled;
    private PriorityQueue<GraphNode> pq;
    private int V; // Number of vertices
    private List<List<GraphNode>> graph;

    public DijkstraAlgorithm(int V) {
        this.V = V;
    }

    // Function for Dijkstra's Algorithm
    public void dijkstra(List<List<GraphNode>> graph, int source) {
        this.graph = graph;
        for(int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Add source node to the priority queue
        pq.add(new GraphNode(source, 0));
        distance[source] = 0;
        while(settled.size() != V) {
            // remove the minimum distance node from the min-heap
            int u = pq.remove().node;
            settled.add(u);
            evaluateNeighbors(u);
        }
    }

    /**
     * Function to process all the neighbors of the passed node
     */
    private void evaluateNeighbors(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        // all the neighbors of the node
        for(int i = 0; i < graph.get(u).size(); i++) {
            GraphNode v = graph.get(u).get(i);

            // if the current node hasn't been processed
            if(!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = distance[u] + edgeDistance;

                // if the new distance is cheaper than the cost
                if(newDistance < distance[v.node]) {
                    distance[v.node] = newDistance;
                }
                pq.add(new GraphNode(v.node, distance[v.node]));
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;

        // Adjacency list representing the nodes
        List<List<GraphNode>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            List<GraphNode> nodes = new ArrayList<>();
            graph.add(nodes);
        }

        // Calculate the single source shortest path
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(V);

        graph.get(0).add(new GraphNode(1, 9));
        graph.get(0).add(new GraphNode(2, 6));
        graph.get(0).add(new GraphNode(3, 5));
        graph.get(0).add(new GraphNode(4, 3));
        graph.get(2).add(new GraphNode(1, 2));
        graph.get(2).add(new GraphNode(3, 4));

        dijkstra.dijkstra(graph, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dijkstra.distance.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dijkstra.distance[i]);
    }

    public static class Dijkstra {

        // Class to represent a node in the graph
        static class Node implements Comparator<Node> {
            public int node;
            public int cost;

            public Node() {
            }

            public Node(int node, int cost) {
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compare(Node node1, Node node2) {
                if (node1.cost < node2.cost) {
                    return -1;
                }
                if (node1.cost > node2.cost) {
                    return 1;
                }
                return 0;
            }
        }


        private int dist[];
        private Set<Integer> settled;
        private PriorityQueue<Node> pq;
        private int V; // Number of vertices
        List<List<Node>> adj;

        public Dijkstra(int V) {
            this.V = V;
            dist = new int[V];
            settled = new HashSet<Integer>();
            pq = new PriorityQueue<Node>(V, new Node());
        }

        // Function for Dijkstra's Algorithm
        public void dijkstraAlgo(List<List<Node>> adj, int src) {
            this.adj = adj;

            for(int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
            }

            // Add source node to the priority queue
            pq.add(new Node(src, 0));
            dist[src] = 0;
            while(settled.size() != V) {
                /* remove the minimum distance node
                from the priority queue */
                int u = pq.remove().node;
                settled.add(u);
                evalNeighbors(u);
            }
        }

        // Function to process all the neighbors
        // of the passed Node
        private void evalNeighbors(int u) {
            int edgeDistance = -1;
            int newDistance = -1;

            // All the neighbors of v
            for(int i = 0; i < adj.get(u).size(); i++) {
                Node v = adj.get(u).get(i);

                // if the current node hasn't been processed
                if(!settled.contains(v.node)) {
                    edgeDistance = v.cost;
                    newDistance = dist[u] + edgeDistance;

                    // if the new distance is cheaper than the cost
                    if(newDistance < dist[v.node]) {
                        dist[v.node] = newDistance;
                    }

                    pq.add(new Node(v.node, dist[v.node]));
                }
            }
        }

        public static void main(String[] args) {
            int V = 5;
            int source = 0;

            // Adjacency list representation of the
            // connected edges
            List<List<Node>> adj = new ArrayList<List<Node>>();

            for(int i = 0; i < V; i++) {
                List<Node> item = new ArrayList<>();
                adj.add(item);
            }

            adj.get(0).add(new Node(1, 9));
            adj.get(0).add(new Node(2, 6));
            adj.get(0).add(new Node(3, 5));
            adj.get(0).add(new Node(4, 3));
            adj.get(2).add(new Node(1, 2));
            adj.get(2).add(new Node(3, 4));

            // Calculate the single source shortest path
            Dijkstra dijkstra = new Dijkstra(V);
            dijkstra.dijkstraAlgo(adj, source);

            // Print the shortest path to all the nodes
            // from the source node
            System.out.println("The shorted path from node :");
            for (int i = 0; i < dijkstra.dist.length; i++)
                System.out.println(source + " to " + i + " is "
                        + dijkstra.dist[i]);

        }

    }
}
