import java.util.*;

class Test2 extends TestUtil{
    public static void execute(){
        System.out.println("Running test suite 2...");
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
        try{
            test5();
            success++;
            numTest++;
        }catch(Exception e) {
            System.out.println("Test 5 failed: " + e.toString());
            failure++;
            numTest++;
        }

        System.out.println("Number of tests ran: " + numTest);
        System.out.println("Number of successes: " + success);
        System.out.println("Number of failures: " + failure);
    }
    private static List<Integer> numsRepeatedTwice(final List<Integer> input) {
        //fill in
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();


        for (int x : input) {
            if (hm.containsKey(x)) {
                hm.put(x, hm.get(x) + 1);
            } else {
                hm.put(x, 1);
            }
        }

        //Check which set of keys has the value of exactly 2.
        for (int key : hm.keySet()) {
            if (hm.get(key) == 2) {
                result.add(key);
            }
        }

        return result;
    }

    private static void test1(){
        final Integer data[] = new Integer[]{700, 398, -912, -711, -71, -301, -477, 316};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final List<Integer> expected = new ArrayList<>();
        assertEqual(expected, numsRepeatedTwice(input));
    }
    private static void test2(){
        final Integer data[] = new Integer[]{700, 398, -912, -711, -71, -301, -477, 316, 700, -71, -71, 65, 65};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{700, 65};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, numsRepeatedTwice(input));
    }
    private static void test3(){
        final Integer data[] = new Integer[]{700, 398, -912, -711, -71, -301, -477, 316, -711};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{-711};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, numsRepeatedTwice(input));
    }
    private static void test4(){
        final Integer data[] = new Integer[]{84, 55, 5, 8, 92, 66, 39, 76, -2, -10, 49, 60, 44, 77, 59, 33, 9, 84, 55, 5, 8, 92, 66, 39, 76, -2, -10, 49, 60, 44, 77, 59, 33, 9, 67, 15, -3};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{84, 55, 5, 8, 92, 66, 39, 76, -2, -10, 49, 60, 44, 77, 59, 33, 9};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, numsRepeatedTwice(input));
    }
    private static void test5(){
        final Integer data[] = new Integer[]{};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final List<Integer> expected = new ArrayList<>();
        assertEqual(expected, numsRepeatedTwice(input));
    }
}