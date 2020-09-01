package com.learning.treesandgraphs.dijkstra;

import java.util.*;

public class Node {
    private final String name;

    public String getName() {
        return name;
    }

    public Node(String name) {
        this.name = name;
    }

    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    private Integer distance = Integer.MAX_VALUE;
    private List<Node> shortestPathToSource = new LinkedList<>();

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public Integer getDistance() {
        return distance;
    }

    public List<Node> getShortestPathToSource() {
        return shortestPathToSource;
    }

    public void setAdjacentNodes(Node city, Integer distance) {
        adjacentNodes.put(city, distance);
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public void setShortestPathToSource(List<Node> shortestPathToSource) {
        this.shortestPathToSource = shortestPathToSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
