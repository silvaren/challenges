package strings;

import java.util.*;

public class Intro {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();

        System.out.println(a.length() + b.length());
        System.out.println(isLexBigger(a,b));
        System.out.println(capitalizeFirst(a) + " " + capitalizeFirst(b));
    }

    private static String capitalizeFirst(String a) {
        return Character.toString(a.charAt(0)).toUpperCase() + a.substring(1);
    }

    private static String isLexBigger(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (i == b.length())
                return "No";

            if (a.charAt(i) > b.charAt(i))
                return "Yes";

            if (a.charAt(i) < b.charAt(i))
                return "No";
        }
        return "No";
    }
}
