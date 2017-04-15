package strings;

import java.util.Scanner;
import java.util.stream.IntStream;

public class HashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        java.util.HashSet<String> hashSet = new java.util.HashSet<>();
        IntStream.range(0,t).forEach(i -> {
            hashSet.add(pair_left[i] + "," + pair_right[i]);
            System.out.println(hashSet.size());
        });
    }
}
