package General;

import java.util.*;

// https://leetcode.com/problems/find-the-town-judge/
// In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
//
//If the town judge exists, then:
//
//The town judge trusts nobody.
//Everybody (except for the town judge) trusts the town judge.
//There is exactly one person that satisfies properties 1 and 2.
//You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
//
//Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.


// The below looks so tough
//class Solution {
//    public int findJudge(int n, int[][] trust) {
//
//    }
//}

// check chat gpt what does  trustCount[trustee]++ mean
// trustCount[trustee]:
//
//trustCount is an array where each index represents a person.
//trustee is the index in the array representing a specific person who is being trusted.
//trustCount[trustee] accesses the current value at that index, which represents how many people trust this particular person (trustee).
//++ (Increment Operator):
//
//The ++ operator increases the value of the variable by 1.
//So, trustCount[trustee]++ will increase the count of people who trust the trustee by 1

// trustCount = [0, 0, 0, 0]  // Let's assume 4 people (0 to 3)
//Let’s say trustee = 2, which means person 2 is being trusted. The expression trustCount[2]++ will:
//
//        Access trustCount[2] (which is currently 0).
//        Increment its value by 1, making it:
//        java
//        Copy code
//        trustCount[2] = 1
public class TrustRelationship {

    // Method to find the trusted person (example scenario)
    public int findJudge(int N, List<Trust> trusts) {
        // Array to count how many people trust each person
        int[] trustCount = new int[N + 1];

        // Array to check who trusts others
        int[] trustedByOthers = new int[N + 1];

        // Process trust relationships
        for (Trust t : trusts) {
            int trustor = t.getTrustor();
            int trustee = t.getTrustee();
            trustCount[trustee]++;       // trustee is trusted by trustor
            trustedByOthers[trustor]++;  // trustor trusts someone
        }

        // Check for the "judge"
        for (int i = 1; i <= N; i++) {
            if (trustCount[i] == N - 1 && trustedByOthers[i] == 0) {
                return i;  // Found the judge
            }
        }

        return -1; // No judge found
    }

    public static void main(String[] args) {
        // Example test case: N = 3, trust relationships
        List<Trust> trusts = new ArrayList<>();
        trusts.add(new Trust(1, 3));
        trusts.add(new Trust(2, 3));

        TrustRelationship solution = new TrustRelationship();
        int judge = solution.findJudge(3, trusts);

        System.out.println("The judge is: " + judge);  // Output: 3
    }
}

class Trust {
    int trustor;
    int trustee;

    // Constructor
    public Trust(int trustor, int trustee) {
        this.trustor = trustor;
        this.trustee = trustee;
    }

    // Getter methods
    public int getTrustor() {
        return trustor;
    }

    public int getTrustee() {
        return trustee;
    }

    @Override
    public String toString() {
        return "Trustor: " + trustor + ", Trustee: " + trustee;
    }
}

