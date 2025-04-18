import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Show {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String cinemaHallId;
    private List<Seat> seats;

    public Show(int id, LocalDateTime startTime, LocalDateTime endTime,
                String cinemaHallId, List<Seat> seats) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cinemaHallId = cinemaHallId;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public List<Seat> getAvailableSeats() {
        return seats.stream()
                .filter(seat -> !seat.isReserved())
                .collect(Collectors.toList());
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }
}
