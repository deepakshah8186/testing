package General;

import java.util.TreeSet;
// VERY NICE SOLUTION
// See IMP
// Write java code for seat reservation: A movie theater has N seats 1 to N . Build a seat reservation system that performs one of
// the following operation K times 1.
// Fetches the smallest-numbered unreserved seat then reserves it and returns its number 2. Cancels a seat reservation for seat[i]

// Here's a Java program for a seat reservation system where you can perform two operations:
//
//Fetch the smallest-numbered unreserved seat and reserve it.
//Cancel the reservation for a specific seat.

public class SeatReservationSystem {

    // TreeSet to store available seats in ascending order
    private TreeSet<Integer> availableSeats;

    // Constructor to initialize available seats
    public SeatReservationSystem(int N) {
        availableSeats = new TreeSet<>();
        // Add all seats (1 to N) to the available seats set
        for (int i = 1; i <= N; i++) {
            availableSeats.add(i);
        }
    }

    // Method to fetch and reserve the smallest unreserved seat
    public int reserveSeat() {
        if (availableSeats.isEmpty()) {
            System.out.println("No available seats to reserve.");
            return -1;
        }
        // Fetch the smallest unreserved seat
        int seat = availableSeats.first(); // IMP
        // Reserve the seat by removing it from availableSeats
        availableSeats.remove(seat); // IMP
        return seat;
    }

    // Method to cancel a reservation for a specific seat
    public void cancelReservation(int seatNumber) {
        if (!availableSeats.contains(seatNumber)) {
            availableSeats.add(seatNumber);  // Add the seat back to available seats IMP
            System.out.println("Reservation for seat " + seatNumber + " has been cancelled.");
        } else {
            System.out.println("Seat " + seatNumber + " is already available.");
        }
    }

    public static void main(String[] args) {
        // Create a reservation system for N seats
        int N = 10;  // Example: 10 seats
        SeatReservationSystem system = new SeatReservationSystem(N);

        // Example usage
        System.out.println("Reserving a seat: " + system.reserveSeat());  // Fetch smallest unreserved seat
        System.out.println("Reserving a seat: " + system.reserveSeat());  // Fetch next smallest unreserved seat

        system.cancelReservation(1);  // Cancel reservation for seat 1
        System.out.println("Reserving a seat: " + system.reserveSeat());  // Fetch smallest unreserved seat again

        system.cancelReservation(5);  // Cancel reservation for seat 5
        system.cancelReservation(1);  // Cancel reservation for seat 1 again (already available)
    }
}

