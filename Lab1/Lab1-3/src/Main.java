import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sumEven(n));
    }

    static int sumEven(int n) {
        if(n%2==0){
            if(n==0) return 0;
            else return n + sumEven(n-2);
        }
        else return sumEven(n-1);
    }
}