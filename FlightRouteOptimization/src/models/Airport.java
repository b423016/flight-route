package FlightRouteOptimization.src.models;

public class Airport {
    private String code;
    private String name;

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}