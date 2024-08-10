package vendingmachine;

import java.util.Scanner;

public class VendingMachineController {
    private VendingMachine vendingMachine;
    private Scanner scanner;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to the Vending Machine!");
            System.out.println("1. Display Items");
            System.out.println("2. Insert Money");
            System.out.println("3. Buy Item");
            System.out.println("4. Return Change");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    vendingMachine.displayItems();
                    break;
                case 2:
                    System.out.print("Enter amount to insert: ");
                    double amount = scanner.nextDouble();
                    vendingMachine.insertMoney(amount);
                    break;
                case 3:
                    System.out.print("Enter the name of the item to buy: ");
                    scanner.nextLine(); // Consume newline
                    String itemName = scanner.nextLine();
                    vendingMachine.dispenseItem(itemName);
                    break;
                case 4:
                    vendingMachine.returnChange();
                    break;
                case 5:
                    System.out.println("Exiting. Have a nice day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addItem(new Item("Coke", 1.50, 10));
        vendingMachine.addItem(new Item("Pepsi", 1.50, 8));
        vendingMachine.addItem(new Item("Water", 1.00, 20));

        VendingMachineController controller = new VendingMachineController(vendingMachine);
        controller.start();
    }
}
