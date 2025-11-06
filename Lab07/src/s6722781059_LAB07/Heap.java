package s6722781059_LAB07;

/**
 * The `Heap` class represents a simple heap data structure.
 * A heap is a specialized tree-based data structure that satisfies the heap property.
 * In this implementation, the heap is represented as an array.
 * The class provides methods for insertion, deletion, and heap sort.
 *
 */
public class Heap {
	
	/** The current number of elements in the heap. */
	int load = 0;
	
	/** The array representing the heap. */
	int[] hArray = new int[100];

	/**
     * Constructs an empty heap.
     */
	Heap() {
	}

	/**
     * Performs the reheapUp operation to maintain the heap property after insertion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapUp(int currentIndex) {
		 // Exercise 1
		//  add your code here 
		if(currentIndex>0) {
			int parentIndex = (currentIndex-1)/2;
			if(hArray[currentIndex]>hArray[parentIndex]) {
				swap(hArray, currentIndex, parentIndex);
				reheapUp(parentIndex);
			}
		}
		
		
	}

	/**
     * Inserts a new element into the heap and performs the necessary reheapUp operation.
     *
     * @param data The data to be inserted into the heap.
     */
	void insert(int data) {
		// Exercise 2
		// add your code here 
		hArray[load] = data;
		reheapUp(load);
		load++;
	}

	 /**
     * Performs the reheapDown operation to maintain the heap property after deletion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapDown(int currentIndex) {
		// Exercise 3
		// add your code here 
		int childIndex = currentIndex*2 + 1;
		if(hArray[childIndex]-hArray[currentIndex] < hArray[childIndex+1]-hArray[currentIndex]) childIndex+=1; // right is max	
		if(hArray[currentIndex] < hArray[childIndex]) {
			swap(hArray, currentIndex, childIndex);
		reheapDown(childIndex);
		}
	}

	/**
     * Deletes the root element of the heap and performs the necessary reheapDown operation.
     *
     * @return The value of the root element that was deleted.
     */
	int deleteRoot() {
		// Exercise 4
		// add your code here 
		int temp = hArray[0];;
		if(load-1>=0) {
			hArray[0] = hArray[load-1];
			hArray[load-1] = 0;
			load--;
			reheapDown(0);
		}
		return temp;
	}

	/**
     * Sorts the heap in ascending order.
     */
	void makeHeapSort() {
		// Exercise 5
		// add your code here 
		while(load>0) {
			int temp = deleteRoot();
			System.out.print(temp + " ");
		}
	}

	/**
     * Finds the level of a given node in the heap.
     *
     * @param nodeIndex The index of the node.
     * @return The level of the node in the heap.
     */
	int findLevel(int nodeindex) {
		int parent = (nodeindex - 1) / 2;
		int level = 0;

		if (parent > 0)
			level++;

		while (parent > 0) {
			parent = (parent - 1) / 2;
			level++;
		}
		return level;
	}

	/**
     * Swaps two elements in the heap array.
     *
     * @param A The heap array.
     * @param ind1 The index of the first element to be swapped.
     * @param ind2 The index of the second element to be swapped.
     */
	void swap(int[] A, int ind1, int ind2) {
		int temp = A[ind1];
		A[ind1] = A[ind2];
		A[ind2] = temp;
	}

	/**
     * Prints the elements of the heap array.
     */
	void printHeapArray() {
		for (int i = 0; i < load; i++)
			System.out.print(hArray[i] + " ");
		System.out.println();
	}

//optional
	// Exercise 6: Priority Queue Operations
    /** Inserts an element into the priority queue. */
    public void enqueue(int data) {
        /*complete the code */;
        insert(data);
    }

    /** Extracts and returns the maximum element (highest priority) from the priority queue. 
	 * 
	 *  @return the dequeue element
	*/
    public int dequeue() {
        int temp = deleteRoot();
        return temp;
	}

	/**
     * Checks if the priority queue is empty.
     *
     * @return True if the priority queue is empty, false otherwise.
     */
	public boolean isEmpty() {
		/* complete the code */;
		if (hArray[0] != 0) return false;
		return true;
	}
}