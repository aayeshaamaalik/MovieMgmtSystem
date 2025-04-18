public class Seat {
    private int seatNumber;
    private SeatType type;
    private boolean isReserved;

    public Seat(int seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.isReserved = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getType() {
        return type;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        this.isReserved = true;
    }

    public void release() {
        this.isReserved = false;
    }
}
