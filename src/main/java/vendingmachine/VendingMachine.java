package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Item> inventory;
    private double balance;

    public VendingMachine() {
        this.inventory = new HashMap<>(); // mug it up
        this.balance = 0.0;
    }

    public void addItem(Item item) { // all the service will have add/get/update/delete
        inventory.put(item.getName(), item); // mug it up
    }

    public Item getItem(String itemName) { // all the service will have add/get/update/delete
        return inventory.get(itemName);
    }

    public void insertMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Inserted $" + amount);
        } else {
            System.out.println("Please insert a valid amount of money.");
        }
    }

    public void displayItems() {
        System.out.println("Items available in the vending machine:");
        for (Item item : inventory.values()) {
            System.out.println(item);
        }
    }

    public void dispenseItem(String itemName) {
        Item item = inventory.get(itemName);

        if (item != null && item.getQuantity() > 0) { // mug it up
            if (balance >= item.getPrice()) {
                balance -= item.getPrice();
                item.setQuantity(item.getQuantity() - 1);
                System.out.println("Dispensing " + itemName);
            } else {
                System.out.println("Insufficient balance. Please insert more money.");
            }
        } else {
            System.out.println("Item not available or out of stock.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void returnChange() {
        System.out.println("Returning $" + balance + " in change.");
        balance = 0.0;
    }
}
