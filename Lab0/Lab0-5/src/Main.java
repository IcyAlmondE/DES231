import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        printHollowSquare(N);
    }

    static void printHollowSquare(int N){
        int i=0;
        while (i<N){
            int j=0;
            while (j<N){
                if(i==0 || i== N-1){
                    System.out.print("*");
                }
                else{
                    if(j==0 || j==N-1) System.out.print("*");
                    else System.out.print(" ");
                }
                j++;
            }
            i++;
            System.out.println("");
        }
    }
}