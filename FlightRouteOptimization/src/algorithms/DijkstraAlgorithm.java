package FlightRouteOptimization.src.algorithms;

import FlightRouteOptimization.src.models.FlightGraph;
import FlightRouteOptimization.src.models.Route;
import FlightRouteOptimization.src.models.Airport;

import java.util.*;

public class DijkstraAlgorithm {

    public Map<Airport, Integer> findShortestPaths(FlightGraph graph, Airport source) {
        Map<Airport, Integer> distances = new HashMap<>();
        Map<Airport, Airport> previous = new HashMap<>();
        PriorityQueue<Airport> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        distances.put(source, 0);
        priorityQueue.add(source);

        for (Airport airport : graph.getAirports()) {
            if (!airport.equals(source)) {
                distances.put(airport, Integer.MAX_VALUE);
            }
            previous.put(airport, null);
        }

        while (!priorityQueue.isEmpty()) {
            Airport current = priorityQueue.poll();

            for (Route route : graph.getRoutesFrom(current)) {
                Airport destination = route.getDestination();
                int newDist = distances.get(current) + route.getDistance();

                if (newDist < distances.get(destination)) {
                    distances.put(destination, newDist);
                    previous.put(destination, current);
                    priorityQueue.add(destination);
                }
            }
        }

        return distances;
    }
}