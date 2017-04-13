package strings;

import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        String result = "";
        for (int i = start; i < end; i++) {
            result += s.charAt(i);
        }
        System.out.println(result);
    }
}
