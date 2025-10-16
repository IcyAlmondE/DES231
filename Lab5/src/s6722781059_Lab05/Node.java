package s6722781059_Lab05;

public class Node<T> {

    T element;
    Node<T> next;

    Node(T element) {
        this.element = element;
        next = null;
    }
}