package FlightRouteOptimization.src.models;

public class Route {
    private Airport source;
    private Airport destination;
    private int distance;

    public Route(Airport source, Airport destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    public Airport getSource() {
        return source;
    }

    public Airport getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "source=" + source +
                ", destination=" + destination +
                ", distance=" + distance +
                '}';
    }
}