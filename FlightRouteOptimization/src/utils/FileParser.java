package FlightRouteOptimization.src.utils;

import FlightRouteOptimization.src.models.Airport;
import FlightRouteOptimization.src.models.FlightGraph;
import FlightRouteOptimization.src.models.Route;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {

    public static void parseAirports(String filePath, FlightGraph graph) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2) {
                    Airport airport = new Airport(values[0], values[1]);
                    graph.addAirport(airport);
                }
            }
        }
    }

    public static void parseRoutes(String filePath, FlightGraph graph) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    Airport source = graph.getAirportByCode(values[0]);
                    Airport destination = graph.getAirportByCode(values[1]);
                    int distance = Integer.parseInt(values[2]);

                    if (source != null && destination != null) {
                        graph.addRoute(new Route(source, destination, distance));
                    }
                }
            }
        }
    }
}