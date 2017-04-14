package strings;

import java.util.Scanner;
import java.util.stream.Stream;

public class Token {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String[] tokens = s.split("[^A-Za-z]");
        String[] actualTokens = Stream.of(tokens).filter(x -> x.length() > 0).toArray(String[]::new);
        System.out.println(actualTokens.length);
        Stream.of(actualTokens).forEach(System.out::println);

        scan.close();
    }
}
