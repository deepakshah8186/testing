package pipe;

// Task: Exchange Order Matching
//One of the core subsystems at Pipe is the "exchange" — a two-sided marketplace to enable trading of recurring revenue assets. The exchange should allow callers to create new buy orders, create new sell orders, and see the status of any order. The exchange should match buy and sell orders and keep track of these matches.
//In this interview your task is to implement a simplified version of this exchange and write tests to confirm that it works as expected.
//API
//For the purposes of the interview you should not implement any kind of access control, authorization, or validation of function arguments.
//GetOrder(orderID string) → Order
//This returns the current state of an individual Order , given its ID. This function must return at least the following information, but may also include other fields if needed by your implementation.
//An order contains the following data:
//{
//    // A globally unique ID: no two orders may have the same ID.
//		id: string,
//
//    // The type of the order
//    type: "buy" | "sell",
//
//    // The initial parameters that created this order.
//		limitPrice: int,
//    numContracts: int,
//
//		// The number of unmatched contracts. Initially equal to numContracts,
//    // goes to zero as order gets filled.
//		remainingContracts: int,
//
//    // Initially "unfilled"; see the order matching constraints below.
//    status: "unfilled" | "partially_filled" | "filled",
//
//    // A list of all matches between this order and others. Initially empty.
//    matches: [
//      {
//				// The ID of the order to which this match was made.
//        id: string,
//				// The number of contracts involved in the match.
//        numContracts: int,
//				// The per-contract price these contracts were matched at.
//				// It is the average price between the sell and buy limit price.
//        executionPrice: int,
//      }
//    ]
//  }
//}
//
//
//### NewSell(numContracts int, limitPrice int) → string
//
//Creates a new order with type = "sell".
//
//Input:
//
//- **numContracts**: the number of contracts the seller is trying to sell.
//- **limitPrice**: the minimum price-per-contract the seller is willing to accept.
//
//Output:
//
//- A globally unique ID for the newly-created sell order.
//
//### NewBuy(numContracts int, limitPrice int) → string
//
//Creates a new order with type = "buy".
//
//Input:
//
//- **numContracts**: the number of contracts the buyer is trying to purchase.
//- **limitPrice**: the maximum price-per-contract the buyer is willing to accept.
//
//Output:
//
//- A globally unique ID for the newly-created buy order.
//
//# Order Matching
//
//Your exchange **must** match buy and sell orders according to the following constraints:
//
//- Sell orders must be matched to buy orders, and vice versa.
//- Each buyer must pay at least as much per contract as the seller requested.
//- Only orders with remaining unmatched contracts can be matched together.
//- The match must not involve more contracts than either order has remaining.
//
//At all times the following invariants **must** be true:
//
//- The number of remaining unmatched contracts on an order must be equal to the original number of contracts minus the number of matched contracts.
//- The state of the order should reflect the number of contracts remaining:
//    - If no contracts have been matched, it should be unfilled.
//    - If all contracts have been matched, it should be filled.
//    - Otherwise, the order is partially_filled.
//
//Beyond these constraints, your exchange is free to choose any behavior you see fit. **We recommend choosing the simplest and easiest-to-debug behavior and remaining consistent with that choice.**

// Explanation:
//Order class: Represents an order in the system with attributes like id, type, limitPrice, remainingContracts, etc.
//Match class: Stores details of a match between a buy and sell order.
//Exchange class: Handles the creation of buy/sell orders, stores them in priority queues, and matches them based on price.
//newBuy and newSell: Create new buy/sell orders and attempt to match them immediately.
//matchOrders: Matches buy orders with sell orders based on the price constraints.
//executeMatch: Updates orders when a match is found, including remaining contracts and the execution price.

// The output will display the order details and any matches that were executed during the creation of buy/sell orders.
//
//This system ensures that the exchange matches orders based on price constraints and keeps the state of each order updated, as described in the problem.

import java.util.*;

class Order {
    String id;
    String type; // "buy" or "sell"
    int limitPrice;
    int numContracts;
    int remainingContracts;
    String status; // "unfilled", "partially_filled", "filled"
    List<Match> matches;

    public Order(String id, String type, int limitPrice, int numContracts) {
        this.id = id;
        this.type = type;
        this.limitPrice = limitPrice;
        this.numContracts = numContracts;
        this.remainingContracts = numContracts;
        this.status = "unfilled";
        this.matches = new ArrayList<>();
    }
}

class Match {
    String id;
    int numContracts;
    int executionPrice;

    public Match(String id, int numContracts, int executionPrice) {
        this.id = id;
        this.numContracts = numContracts;
        this.executionPrice = executionPrice;
    }
}

class Exchange {
    Map<String, Order> orders = new HashMap<>();
    Queue<Order> buyOrders = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.limitPrice, o1.limitPrice));
    Queue<Order> sellOrders = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.limitPrice, o2.limitPrice));

    public String newSell(int numContracts, int limitPrice) {
        Order order = new Order(UUID.randomUUID().toString(), "sell", limitPrice, numContracts);
        orders.put(order.id, order);
        matchOrders(order);
        return order.id;
    }

    public String newBuy(int numContracts, int limitPrice) {
        Order order = new Order(UUID.randomUUID().toString(), "buy", limitPrice, numContracts);
        orders.put(order.id, order);
        matchOrders(order);
        return order.id;
    }

    public Order getOrder(String orderID) {
        return orders.get(orderID);
    }

    private void matchOrders(Order newOrder) {
        if (newOrder.type.equals("buy")) {
            while (!sellOrders.isEmpty() && newOrder.remainingContracts > 0) {
                Order sellOrder = sellOrders.peek();
                if (newOrder.limitPrice >= sellOrder.limitPrice) {
                    executeMatch(newOrder, sellOrder);
                    if (sellOrder.remainingContracts == 0) sellOrders.poll();
                } else {
                    break;
                }
            }
            if (newOrder.remainingContracts > 0) buyOrders.add(newOrder);
        } else if (newOrder.type.equals("sell")) {
            while (!buyOrders.isEmpty() && newOrder.remainingContracts > 0) {
                Order buyOrder = buyOrders.peek();
                if (buyOrder.limitPrice >= newOrder.limitPrice) {
                    executeMatch(buyOrder, newOrder);
                    if (buyOrder.remainingContracts == 0) buyOrders.poll();
                } else {
                    break;
                }
            }
            if (newOrder.remainingContracts > 0) sellOrders.add(newOrder);
        }
    }

    private void executeMatch(Order buyOrder, Order sellOrder) {
        int matchedContracts = Math.min(buyOrder.remainingContracts, sellOrder.remainingContracts);
        int executionPrice = (buyOrder.limitPrice + sellOrder.limitPrice) / 2;

        buyOrder.matches.add(new Match(sellOrder.id, matchedContracts, executionPrice));
        sellOrder.matches.add(new Match(buyOrder.id, matchedContracts, executionPrice));

        buyOrder.remainingContracts -= matchedContracts;
        sellOrder.remainingContracts -= matchedContracts;

        updateStatus(buyOrder);
        updateStatus(sellOrder);
    }

    private void updateStatus(Order order) {
        if (order.remainingContracts == 0) {
            order.status = "filled";
        } else if (order.remainingContracts < order.numContracts) {
            order.status = "partially_filled";
        }
    }

    public static void main(String[] args) {
        Exchange exchange = new Exchange();

        String buyOrder1 = exchange.newBuy(10, 50);
        String sellOrder1 = exchange.newSell(5, 45);
        String buyOrder2 = exchange.newBuy(3, 60);
        String sellOrder2 = exchange.newSell(8, 55);

        printOrder(exchange.getOrder(buyOrder1));
        printOrder(exchange.getOrder(sellOrder1));
        printOrder(exchange.getOrder(buyOrder2));
        printOrder(exchange.getOrder(sellOrder2));
    }

    private static void printOrder(Order order) {
        System.out.println("Order ID: " + order.id);
        System.out.println("Type: " + order.type);
        System.out.println("Limit Price: " + order.limitPrice);
        System.out.println("Status: " + order.status);
        System.out.println("Remaining Contracts: " + order.remainingContracts);
        System.out.println("Matches:");
        for (Match match : order.matches) {
            System.out.println(" - Matched with Order ID: " + match.id + ", Contracts: " + match.numContracts + ", Price: " + match.executionPrice);
        }
        System.out.println("-------------------------------------------------");
    }
}

