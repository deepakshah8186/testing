package venmoLatest;

import java.util.*;

public class User {
    private String username;
    private double balance;
    private Set<User> friends;
    private List<Transaction> transactionHistory;

    public User(String username, double initialBalance) {
        this.username = username;
        this.balance = initialBalance;
        this.friends = new HashSet<>();
        this.transactionHistory = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public void addFriend(User friend) {
        friends.add(friend);
        friend.friends.add(this);  // Bi-directional friendship
    }


    public double getBalance() {
        return balance;
    }

    public boolean isFriend(User user) {
        return friends.contains(user);
    }

    public String getUsername() {
        return username;
    }

    public Set<User> getFriends() {
        return friends;
    }



    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public String toString() {
        return username + " (Balance: $" + balance + ")";
    }
}
