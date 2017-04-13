package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxMinSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();

        List<String> substrings = new ArrayList<>();
        for (int i = 0; i <= s.length()-k; i++) {
            substrings.add(s.substring(i, i+k));
        }
        String[] sortedStrings = substrings.stream().sorted().toArray(String[]::new);
        System.out.println(sortedStrings[0]);
        System.out.println(sortedStrings[sortedStrings.length-1]);
    }
}
