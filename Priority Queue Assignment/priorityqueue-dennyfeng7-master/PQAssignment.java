import java.util.List;
import java.util.ArrayList;
import java.util.Random; 

public class PQAssignment {
    public static void main(String args[]) throws Exception {
        List<Integer> list = randomList(20);
        System.out.println("Unsorted Input List: " + list.toString());
        PQ priorityQueue = new PQ(list);
        List<Integer> sortedList = priorityQueue.toSortedList();
        System.out.println("Sorted List Descending order: " + sortedList.toString());
    }

    private static List<Integer> randomList(int size){
        final Random rng = new Random();
        List<Integer> list = new ArrayList<>(size);
        for(int i = 0; i< size; i++){
            list.add(rng.nextInt()%10);
        }
        return list;
    }
}