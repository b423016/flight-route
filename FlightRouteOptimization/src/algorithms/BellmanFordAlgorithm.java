package FlightRouteOptimization.src.algorithms;

import FlightRouteOptimization.src.models.FlightGraph;
import FlightRouteOptimization.src.models.Route;
import FlightRouteOptimization.src.models.Airport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFordAlgorithm {

    public Map<Airport, Integer> findShortestPaths(FlightGraph graph, Airport source) {
        Map<Airport, Integer> distances = new HashMap<>();
        for (Airport airport : graph.getAirports()) {
            distances.put(airport, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        List<Route> routes = graph.getAllRoutes();
        int V = graph.getAirports().size();

        for (int i = 1; i < V; ++i) {
            for (Route route : routes) {
                Airport u = route.getSource();
                Airport v = route.getDestination();
                int weight = route.getDistance();
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                }
            }
        }

        for (Route route : routes) {
            Airport u = route.getSource();
            Airport v = route.getDestination();
            int weight = route.getDistance();
            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                System.out.println("Graph contains negative weight cycle");
            }
        }

        return distances;
    }
}