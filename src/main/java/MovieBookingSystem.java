import java.util.*;
import java.util.stream.Collectors;

public class MovieBookingSystem {
    private List<City> cities;
    private List<Movie> movies;
    private List<Booking> bookings;

    public MovieBookingSystem() {
        this.cities = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    // Admin methods
    public void addCity(City city) {
        cities.add(city);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    // 1. Filter/Search movies using specifications
    public List<Movie> searchMovies(MovieSpecification spec) {
        return movies.stream()
                .filter(spec::isSatisfied)
                .collect(Collectors.toList());
    }

    // 2. Get shows for a specific movie in a specific city
    public List<Show> getShowsForMovie(String movieTitle, String cityName) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(movieTitle))
                .flatMap(movie -> movie.getShows().stream())
                .filter(show -> isShowInCity(show, cityName))
                .collect(Collectors.toList());
    }

    // 3. View available seats for a show
    public List<Seat> getAvailableSeats(Show show) {
        return show.getAvailableSeats();
    }

    // 4. Book seats for a show
    public Booking bookSeats(Show show, List<Integer> seatNumbers, double amount) {
        List<Seat> selectedSeats = show.getAvailableSeats().stream()
                .filter(seat -> seatNumbers.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());

        if (selectedSeats.size() != seatNumbers.size()) {
            System.out.println("Some selected seats are not available.");
            return null;
        }

        for (Seat seat : selectedSeats) {
            seat.reserve();
        }

        Payment payment = new Payment(UUID.randomUUID().toString(), amount, PaymentStatus.COMPLETED);
        Booking booking = new Booking(show, selectedSeats, payment);
        bookings.add(booking);
        return booking;
    }

    // 5. Cancel a booking
    public boolean cancelBooking(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                for (Seat seat : booking.getBookedSeats()) {
                    seat.release();
                }
                bookings.remove(booking);
                return true;
            }
        }
        return false;
    }

    // Helpers

    private boolean isShowInCity(Show show, String cityName) {
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(cityName)) {
                for (Cinema cinema : city.getCinemas()) {
                    for (CinemaHall hall : cinema.getCinemaHalls()) {
                        if (Integer.toString(hall.getId()).equals(show.getCinemaHallId())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
