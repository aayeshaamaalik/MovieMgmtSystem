import java.util.List;

public class City {
    private String name;
    private String state;
    private String postalCode;
    private List<Cinema> cinemas;

    public City(String name, String state, String postalCode, List<Cinema> cinemas) {
        this.name = name;
        this.state = state;
        this.postalCode = postalCode;
        this.cinemas = cinemas;
    }

    public String getName() {
        return name;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
