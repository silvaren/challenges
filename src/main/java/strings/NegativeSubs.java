package strings;

import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Token {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        IntStream.range(0,n).forEach(x -> array[x] = scan.nextInt());
        OptionalInt negativeSubs = IntStream.range(0, n+1).reduce((acc, x) -> acc + negativeSubarrays(array, x));
        System.out.println(negativeSubs.getAsInt());
    }

    private static int negativeSubarrays(int[] array, int subArraySize) {
        int negative = 0;
        for (int i = 0; i <= array.length - subArraySize; i++) {
            int subSum = 0;
            for (int j = 0; j < subArraySize; j++) {
                subSum +=array[j+i];
            }
            if (subSum < 0)
                negative++;
        }
        return negative;
    }
}
