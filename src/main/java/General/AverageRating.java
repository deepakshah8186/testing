package General;

import java.util.ArrayList;

public class AverageRating {

    // Method to calculate the average rating
    public static double calculateAverageRating(ArrayList<int[]> ratings) {
        int totalRating = 0;
        int count = 0;

        // Loop through each pair and sum the ratings
        for (int[] ratingPair : ratings) {
            totalRating += ratingPair[1];  // ratingPair[1] contains the rating
            count++;
        }

        // Calculate average
        return (double) totalRating / count;
    }

    public static void main(String[] args) {
        // Define the list of [ID, rating] pairs
        ArrayList<int[]> ratings = new ArrayList<>();
        ratings.add(new int[]{512, 3});
        ratings.add(new int[]{123, 3});
        ratings.add(new int[]{987, 4});
        ratings.add(new int[]{123, 4});

        // Calculate and print the average rating
        double averageRating = calculateAverageRating(ratings);
        System.out.println("The average rating is: " + averageRating);
    }
}
