package DS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
@Setter
public class Graph<T> {
    private Map<T, List<T>> adjacencyList;

    public void addEdge(T src, T dest) {
        adjacencyList.putIfAbsent(src, new ArrayList<>());
        adjacencyList.putIfAbsent(dest, new ArrayList<>());
        adjacencyList.get(src).add(dest);
    }

    public List<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public void displayGraph() {
        this.adjacencyList.forEach((k, v) -> {
            System.out.print(k + " : ");
            v.forEach(vertex -> System.out.print(vertex + "\t"));
            System.out.println();
        });
    }

    public void dfs(T startVertex) {
        System.out.println("<DFS>");
        Map<T, Boolean> visited = new HashMap<>();
        this._dfs(startVertex, visited);
        System.out.println("</DFS>");
    }

    private void _dfs(T vertex, Map<T, Boolean> visited) {
        if(visited.containsKey(vertex)) {
            return;
        }
        visited.put(vertex, true);
        System.out.println(vertex);
        List<T> neighbors = this.getNeighbors(vertex);
        for(T neighbor : neighbors) {
            _dfs(neighbor, visited);
        }
    }

    public void bfs(T startVertex) {
        System.out.println("<BFS>");
        Queue<T> level = new LinkedList<>();
        level.add(startVertex);
        System.out.println(startVertex);
        _bfs(new HashSet<>(), level);
        System.out.println("</BFS>");
    }

    private void _bfs(Set<T> visited, Queue<T> level) {
        if(level.isEmpty())
            return;
        T current=level.poll();
        List<T> neighbors = this.getNeighbors(current);
        for(T neighbor : neighbors) {
            if(visited.contains(neighbor))
                continue;
            System.out.println(neighbor);
            level.add(neighbor);
            visited.add(neighbor);
        }
        _bfs(visited, level);
    }


    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.setAdjacencyList(new HashMap<>());
        String A = "A", B = "B", C = "C", D = "D", E = "E", F = "F", G="G";
        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(A, D);
        graph.addEdge(B, E);
        graph.addEdge(C, F);
        graph.addEdge(D, G);
        //graph.displayGraph();
        graph.dfs(A);
        graph.bfs(A);
    }


}
