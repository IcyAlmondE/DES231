import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(subsum(n));
    }

    static int subsum(int n){
        int res;
        if(n == 1) return 1;
        else{
            if(n%2==0) res = (-1)*n;
            else res = n;
        }

        return res+subsum(n-1);
    }
}