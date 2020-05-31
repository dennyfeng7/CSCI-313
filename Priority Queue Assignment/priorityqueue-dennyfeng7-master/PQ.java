//MAX HEAP
//The higher the number, the higher the priority

import java.util.ArrayList;
import java.util.List;

public class PQ{
    int data[];
    int size;
    int capacity;

    PQ(int capacity){
        this.capacity = capacity;
        size = 0;
        data = new int[capacity];
    }

    PQ(){
        capacity = 1000;
        size = 0;
        data = new int[capacity];
    }

    PQ(List<Integer> data){
        capacity = data.size() > 1000 ? data.size() : 1000;
        size = data.size();
        heapify(data);
    }

    public void insert(int x){
        //Insert the new data into the PQ, ensure the heap maintains heap order/shape
        if(size == capacity){
            System.out.println("Queue is full.");
        }
        data[size] = x;
        bubbleUp(size);
        size++;
    }

    public void remove(){
        //Removes the root or the node with the highest priority
        if(size <= 0) {
            System.out.println("Empty Queue.");
        }
        data[0] = data[--size];
        bubbleDown(0);
    }

    public int poll(){
        //Returns the node with the highest priority. This method should NOT remove that node
        if(size == 0) {
            System.out.println("Empty");
        }
        return data[0];
    }

    private void heapify(List<Integer> data){
        //implement the heapify method that will build a PQ given a list of data
        this.data = new int[capacity];
        for (int i = 0; i < size; i++) {
            this.data[i] = data.get(i);
        }
        int n = size / 2;
        while(--n >= 0) {
            bubbleDown(n);
        }
    }

    public List<Integer> toSortedList() throws Exception {
        //this method will return a list of all the integers in the priority queue in sorted order (Max Heap)
        //this method will remove all the data from the pq
        List<Integer> result = new ArrayList<>();
        while (size > 0) {
            result.add(poll());
            remove();
        }
        return result;
    }

    private void bubbleUp(int x) {
        if(x <= 0) return;
        int current = data[x];
        int parent = data[(x-1)/2];
        if(parent >= current) return;
        swap(x, (x-1)/2);
        bubbleUp((x-1)/2);
    }

    private void bubbleDown(int x){
        if(2*x+1 >= size) return;
        int current = data[x];
        int childLeft = data[(2*x)+1];
        int childRight = childLeft;
        if(2*x+2 < size) {
            childRight = data[2*x+2];
        }
        if(childLeft > current && childLeft >= childRight) {
            swap(x, (2*x)+1);
            bubbleDown((2*x)+1);
        }
        else if(childRight > current && childRight >= childLeft) {
            swap(x, (2*x)+2);
            bubbleDown((2*x)+2);
        } else return;
    }

    private void swap(int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}