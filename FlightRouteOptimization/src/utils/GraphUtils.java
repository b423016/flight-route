package FlightRouteOptimization.src.utils;

import FlightRouteOptimization.src.models.Airport;
import FlightRouteOptimization.src.models.FlightGraph;

public class GraphUtils {
    public static void printAirportInfo(Airport airport) {
        System.out.println("Airport Code: " + airport.getCode());
        System.out.println("Airport Name: " + airport.getName());
    }

    public static void printGraph(FlightGraph graph) {
        for (Airport airport : graph.getAirports()) {
            System.out.println("Airport: " + airport.getName() + " (" + airport.getCode() + ")");
            graph.getRoutesFrom(airport).forEach(route -> System.out.println("  -> " + route.getDestination().getName() +
                    " (" + route.getDestination().getCode() + ") - Distance: " + route.getDistance()));
            System.out.println();
        }
    }
}