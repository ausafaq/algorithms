import java.util.*;

public class KahnsAlgorithm {
    int numCourses;
    int[] indegree;
    Map<Integer, List<Integer>> graph;

    /**
     * Topological sort algorithm for DAG
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.indegree = new int[numCourses];
        this.graph = new HashMap<>();
        for(int[] dependency : prerequisites) {
            List<Integer> list = graph.getOrDefault(dependency[1], new ArrayList<>());
            list.add(dependency[0]);
            indegree[dependency[0]]++;
            graph.put(dependency[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(indegree[curr] == 0) count++;
            if(!graph.containsKey(curr)) continue;
            for(int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) queue.add(neighbor);
            }
        }
        return count == numCourses;
    }
}
