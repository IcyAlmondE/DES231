import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sumDigit(n));
    }

    static int sumDigit(int n){
        if(n==0) return 0;
        else return n%10 + sumDigit(n/10);
    }
}