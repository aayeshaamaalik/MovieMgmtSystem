import java.time.LocalDateTime;

public class Payment {
    private String transactionId;
    private double amount;
    private LocalDateTime transactionTime;
    private PaymentStatus status;

    public Payment(String transactionId, double amount, PaymentStatus status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
        this.transactionTime = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
