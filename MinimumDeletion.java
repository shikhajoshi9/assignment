/**
 * Q2.
 * We are given a string S of length N consisting only of letters 'A' and/or 'B'. Our goal is to obtain a string in the format "A...AB...B" (all letters 'A' occur before all letters 'B') by deleting some letters from S. In particular, strings consisting only of letters 'A' or only of letters 'B' fit this format.
 * Write a function:
 * class Solution { public int solution(String S); }
 * that, given a string S, returns the minimum number of letters that need to be deleted from S in order to obtain a string in the above format.
 * Examples:
 * 1. Given S = "BAAABAB", the function should return 2. We can obtain "AAABB" by deleting the first occurrence of 'B' and the last occurrence of 'A'.
 * 2. Given S = "BBABAA", the function should return 3. We can delete all occurrences of 'A' or all occurrences of 'B'.
 * 3. Given S = "AABBBB", the function should return 0. We do not have to delete any letters, because the given string is already in the expected format.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * string S is made only of the characters 'A' and/or 'B'.
 */
public class MinimumDeletion {
    // Function to find the minimum deletions
    public static int minStep(String str) {
        int charA = 'A';
        int numB = 0;
        int minDel = 0;

        for (int i = 0; i < str.length(); i++) {
            if (charA == str.charAt(i)) {
                minDel = Math.min(numB, minDel + 1);
            } else {
                numB++;
            }
        }
        return minDel;
    }
    /* Driver program to test above functions */
    public static void main(String []args){

        String s ="BAAABAB" ;
        System.out.println(minStep(s)) ;
        String s1 ="BBABAA" ;
        System.out.println(minStep(s1)) ;
        String s2 ="AABBBB" ;
        System.out.println(minStep(s2)) ;

    }
}
