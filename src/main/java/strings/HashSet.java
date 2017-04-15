package strings;

import java.util.Scanner;

public class StringReverse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        boolean palindrome = true;
        for (int i = 0; i < s.length(); i++) {
            palindrome = palindrome && s.charAt(i) == s.charAt(s.length()-i-1);
        }
        if (palindrome)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
