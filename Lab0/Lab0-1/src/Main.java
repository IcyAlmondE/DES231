//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int M=12;
        makeMultTable(M);
    }

    public static void makeMultTable(int M){
        System.out.println("X\tM");
        for(int i=1;i<=12; i++){
            System.out.println(i + "\t" + M*i);
        }
    }
}