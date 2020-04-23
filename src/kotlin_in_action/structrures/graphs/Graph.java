package kotlin_in_action.structrures.graphs;

import java.util.*;

public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    public void addVertex(Vertex v) {
        if (adjVertices.containsKey(v)) {
            throw new IllegalArgumentException("Vertex already exists: " + v);
        }
        adjVertices.put(v, new ArrayList<>());
    }

    public void removeVertex(Vertex v) {
        for (Vertex v1 : adjVertices.keySet()) {
            adjVertices.get(v1).remove(v);
        }
        adjVertices.remove(v);
    }

    public void addEdge(Vertex v1, Vertex v2) {
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void removeEdge(Vertex v1, Vertex v2) {
        adjVertices.get(v1).remove(v2);
        adjVertices.get(v2).remove(v1);
    }

    public List<Vertex> getAdjVertices(Vertex v) {
        return adjVertices.get(v);
    }

    public List<Vertex> dfs(Vertex root) {
        List<Vertex> result = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> remainedVertexes = new Stack<>();

        remainedVertexes.push(root);
        while (!remainedVertexes.isEmpty()) {
            Vertex vertex = remainedVertexes.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : getAdjVertices(vertex)) {
                    remainedVertexes.push(v);
                }
                result.add(vertex);
            }
        }
        return result;
    }

    public List<Vertex> bfs(Vertex root) {
        List<Vertex> result = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> remained = new LinkedList<>();

        remained.offer(root);
        while (!remained.isEmpty()) {
            Vertex vertex = remained.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : getAdjVertices(vertex)) {
                    remained.offer(v);
                }
                result.add(vertex);
            }
        }
        return result;
    }
}
