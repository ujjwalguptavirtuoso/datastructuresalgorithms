
package datastructures.heap;

/**
 *
 * @version $Id: MaxHeap.java, v 0.1 2022-04-26 23:03
 */


/**
 * A-Max Heap is a Complete Binary Tree. A-Max heap is typically represented as an array. The root element will be at Arr[0].
 * Below table shows indexes of other nodes for the ith node, i.e., Arr[i]:
 *
 * Arr[(i-1)/2] Returns the parent node.
 * Arr[(2*i)+1] Returns the left child node.
 * Arr[(2*i)+2] Returns the right child node.
 */
public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0 ;
        Heap = new int[this.maxsize];
    }

    int parent(int pos){
        return (pos - 1 )/2;
    }

    int leftChild(int pos){
        return 2 * pos + 1;
    }

    int rightChild(int pos){
        return 2 * pos + 2;
    }

    boolean isLeaf(int pos){
        if(pos > (size/2) && pos <= size){
            return true;
        }
        return false;
    }


    void swap (int firstPos, int secondPos){
        int temp;
        temp = Heap[firstPos];
        Heap[firstPos] = Heap[secondPos];
        Heap[secondPos] = temp;
    }

    void insert(int element){
        Heap[size] = element;

        int current = size;
        while(Heap[current] > Heap[parent(current)]){
            swap(current , parent(current) );
            current = parent(current);
        }
        size ++;
    }

    public int extractMax(){
        int popped = Heap[0];
        // replace last elemnent with root
        Heap[0] = Heap[size--];
        maxHeapify(0);
        return popped;
    }

    void maxHeapify(int pos){

        if(isLeaf(pos))
            return;

        if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos]< Heap[rightChild(pos)]){
            if(Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }else{
                 swap(pos, rightChild(pos));
                 maxHeapify(rightChild(pos));
            }
        }

    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

       int extracted1 =  maxHeap.extractMax();
       int extracted2 = maxHeap.extractMax();


       System.out.println(extracted1);


        System.out.println(extracted2);
    }



}
