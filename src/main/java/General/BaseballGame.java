package General;

// see coding challenges by company
// You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
//
//You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
//
//An integer x.
//Record a new score of x.
//'+'.
//Record a new score that is the sum of the previous two scores.
//'D'.
//Record a new score that is the double of the previous score.
//'C'.
//Invalidate the previous score, removing it from the record.
//Return the sum of all the scores on the record after applying all the operations.
//
//The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

import java.util.*;

public class BaseballGame {
    public static int calPoints(String[] ops) {
        Stack<Integer> record = new Stack<>();

        for (String op : ops) {
            if (op.equals("+")) {
                // Sum of the last two valid scores
                int top = record.pop();
                int newScore = top + record.peek();
                record.push(top); // Push the top element back after peeking
                record.push(newScore); // Add the sum of the last two
            } else if (op.equals("D")) {
                // Double the last valid score
                record.push(2 * record.peek());
            } else if (op.equals("C")) {
                // Invalidate the last valid score
                record.pop();
            } else {
                // Add the score (an integer)
                record.push(Integer.valueOf(op));
            }
        }

        // Sum up all the values in the stack
        int totalScore = 0;
        for (int score : record) {
            totalScore += score;
        }

        return totalScore;
    }

    public static void main(String[] args) {
        // Example test case
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println("Total score: " + calPoints(ops)); // Output: 30
    }
}

