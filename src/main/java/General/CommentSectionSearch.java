package General;

import java.util.*;

// A new video about the recent developments in coding has been published on the HackerEarth social media handle. After some time, it is seen that there are N comments added. The admin wants to see if there are any derogatory comments. Hence, he searched the comment section with a keyword S.
//
//Task
//Give the count of the comments that will be returned as a result of the search.
//
//Notes
//
//The count can be 0.
//The algorithm searches the keyword irrespective of the case of the word.
//The separator here is "_".

public class CommentSectionSearch {

    // Function to find the number of comments containing the keyword
    public static int solution(int N, String S, String[] comments) {
        // Convert keyword to lowercase for case-insensitive comparison
        S = S.toLowerCase();

        int count = 0; // To count the number of matching comments

        // Iterate over each comment
        for (String comment : comments) {
            // Convert the comment to lowercase and split words by '_'
            String[] words = comment.toLowerCase().split("_");

            // Check if any of the words match the keyword
            for (String word : words) {
                if (word.equals(S)) {
                    count++;
                    break; // No need to check other words in the same comment
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example input
        int N = 3;
        String S = "hate";
        String[] comments = {"The_video_is_good", "I_hate_this", "Informative"};

        // Call the solution function and print the result
        System.out.println("Number of comments containing the keyword: " + solution(N, S, comments));
    }
}

