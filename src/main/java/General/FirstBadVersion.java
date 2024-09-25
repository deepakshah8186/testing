package General;

public class FirstBadVersion {

    // Mock API: In real implementation, this would be provided
    boolean isBadVersion(int version) {
        // This is a placeholder for the actual API that returns whether a version is bad
        return true;  // Change this logic according to the actual bad version
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // To prevent integer overflow
            if (isBadVersion(mid)) {
                // If mid is bad, the first bad version is at mid or before mid
                right = mid; // Move the right boundary to mid
            } else {
                // If mid is not bad, the first bad version is after mid
                left = mid + 1;
            }
        }

        // At the end of the loop, left == right, and it points to the first bad version
        return left;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();
        int n = 100; // Example: total versions
        int firstBad = solution.firstBadVersion(n);
        System.out.println("The first bad version is: " + firstBad);
    }
}

