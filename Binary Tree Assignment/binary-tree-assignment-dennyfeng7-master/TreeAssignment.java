import java.util.List;
import java.util.ArrayList;
import java.util.Random; 

public class TreeAssignment {
    public static void main(String args[]){
        List<Integer> list = randomList(8);
        System.out.println("Input List: " + list.toString());
        BinTree tree = new BinTree(list);
        System.out.println("Tree: \n" + tree);
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