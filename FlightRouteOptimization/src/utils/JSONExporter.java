package FlightRouteOptimization.src.utils;

import FlightRouteOptimization.src.models.Airport;
import FlightRouteOptimization.src.models.FlightGraph;
import FlightRouteOptimization.src.models.Route;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONExporter {

    public static void exportGraphToJSON(FlightGraph graph, String filePath) throws IOException {
        JSONObject jsonGraph = new JSONObject();
        JSONArray jsonAirports = new JSONArray();
        JSONArray jsonRoutes = new JSONArray();

        for (Airport airport : graph.getAirports()) {
            JSONObject jsonAirport = new JSONObject();
            jsonAirport.put("code", airport.getCode());
            jsonAirport.put("name", airport.getName());
            jsonAirports.put(jsonAirport);
        }
        jsonGraph.put("airports", jsonAirports);

        List<Route> routes = graph.getAllRoutes();
        for (Route route : routes) {
            JSONObject jsonRoute = new JSONObject();
            jsonRoute.put("source", route.getSource().getCode());
            jsonRoute.put("destination", route.getDestination().getCode());
            jsonRoute.put("distance", route.getDistance());
            jsonRoutes.put(jsonRoute);
        }
        jsonGraph.put("routes", jsonRoutes);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonGraph.toString(4)); // Pretty print with an indentation of 4 spaces
        }
    }
}