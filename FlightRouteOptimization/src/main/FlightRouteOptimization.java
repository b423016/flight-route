package FlightRouteOptimization.src.main;

import FlightRouteOptimization.src.algorithms.DijkstraAlgorithm;
import FlightRouteOptimization.src.algorithms.AStarAlgorithm;
import FlightRouteOptimization.src.algorithms.BellmanFordAlgorithm;
import FlightRouteOptimization.src.models.Airport;
import FlightRouteOptimization.src.models.FlightGraph;
import FlightRouteOptimization.src.models.Route;

import java.util.Map;

public class FlightRouteOptimization {
    public static void main(String[] args) {
        // Create airports
        Airport jfk = new Airport("JFK", "John F. Kennedy International Airport");
        Airport lax = new Airport("LAX", "Los Angeles International Airport");
        Airport ord = new Airport("ORD", "O'Hare International Airport");

        // Create flight graph
        FlightGraph graph = new FlightGraph();
        graph.addAirport(jfk);
        graph.addAirport(lax);
        graph.addAirport(ord);

        // Create routes
        graph.addRoute(new Route(jfk, lax, 4000));
        graph.addRoute(new Route(lax, ord, 2000));
        graph.addRoute(new Route(jfk, ord, 3000));

        // Dijkstra's Algorithm
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        Map<Airport, Integer> dijkstraDistances = dijkstra.findShortestPaths(graph, jfk);
        System.out.println("Dijkstra's Algorithm:");
        dijkstraDistances.forEach((airport, distance) -> System.out.println(airport + " - Distance: " + distance));

        // A* Algorithm
        AStarAlgorithm aStar = new AStarAlgorithm();
        System.out.println("\nA* Algorithm:");
        System.out.println(aStar.findShortestPath(graph, jfk, ord));

        // Bellman-Ford Algorithm
        BellmanFordAlgorithm bellmanFord = new BellmanFordAlgorithm();
        Map<Airport, Integer> bellmanFordDistances = bellmanFord.findShortestPaths(graph, jfk);
        System.out.println("\nBellman-Ford Algorithm:");
        bellmanFordDistances.forEach((airport, distance) -> System.out.println(airport + " - Distance: " + distance));
    }
}