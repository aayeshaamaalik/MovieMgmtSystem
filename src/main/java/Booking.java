import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Booking {
    private String bookingId;
    private Show show;
    private List<Seat> bookedSeats;
    private LocalDateTime bookingTime;
    private Payment payment;

    public Booking(Show show, List<Seat> bookedSeats, Payment payment) {
        this.bookingId = UUID.randomUUID().toString();
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.bookingTime = LocalDateTime.now();
        this.payment = payment;

        // Reserve the seats
        for (Seat seat : bookedSeats) {
            seat.reserve();
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public Payment getPayment() {
        return payment;
    }
}
