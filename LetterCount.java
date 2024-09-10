import java.util.HashSet;

/**
 * Q3.
 * You are given a string letters made of N English letters. Count the number of different letters that appear in both uppercase and lowercase where all lowercase occurrences of the given letter appear before any uppercase occurrence.
 * For example, for letters = "aaAbcCABBc" the answer is 2. The condition is met for letters ‘a’ and ‘b’, but not for ‘c’.
 * Write a function:
 * class Solution { public int solution(String letters); }
 * that, given a string letters, returns the number of different letters fulfilling the conditions above.
 * Examples:
 * 1. Given letters = "aaAbcCABBc", the function should return 2, as explained above.
 * 2. Given letters = "xyzXYZabcABC", the function should return 6.
 * 3. Given letters = "ABCabcAefG", the function should return 0.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * string letters is made only of letters (a−z and/or A−Z).
 */
class LetterCount {
    public static int solution(String letters) {
        // Sets to track lowercase letters and their corresponding uppercase
        // Set to store the letters that meet the condition
        HashSet<Character> validLetters = new HashSet<>();
        // Set to store lowercase letters that have appeared
        HashSet<Character> lowercaseLettersSeen = new HashSet<>();
        HashSet<Character> uppercaseLettersSeen = new HashSet<>();
        // Set to store letters that have failed the condition
        HashSet<Character> invalidLetters = new HashSet<>();

        for (char ch : letters.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                // If it's a lowercase letter, mark it as seen
                if (!invalidLetters.contains(ch)) {
                    lowercaseLettersSeen.add(ch);
                }
                char upperCh = Character.toUpperCase(ch);

                if (uppercaseLettersSeen.contains(upperCh)) {
                    // If its upperCase version appeared before, it's invalid
                    validLetters.remove(ch);
                }
            } else {
                uppercaseLettersSeen.add(ch);
                // If it's an uppercase letter, check if its lowercase appeared before
                char lowerCh = Character.toLowerCase(ch);

                if (lowercaseLettersSeen.contains(lowerCh)) {
                    // If its lowercase version appeared before, it's valid
                    if (!invalidLetters.contains(lowerCh)) {
                        validLetters.add(lowerCh);
                    }
                } else {
                    // If no lowercase version appeared before, it's invalid
                    invalidLetters.add(lowerCh);
                    validLetters.remove(lowerCh);
                }
            }
        }

        // Return the number of valid letters
        return validLetters.size();
    }

    public static void main(String[] args) {
        String str = "aaAbcCABBc";
        System.out.println(solution(str));
        String str1 = "xyzXYZabcABC";
        System.out.println(solution(str1));
        String str2 = "ABCabcAefG";
        System.out.println(solution(str2));

    }
}
