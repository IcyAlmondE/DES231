/**
 * A generic queue implementation using a singly linked list.
 *
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> {
    /** The underlying singly linked list for the queue. */
    SList<T> list = new SList<T>();

    /** Default constructor to initialize an empty queue. */
    Queue() {
    }

    /**
     * Enqueues an element into the queue.
     *
     * @param element the element to enqueue
     */
    void enqueue(T element) {
        list.addLast(element);
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Dequeues an element from the queue.
     *
     * @return the dequeued element
     */
    T dequeue() {
        return list.removeFirst();
    }

    /**
     * Gets the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     */
    T queuefront() {
        return list.first.element;
    }

    /**
     * Gets the element at the rear of the queue without removing it.
     *
     * @return the element at the rear of the queue
     */
    T queuerear() {
        return list.last.element;
    }
    /**
     * Creates a copy of this queue.
     *
     * @return a new queue containing the same elements as this queue
     */
    Queue<T> copyQueue() { // Exercise 4
        Queue<T> Q2 = new Queue<T>();
        // Add your code here
        return Q2;
    }

    /**
     * Checks if this queue is identical to another queue in terms of content and
     * sequence.
     *
     * @param Q2 the queue to compare with
     * @return true if the queues are identical, false otherwise
     */
    boolean isIdentical(Queue<T> Q2) {
        if (list.size != Q2.list.size)
            return false;

        boolean identical = true;
        int size = Q2.list.size;

        for (int i = 0; i < size; i++) {
            T e1 = Q2.dequeue();
            T e2 = dequeue();
            if (identical && e1 != e2) {
                identical = false;
            }
            Q2.enqueue(e1);
            enqueue(e2);
        }
        return identical;
    }



    /**
     * Prints the elements of the queue horizontally. Handles potential
     *
     */
    void printHorizontal() {
        Node<T> walker = list.first;
        while (walker != null) {
            System.out.print(walker.element + " ");
            walker = walker.next;
        }

    }

    public int getSize() {
        return list.getSize();
    }


}