import java.util.*;

/**
 * Q1.
 * There is an array A consisting of N integers. What is the maximum sum of two integers from A that share their first and last digits? For example, 1007 and 167 share their first (1) and last (7) digits, whereas 2002 and 55 do not.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A consisting of N integers, returns the maximum sum of two integers that share their first and last digits. If there are no two integers that share their first and last digits, the function should return −1.
 * Examples:
 * 1. Given A = [130, 191, 200, 10], the function should return 140. The only integers in A that share first and last digits are 130 and 10.
 * 2. Given A = [405, 45, 300, 300], the function should return 600. There are two pairs of integers that share first and last digits: (405, 45) and (300, 300). The sum of the two 300s is bigger than the sum of 405 and 45.
 * 3. Given A = [50, 222, 49, 52, 25], the function should return −1. There are no two integers that share their first and last digits.
 * 4. Given A = [30, 909, 3190, 99, 3990, 9009], the function should return 9918.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [10..1,000,000,000].
 */
public class MaximumSum {
    public static int maxSum(int[] arr) {
        // A map to store the list of numbers that share the same first and last digit
        Map<String, List<Integer>> digitGroups = new HashMap<>();
        // Process each number in the array
        for (int num : arr) {
            // Get the first and last digits
            int lastDigit = num % 10;
            int firstDigit = num;
            // Extract the first digit by dividing the number by 10 until it's a single digit
            while (firstDigit >= 10) {
                firstDigit /= 10;
            }
            // Create a key based on first and last digits
            String key = firstDigit + "," + lastDigit;
            // Add the number to the corresponding group
            digitGroups.putIfAbsent(key, new ArrayList<>());
            digitGroups.get(key).add(num);
        }
        int maxSum = -1;
        for (List<Integer> group : digitGroups.values()) {
            if (group.size() > 1) {
                // Sort the group in descending order to find the two largest numbers
                Collections.sort(group, Collections.reverseOrder());
                // Calculate the sum of the two largest numbers
                int sum = group.get(0) + group.get(1);

                // Update the maximum sum if necessary
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {130, 191, 200, 10};
        System.out.println(maxSum(arr));
        int[] arr1 = {405, 45, 300, 300};
        System.out.println(maxSum(arr1));
        int[] arr2 = {50, 222, 49, 52, 25};
        System.out.println(maxSum(arr2));
        int[] arr3 = {30, 909, 3190, 99, 3990, 9009};
        System.out.println(maxSum(arr3));
    }
}
