package io.github.siaust;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // "abc" = 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // "b" = 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // "wke" = 3
        System.out.println(lengthOfLongestSubstring(" ")); // " " = 1
        System.out.println(lengthOfLongestSubstring("au")); // "au" = 2
        System.out.println(lengthOfLongestSubstring("dvdf")); // "vdf" = 3
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // "abc" = 3
    }

    /* Brute force algorithm */
    public static int lengthOfLongestSubstring(String s) {
        List<Set<Character>> list = new ArrayList<>();
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (characterSet.contains(s.charAt(j))) {
                    list.add(characterSet);
                    characterSet = new HashSet<>();
                    break;
                }
                characterSet.add(s.charAt(j));
                if (j == s.length() -1) {
                    list.add(characterSet);
                }
            }
        }

        int maxLength = 0;
        for (Set<Character> set : list) {
            if (set.size() > maxLength) {
                maxLength = set.size();
            }
        }
        return maxLength;
    }
}

/* Given a string s, find the length of the longest substring without repeating characters. */