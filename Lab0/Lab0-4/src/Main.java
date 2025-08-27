import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int base = scanner.nextInt(), exponent = scanner.nextInt();
        System.out.println(calculatePower(base, exponent));
    }

    static int calculatePower(int base, int exponent) {
        int res = 1;
        for(int i=0; i<exponent; i++) {
            res *= base;
        }
        return res;
    }
}