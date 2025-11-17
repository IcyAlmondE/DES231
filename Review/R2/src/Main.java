public class Main {
    public static void main(String[] args) {
        int[] A = {3, 5, 7, 8, 9, 6, 1, 4};
        printArray(A);
        selectionSort(A, 0, A.length - 1);

        System.out.println("---------------------------");

        int[] B = {3, 5, 7, 8, 9, 6, 1, 4};
        printArray(B);
        insertionSort(B);

        System.out.println("---------------------------");

        int[] C = {3, 5, 7, 8, 9, 6, 1, 4};
        printArray(C);
        mergeSort(C);

        System.out.println("---------------------------");

        int[] D = {3, 5, 7, 8, 9, 6, 1, 4};
        printArray(D);
        quickSort(D, 0, D.length - 1);

        System.out.println("---------------------------");

        HashMap H = new HashMap(8, "Division", "Linear");
        H.fillHashTable(3);
        H.fillHashTable(11);
        H.fillHashTable(25);
        H.fillHashTable(18);
        H.printHashMap();

        System.out.println("---------------------------");

        System.out.println(H.search(25));
        System.out.println(H.search(11));
        System.out.println(H.search(69));

        System.out.println("---------------------------");

        H.deleteKey(3);
        H.printHashMap();
    }

    static void printArray(int[] A){
        for(int i = 0; i<A.length; i++){
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static int findMinIndex(int[] A, int start, int end){
        int minIndex = start;
        int min = A[start];
        for(int i = start; i <= end; i++){
            if(A[i] < min){
                min = A[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void selectionSort(int[] A, int start, int end){
        if(start == end) return;
        swap(A, start, findMinIndex(A, start, end));
        printArray(A);
        selectionSort(A, start+1, end);
    }

    static void insertionSort(int[] A){
        for(int i=1; i<A.length; i++){
            for(int j=i; j>0; j--){
                if(A[j] < A[j-1]){
                    swap(A, j, j-1);
                    printArray(A);
                }
            }
        }
    }

    static void mergeSort(int[] A) {
        if(A.length <= 1) return;
        int mid = A.length / 2;
        int[] left = new int[mid];
        int[] right = new int[A.length - mid];

        for(int i=0; i<mid; i++){
            left[i] = A[i];
        }
        for(int i=mid; i<A.length; i++){
            right[i-mid] = A[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(A, left, right);

        printArray(A);
    }

    static void merge(int[] A, int[] left, int[]right){
        int i=0, j=0, k=0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j]){
                A[k] = left[i];
                i++; k++;
            }
            else{
                A[k] = right[j];
                j++; k++;
            }
        }
        while(i<left.length){
            A[k] = left[i];
            i++; k++;
        }
        while(j<right.length){
            A[k] = right[j];
            j++; k++;
        }
    }

    static void quickSort(int[] A, int start, int end){
        if(start >= end) return;
        int pivot = A[end];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int i=0, j=0;
        for(int k=start; k<end; k++){
            if(A[k] < pivot){
                left[i] = A[k];
                i++;
            }
            else{
                right[j] = A[k];
                j++;
            }
        }
        for(int k=0; k<i; k++){
            A[start+k] = left[k];
        }
        for(int k=0; k<j; k++){
            A[k+start+i+1] = right[k];
        }
        A[start+i] = pivot;
        quickSort(A, 0, i-1);
        quickSort(A, i, i+j);
        printArray(A);
    }

    static class HashMap{
        int[] H;
        int size;
        String hfunction, openAddrType;

        HashMap(int size, String hfunction, String openAddrType){
            this.size = size;
            this.H = new int[size];
            this.hfunction = hfunction;
            this.openAddrType = openAddrType;
        }

        void printHashMap(){
            printArray(H);
        }

        void fillHashTable(int key){
            if(hfunction=="Division"){
                int addr = key%size;
                if(H[addr]==0) H[addr] = key;
                else{
                    int i=1;
                    if(openAddrType=="Linear"){
                        while(H[addr+i]!=0){
                            i++;
                        }
                        H[addr+i] = key;
                    }
                    else if(openAddrType=="Quadratic") {
                        while (H[addr + (i * i)] != 0) {
                            i++;
                        }
                        H[addr+(i*i)] = key;
                    }
                }
            }
            else{
                int c = 100;
                int addr = (key/c + key%c)%size;
                if(H[addr]==0) H[addr] = key;
                else{
                    int i=1;
                    if(openAddrType=="Linear"){
                        while(H[addr+i]!=0){
                            i++;
                        }
                        H[addr+i] = key;
                    }
                    else if(openAddrType=="Quadratic") {
                        while (H[addr + (i * i)] != 0) {
                            i++;
                        }
                        H[addr+(i*i)] = key;
                    }
                }
            }
        }

        int search(int key){
            if(hfunction=="Division"){
                int addr = key%size;
                if(H[addr]==key) return addr;
                else{
                    int i=1;
                    if(openAddrType=="Linear"){
                        while(H[(addr+i)%size]!=key){
                            i++;
                            if(i==size) return -1;
                        }
                        addr += i;
                    }
                    else if(openAddrType=="Quadratic") {
                        while (H[(addr + (i * i))%size] != 0) {
                            i++;
                            if(i==size) return -1;
                        }
                        addr += i*i;
                    }
                    if(H[addr]==key) return addr;
                }
            }
            else{
                int c = 100;
                int addr = (key/c + key%c)%size;
                if(H[addr]==key) return addr;
                else{
                    int i=1;
                    if(openAddrType=="Linear"){
                        while(H[(addr+i)%size]!=key){
                            i++;
                            if(i==size) return -1;
                        }
                        addr += i;
                    }
                    else if(openAddrType=="Quadratic") {
                        while (H[(addr + (i * i))%size] != 0) {
                            i++;
                            if(i==size) return -1;
                        }
                        addr += i*i;
                    }
                    if(H[addr]==key) return addr;
                }
            }
            return -1;
        }

        void deleteKey(int key){
            int index = search(key);
            if(index != -1){
                H[index] = 0;
            }
        }
    }
}