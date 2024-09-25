package venmoLatest;

import java.util.*;

public class VenmoService {
    private Map<String, User> users;// Map of username to User object
    public VenmoService() {
        users = new HashMap<>();
    }
    // Register a new user
    public User registerUser(String username, double initialBalance) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return null;
        }
        User newUser = new User(username, initialBalance);
        users.put(username, newUser);
        return newUser;
    }

    // Send money from one user to another
    public void sendMoney(User sender, User receiver, double amount, String message) {
        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        // Create a transaction
        Transaction transaction = new Transaction(sender, receiver, amount, message);
        sender.updateBalance(-amount);  // Deduct from sender
        receiver.updateBalance(amount);  // Add to receiver

        // Add the transaction to both sender's and receiver's history
        sender.addTransaction(transaction);
        receiver.addTransaction(transaction);

        System.out.println(sender.getUsername() + " sent $" + amount + " to " + receiver.getUsername());
    }

    // Add a friend
    public void addFriend(User user, User friend) {
        if (user == null || friend == null || user.equals(friend)) {
            System.out.println("Invalid operation");
            return;
        }
        user.addFriend(friend);
        System.out.println(user.getUsername() + " is now friends with " + friend.getUsername());
    }

    // Generate a user's transaction feed
    public void generateFeed(User user) {
        List<Transaction> feed = new ArrayList<>();

        // Include user's own transactions
        feed.addAll(user.getTransactionHistory());

        // Include friends' transactions (for simplicity, just get all transactions)
        for (User friend : user.getFriends()) {
            feed.addAll(friend.getTransactionHistory());
        }

        // Sort the feed by timestamp (most recent first)
        feed.sort(Comparator.comparing(Transaction::getTimestamp).reversed());

        // Display the feed
        System.out.println("Feed for " + user.getUsername() + ":");
        for (Transaction transaction : feed) {
            System.out.println(transaction);
        }
    }

    // Get a user by username
    public User getUser(String username) {
        return users.get(username);
    }

    // Main method for testing
    public static void main(String[] args) {
        VenmoService service = new VenmoService();

        // Register users
        User alice = service.registerUser("Alice", 100);
        User bob = service.registerUser("Bob", 50);
        User charlie = service.registerUser("Charlie", 200);

        // Add friends
        service.addFriend(alice, bob);
        service.addFriend(alice, charlie);

        // Send money between users
        service.sendMoney(alice, bob, 20, "Dinner");
        service.sendMoney(bob, charlie, 30, "Concert tickets");

        // Generate feed for Alice
        service.generateFeed(alice);
    }
}
