public class Main {
    public static void main(String[] args) {
        SList<Integer> l = new SList<Integer>();

        l.addFirst(7);
        l.addFirst(3);
        l.addFirst(1);
        l.addFirst(8);
        l.printList();
        l.printMeta();

        System.out.println("-----------------");

        l.addLast(5);
        l.addLast(9);
        l.printList();
        l.printMeta();

        System.out.println("-----------------");

        l.addAtIndex(1, 4);
        l.addAtIndex(2, 2);
        l.printList();
        l.printMeta();

        System.out.println("-----------------");

        l.removeFirst();
        l.removeLast();
        l.printList();
        l.printMeta();

        System.out.println("-----------------");

        l.removeAtIndex(1);
        l.printList();
        l.printMeta();

        System.out.println("-----------------");
        l.reverse();
        l.printList();
        l.printMeta();

        System.out.println("-----------------");

        System.out.println(l.search(7));
        System.out.println(l.search(9));
    }

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

        void removeFirst(){
            if(first==null) return;
            Node<T> temp = first.next;
            first.next = null;
            first = temp;
            size--;
        }

        void removeLast(){
            if(last==null) return;
            Node<T> temp = first;
            for(int i=0; i<size-2; i++){
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
            size--;
        }

        void removeAtIndex(int index){
            if(index==0) removeFirst();
            else if(index==size-1) removeLast();
            else{
                Node<T> temp = first;
                for(int i=0; i<index-1; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
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