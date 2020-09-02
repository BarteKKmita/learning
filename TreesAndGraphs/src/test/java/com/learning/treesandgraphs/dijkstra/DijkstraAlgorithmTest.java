package com.learning.treesandgraphs.dijkstra;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(CitiesParameterResolver.class)
public class DijkstraAlgorithmTest {

    @ParameterizedTest
    @MethodSource("getCities")
    void shouldReturnCorrectDistances(String city, Integer distance) {
        //Given
        Graph graph = prepareGraph();
        //When
        DijkstraAlgorithm.calculateShortestPathFromSource(graph, graph.getNodes().get(0));
        List<Node> nodesAfterCalculation = graph.getNodes();
        //Then
        nodesAfterCalculation.stream()
                .filter(node -> node.getName().equals(city))
                .findFirst()
                .ifPresent(node -> assertEquals(node.getDistance(), distance));
    }

    public Graph prepareGraph() {
        Node krakow = new Node("Kraków");
        Node wawrzenczyce = new Node("Wawrzeńczyce");
        Node brzesko = new Node("Brzesko");
        Node wieliczka = new Node("Wieliczka");
        Node bochnia = new Node("Bochnia");
        krakow.setAdjacentNodes(wawrzenczyce, 10);
        krakow.setAdjacentNodes(brzesko, 45);
        krakow.setAdjacentNodes(wieliczka, 5);
        wawrzenczyce.setAdjacentNodes(krakow, 10);
        wawrzenczyce.setAdjacentNodes(brzesko, 25);
        brzesko.setAdjacentNodes(krakow, 45);
        brzesko.setAdjacentNodes(bochnia, 1);
        brzesko.setAdjacentNodes(wawrzenczyce, 25);
        wieliczka.setAdjacentNodes(krakow, 5);
        wieliczka.setAdjacentNodes(bochnia, 20);
        bochnia.setAdjacentNodes(wieliczka, 20);
        bochnia.setAdjacentNodes(brzesko, 1);
        Graph graph = new Graph();
        graph.setNodes(Arrays.asList(krakow, wawrzenczyce, bochnia, brzesko, wieliczka));
        return graph;
    }

    public static Stream<Arguments> getCities() {
        return Stream.of(
                Arguments.of("karakow", 0),
                Arguments.of("brzesko", 26),
                Arguments.of("wawrzenczyce", 10),
                Arguments.of("wieliczka", 5),
                Arguments.of("bochnia", 25));
    }
}
