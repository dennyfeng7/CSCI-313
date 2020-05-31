import java.util.*;

class Test1 extends TestUtil{
    public static void execute(){
        System.out.println("Running test suite 1...");
        int success = 0;
        int failure = 0;
        int numTest = 0;
        try{
            test1();
            success++;
            numTest++;
        }catch(Exception e) {
            System.out.println("Test 1 failed: " + e.toString());
            failure++;
            numTest++;
        }
        try{
            test2();
            success++;
            numTest++;
        }catch(Exception e) {
            System.out.println("Test 2 failed: " + e.toString());
            failure++;
            numTest++;
        }
        try{
            test3();
            success++;
            numTest++;
        }catch(Exception e) {
            System.out.println("Test 3 failed: " + e.toString());
            failure++;
            numTest++;
        }
        try{
            test4();
            success++;
            numTest++;
        }catch(Exception e) {
            System.out.println("Test 4 failed: " + e.toString());
            failure++;
            numTest++;
        }

        System.out.println("Number of tests ran: " + numTest);
        System.out.println("Number of successes: " + success);
        System.out.println("Number of failures: " + failure);
    }

    private static int repeatedNum(final List<Integer> input){
        //fill in
        Map<Integer,Integer> hm = new HashMap<>();

        for(int x : input) {
            if(hm.containsKey(x)) {
                hm.put(x, 2);
            } else {
                hm.put(x, 1);
            }

            //Check which set of keys has the value of 2.
            for(Integer key : hm.keySet()) {
                if(hm.get(key) == 2) {
                    return key;
                }
            }

        }
        return -1;
    }

    private static void test1(){
        final Integer data[] = new Integer[]{2,1,4,5,1,66,0};
        List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final int solution = 1;
        assertEqual(solution, repeatedNum(input));
    }
    private static void test2(){
        final Integer data[] = new Integer[]{0,0};
        List<Integer> input = new ArrayList<>(Arrays.asList(data));
        int solution = 0;
        assertEqual(solution, repeatedNum(input));
    }
    private static void test3(){
        final Integer data[] = new Integer[]{-9,-9,6,5,9,8,7,4,55,69};
        List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final int solution = -9;
        assertEqual(solution, repeatedNum(input));
    }
    private static void test4(){
        final Integer data[] = new Integer[]{5598,645,4,5,1,66,0,5598};
        List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final int solution = 5598;
        assertEqual(solution, repeatedNum(input));
    }

}