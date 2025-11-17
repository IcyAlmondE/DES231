public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.printStack();

        s.pop();
        s.printStack();

        s.reverseStack().printStack();

        Stack<Integer> s2 = new Stack<>();
        s2 = s.copyStack();
        s2.printStack();

        System.out.println(binaryConversion(69420));

        System.out.println(isPalindrome("niggaggin"));

        System.out.println("------------------");

        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.printQueue();

        System.out.println(q.isIdentical(q.copyQueue()));
    }

    static String binaryConversion(int n){
        if(n==0) return "0";
        String res = "";
        Stack<Integer> S = new Stack<>();
        while(n>0){
            S.push(n%2);
            n/=2;
        }
        while(!S.isEmpty()){
            res += S.pop();
        }
        return res;
    }

    static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        Stack<Character> S1 = new Stack<>(), S2 = new Stack<>();
        for(int i=0; i<c.length; i++){
            S1.push(c[i]);
            S2.push(c[i]);
        }
        S2 = S2.reverseStack();
        for(int i=0; i<c.length; i++){
            if(S1.pop() != S2.pop()) return false;
        }
        return true;
    }

    // bro wtf is prob. 3-5 :skull:

    static class Stack<T>{
        SList<T> list = new SList<T>();

        Stack(){
        }

        void push(T element){
            list.addFirst(element);
        }

        T pop(){
            return list.removeFirst();
        }

        T peak(){
            return list.first.element;
        }

        boolean isEmpty(){
            if(list.size!=0) return false;
            else return true;
        }

        void printStack(){
            list.printList();
        }

        Stack<T> reverseStack(){
            Stack<T> S1 = new Stack<T>();
            Stack<T> S2 = new Stack<>();
            while(!isEmpty()){
                T temp = pop();
                S1.push(temp);
                S2.push(temp);
            }
            while(!S2.isEmpty()){
                push(S2.pop());
            }
            return S1;
        }

        Stack<T> copyStack(){
            Stack<T> S = reverseStack();
            return S.reverseStack();
        }
    }

    static class Queue<T>{
        SList<T> list = new SList<>();

        Queue(){
        }

        void enqueue(T element){
            list.addLast(element);
        }

        T dequeue(){
            return list.removeFirst();
        }

        T queueFront(){
            return list.first.element;
        }

        T queueRear(){
            return list.first.element;
        }

        boolean isEmpty(){
            if(list.size!=0) return false;
            else return true;
        }

        void printQueue(){
            list.printList();
        }

        Queue<T> copyQueue(){
            Queue<T> Q = new Queue<>();
            int c = 0;
            while(!isEmpty()){
                T e = dequeue();
                enqueue(e);
                Q.enqueue(e);
                c++;
                if(c==list.size) break;
            }
            return Q;
        }

        boolean isIdentical(Queue<T> Q){
            Queue<T> Q2 = Q.copyQueue();
            while(!Q2.isEmpty()){
                T e1 = dequeue();
                T e2 = Q2.dequeue();
                if(!e1.equals(e2)) return false;
                enqueue(e1);
            }
            return true;
        }
    }

    /* ------------------------------------ */

    static class Node<T>{
        T element;
        Node<T> next;

        Node(T element){
            this.element = element;
        }
    }

    static class SList<T>{
        Node<T> first = null;
        Node<T> last = null;
        int size = 0;

        SList(){}

        void printMeta(){
            System.out.println(first.element + " " + last.element + " " + size);
        }

        void printList(){
            Node<T> n = first;
            while(n != null){
                System.out.print(n.element+" ");
                n = n.next;
            }
            System.out.println();
        }

        void addFirst(T element){
            Node<T> newNode = new Node<T>(element);
            if(size!=0) newNode.next = first;
            else last = newNode;
            first = newNode;
            size++;
        }

        void addLast(T element){
            Node<T> newNode = new Node<>(element);
            if(size==0) first = newNode;
            else last.next = newNode;
            last = newNode;
            size++;
        }

        void addAtIndex(int index, T element){
            Node<T> newNode = new Node<>(element);
            if(index==0) addFirst(element);
            else if(index==size) addLast(element);
            else{
                Node<T> temp = first;
                for(int i=0; i<index-1; i++){
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
            size++;
        }

        T removeFirst(){
            if(first==null) return null;
            T val = first.element;
            Node<T> temp = first.next;
            first.next = null;
            first = temp;
            size--;
            return val;
        }

        T removeLast(){
            if(last==null) return null;
            T val = last.element;
            Node<T> temp = first;
            for(int i=0; i<size-2; i++){
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
            size--;
            return val;
        }

        T removeAtIndex(int index){
            T val;
            if(index==0) val = removeFirst();
            else if(index==size-1) val = removeLast();
            else{
                Node<T> temp = first;
                for(int i=0; i<index-1; i++){
                    temp = temp.next;
                }
                val = temp.next.element;
                temp.next = temp.next.next;
                size--;
            }
            return val;
        }

        void reverse(){
            Node<T> current = first;
            Node<T> prev = null;
            Node<T> next = null;
            while(current!=null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            Node<T> temp = last;
            last = first;
            first = temp;
        }

        int search(T element){
            Node<T> temp = first;
            int i=0;
            while(temp!=null){
                if(temp.element.equals(element)) return i;
                temp = temp.next;
                i++;
            }
            return -1;
        }
    }
}