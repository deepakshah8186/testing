package venmoLatest;

import java.util.Date;

public class Transaction {
    private User sender;
    private User receiver;
    private double amount;
    private String message;  // Optional message for the transaction
    private Date timestamp;

    public Transaction(User sender, User receiver, double amount, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.message = message;
        this.timestamp = new Date();  // Timestamp of the transaction
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return sender.getUsername() + " paid " + receiver.getUsername() + " $" + amount +
                " for " + message + " on " + timestamp;
    }
}

