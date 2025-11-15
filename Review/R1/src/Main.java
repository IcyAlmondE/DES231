public class Main {
    public static void main(String[] args) {
        print(subsum(3) + "\n");

        print(sumDigit(1234) + "\n");

        Array A = new Array(50);
        A.addFirst(1);
        A.printArray();
        A.addFirst(3);
        A.printArray();
        A.addLast(5);
        A.printArray();
        A.addLast(4);
        A.printArray();
        A.addAtIndex(2, 4);
        A.printArray();
        A.addAtIndex(6, 1);
        A.printArray();

        A.removeFirst();
        A.printArray();
        A.removeLast();
        A.printArray();
        A.removeAtIndex(2);
        A.printArray();

        A.setElementAtIndex(7, 1);
        A.printArray();
        print(A.getElementAtIndex(2));
        print("\n");

        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Array B = new Array(50);
        for(int i=0; i<b.length; i++) B.addLast(b[i]);
        B.printArray();

        System.out.println("6: " + B.findPairWithSum(6));
        System.out.println("20: " + B.findPairWithSum(20));
    }

    static void print(int n){
        System.out.print(n);
    }

    static void print(String s){
        System.out.print(s);
    }

    static int subsum(int n){
        int val = n;
        if(n == 1){
            return 1;
        }
        else{
            if(n%2==0) val = -n;
            return val + subsum(n-1);
        }
    }

    static int sumDigit(int n){
        if(n==0) return 0;
        else{
            return n%10 + sumDigit(n/10);
        }
    }

    static class Array{
        final int size;
        int[] A;
        int load = 0;

        Array(int size){
            this.size = size;
            A = new int[size];
        }

        void printArray(){
            for(int i=0; i<load; i++){
                System.out.print(A[i]+" ");
            }
            System.out.println();
        }

        void addFirst(int n){
            for(int i=load; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = n;
            load++;
        }

        void addLast(int n){
            A[load] = n;
            load++;
        }

        void addAtIndex(int n, int index){
            for(int i=load; i>index; i--){
                A[i] = A[i-1];
            }
            A[index] = n;
            load++;
        }

        int removeFirst(){
            int temp = A[0];
            load--;
            for(int i=0; i<load; i++){
                A[i] = A[i+1];
            }
            return temp;
        }

        int removeLast(){
            int temp = A[load];
            A[load] = 0;
            load--;
            return temp;
        }

        int removeAtIndex(int index){
            int temp = A[index];
            load--;
            for(int i=index; i<load; i++){
                A[i] = A[i+1];
            }
            A[load] = 0;
            return temp;
        }

        int getElementAtIndex(int index){
            return A[index];
        }

        void setElementAtIndex(int val, int index){
            A[index] = val;
        }

        boolean findPairWithSum(int sum){
            for(int i=0; i<load; i++){
                for(int j=i+1; j<load; j++){
                    if(i+j==sum) return true;
                }
            }
            return false;
        }
    }
}