//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int M=100, k=3;
        deductK(M, k);
    }

    static void deductK(int M, int k){
        for(int i=0;; i++){
            int res = M - i * k;
            if(res<0) break;
            System.out.println(res);
        }
    }
}