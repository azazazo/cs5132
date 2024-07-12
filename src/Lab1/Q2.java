package Lab1;

import java.util.Arrays;

public class Q2 {
    static boolean m1(char[] a, char[] b) {
        // call helper function
        return m1("", String.valueOf(a), String.valueOf(b));
    }

    static boolean m1(String prefix, String a, String b) {
        // recursively check permutations
        // base case: a has no characters left
        if (a.isEmpty()) return prefix.equals(b);
        // a has some characters left
        for (int i = 0; i < a.length(); i++) {
            // pick a character of a and append to prefix, then remove that character from a
            // and call the function again
            String n = prefix + a.charAt(i);
            String remaining = a.substring(0, i) + a.substring(i + 1);
            if (m1(n, remaining, b)) return true;
        }
        return false;
    }

    static boolean m2(char[] a, char[] b) {
        // compare lengths first
        if (a.length != b.length) return false;
        // maintain an array to check whether chars have been used yet
        boolean[] seen = new boolean[a.length];
        // for each char in a check if the char is in b
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                // if char in b is used already we cant use it
                if (seen[j]) continue;
                if (a[i] == b[j]) {
                    seen[j] = true;
                }
            }
        }
        // check that all chars in b have been used
        for (boolean s: seen) {
            if (!s) return false;
        }
        return true;
    }

    static boolean m3(char[] a, char[] b) {
        // sort and compare
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    static boolean m4(char[] a, char[] b) {
        // maintain an array of how many times we have seen each character
        int[] count = new int[26];
        for (char c: a) {
            count[c - 'a']++;
        }
        for (char c: b) {
            count[c - 'a']--;
        }
        // if number of each character is the same in both strings i.e.
        // they are anagrams, the array should be all zeroes
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
