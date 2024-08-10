package mac;

public class Job {
    private int id;
    private String title;
    private String description;
    private String location;
    private double budget;
    private User poster;

    // constructor
    public Job(String title, String description, String location, double budget, User poster) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.budget = budget;
        this.poster = poster;
    }

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public User getPoster() { return poster; }
    public void setPoster(User poster) { this.poster = poster; }
}
