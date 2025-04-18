import java.util.List;

public class Cinema {
    private String name;
    private Address address;
    private List<CinemaHall> cinemaHalls;

    public Cinema(String name, Address address, List<CinemaHall> cinemaHalls) {
        this.name = name;
        this.address = address;
        this.cinemaHalls = cinemaHalls;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }
}
