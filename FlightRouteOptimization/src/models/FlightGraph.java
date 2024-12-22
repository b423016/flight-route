package FlightRouteOptimization.src.models;

import java.util.*;

public class FlightGraph {
    private Map<Airport, List<Route>> adjacencyList;
    private Map<String, Airport> airportCodeMap;

    public FlightGraph() {
        this.adjacencyList = new HashMap<>();
        this.airportCodeMap = new HashMap<>();
    }

    public void addAirport(Airport airport) {
        adjacencyList.putIfAbsent(airport, new ArrayList<>());
        airportCodeMap.put(airport.getCode(), airport);
    }

    public void addRoute(Route route) {
        adjacencyList.computeIfAbsent(route.getSource(), k -> new ArrayList<>()).add(route);
        adjacencyList.putIfAbsent(route.getDestination(), new ArrayList<>());
    }

    public List<Route> getRoutesFrom(Airport airport) {
        return adjacencyList.getOrDefault(airport, Collections.emptyList());
    }

    public Set<Airport> getAirports() {
        return adjacencyList.keySet();
    }

    public List<Route> getAllRoutes() {
        List<Route> allRoutes = new ArrayList<>();
        for (List<Route> routes : adjacencyList.values()) {
            allRoutes.addAll(routes);
        }
        return allRoutes;
    }

    public Airport getAirportByCode(String code) {
        return airportCodeMap.get(code);
    }
}