package mac;

public class Bid {
    private int id;
    private double amount;
    private Job job;
    private User bidder;

    // constructor
    public Bid(double amount, Job job, User bidder) {
        this.amount = amount;
        this.job = job;
        this.bidder = bidder;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }
    public User getBidder() { return bidder; }
    public void setBidder(User bidder) { this.bidder = bidder; }
}
