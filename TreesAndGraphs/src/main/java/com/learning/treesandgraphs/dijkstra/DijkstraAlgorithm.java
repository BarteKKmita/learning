package com.learning.treesandgraphs.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DijkstraAlgorithm {

    public static Graph calculateShortestPathFromSource(Graph graph, Node startingPoint) {
        startingPoint.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(startingPoint);
        while (!unsettledNodes.isEmpty()) {
            Node nodeWithLowestDistance = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(nodeWithLowestDistance);
            nodeWithLowestDistance
                    .getAdjacentNodes()
                    .forEach((adjacentNode, distance) -> {
                        if (!settledNodes.contains(adjacentNode)) {
                            calculateMinimumDistance(adjacentNode, distance, nodeWithLowestDistance);
                            unsettledNodes.add(adjacentNode);
                        }
                    });
            settledNodes.add(nodeWithLowestDistance);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        int lowestDistance = Integer.MAX_VALUE;
        Node lowestDistanceNode = null;
        for(Node node : unsettledNodes) {
            if (lowestDistance > node.getDistance()) {
                lowestDistance = node.getDistance();
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        if (sourceNode.getDistance() + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceNode.getDistance() + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPathToSource());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPathToSource(shortestPath);
        }

    }
}


