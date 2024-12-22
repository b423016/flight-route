package FlightRouteOptimization.src.algorithms;

import FlightRouteOptimization.src.models.FlightGraph;
import FlightRouteOptimization.src.models.Route;
import FlightRouteOptimization.src.models.Airport;

import java.util.*;

public class AStarAlgorithm {

    public List<Airport> findShortestPath(FlightGraph graph, Airport source, Airport destination) {
        Map<Airport, Integer> gScore = new HashMap<>();
        Map<Airport, Integer> fScore = new HashMap<>();
        Map<Airport, Airport> previous = new HashMap<>();
        PriorityQueue<Airport> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(fScore::get));

        gScore.put(source, 0);
        fScore.put(source, heuristicCostEstimate(source, destination));
        priorityQueue.add(source);

        for (Airport airport : graph.getAirports()) {
            if (!airport.equals(source)) {
                gScore.put(airport, Integer.MAX_VALUE);
                fScore.put(airport, Integer.MAX_VALUE);
            }
            previous.put(airport, null);
        }

        while (!priorityQueue.isEmpty()) {
            Airport current = priorityQueue.poll();

            if (current.equals(destination)) {
                return reconstructPath(previous, current);
            }

            for (Route route : graph.getRoutesFrom(current)) {
                Airport neighbor = route.getDestination();
                int tentativeGScore = gScore.get(current) + route.getDistance();

                if (tentativeGScore < gScore.get(neighbor)) {
                    previous.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, gScore.get(neighbor) + heuristicCostEstimate(neighbor, destination));
                    priorityQueue.add(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }

    private int heuristicCostEstimate(Airport a, Airport b) {
        // Implement a heuristic function here. For simplicity, we return 0 (Dijkstra's algorithm)
        return 0;
    }

    private List<Airport> reconstructPath(Map<Airport, Airport> previous, Airport current) {
        List<Airport> path = new LinkedList<>();
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }
        return path;
    }
}