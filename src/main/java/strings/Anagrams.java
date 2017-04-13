package strings;

import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        HashMap<Integer, Integer> freqsa = new HashMap<>();
        HashMap<Integer, Integer> freqsb = new HashMap<>();
        a.toLowerCase().chars().forEach(c -> freqsa.put(c, freqsa.getOrDefault(c, 0) + 1));
        b.toLowerCase().chars().forEach(c -> freqsb.put(c, freqsb.getOrDefault(c, 0) + 1));
        return freqsa.equals(freqsb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sa = in.next();
        String sb = in.next();

        if (isAnagram(sa,sb))
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }
}
