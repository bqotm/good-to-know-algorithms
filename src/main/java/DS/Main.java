package DS;

import java.util.PriorityQueue;

public class Main {

    /*
        4th largest elem :
        6 4 1 5 2 8 7 5 => 1 2 4 /5/ 6 7 8

     */

    //Kth Largest Element
    public static int kthLargest(int [] array, int k) {

        PriorityQueue<Integer> minHeap= new PriorityQueue<>(k);
        //minHeap.offer(array[0]);
        for (int i = 0; i < array.length; i++) {
            while(i<k){
                minHeap.offer(array[i++]);
            }
            if(array[i]> minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(array[i]);
            }
        }
        return minHeap.peek();
    }


    public static void main(String[] args) {
        int[] arr={6 ,4, 1 ,5 ,2 ,8, 7 ,5};
        System.out.println(kthLargest(arr, 4));
    }

}
