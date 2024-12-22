package FlightRouteOptimization.src.main;

import FlightRouteOptimization.src.models.Airport;
import FlightRouteOptimization.src.models.FlightGraph;
import FlightRouteOptimization.src.models.Route;

public class VisualizerLauncher {
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

        // Visualize the flight routes
        visualizeFlightRoutes(graph);
    }

    private static void visualizeFlightRoutes(FlightGraph graph) {
        System.out.println("Flight Route Visualization:");
        System.out.println("---------------------------");

        for (Airport airport : graph.getAirports()) {
            System.out.println("Airport: " + airport.getName() + " (" + airport.getCode() + ")");
            for (Route route : graph.getRoutesFrom(airport)) {
                System.out.println("  -> " + route.getDestination().getName() +
                        " (" + route.getDestination().getCode() + ") - Distance: " + route.getDistance());
            }
            System.out.println();
        }

        System.out.println("---------------------------");
        System.out.println("Visualization complete.");
    }
}