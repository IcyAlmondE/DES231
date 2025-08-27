import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }
        int sum = sc.nextInt();

        findPairWithSum(A, sum);
    }

    static void findPairWithSum(int[] A, int sum){
        boolean found = false;
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                if(A[i]+A[j]==sum){
                    found = true;
                    System.out.println("true // sum of "+A[i]+" and "+A[j]+" is "+sum);
                }
            }
        }
        if(!found) System.out.println("false");
    }
}