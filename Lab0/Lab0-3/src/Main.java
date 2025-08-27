//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int w = 4;

        makeUpwardRightTriangle(w);
        printf("\n");
        makeDownwardRightTriangle(w);
        printf("\n");
        makeUpwardIsosceles(w);
    }

    static void printf(String s){
        System.out.print(s);
    }

    static void makeUpwardRightTriangle(int w){
        for(int i=0; i<w; i++){
            for(int j=0; j<i+1; j++){
                printf("*");
            }
            printf("\n");
        }
    }

    static void makeDownwardRightTriangle(int w){
        for(int i=0; i<w; i++){
            for(int j=0; j<w-i; j++){
                printf("*");
            }
            printf("\n");
        }
    }

    static void makeUpwardIsosceles(int w){
        for(int i=0; i<w+1; i++){
            for(int j=0; j<w-i; j++) printf(" ");
            for(int j=0; j<2*i+1; j++) printf("*");
            printf("\n");
        }
    }
}