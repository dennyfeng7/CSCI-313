import java.util.*;

class Test3 extends TestUtil{
    public static void execute(){
        System.out.println("Running test suite 3...");
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
    private static List<Integer> repeatedNumsWithGivenFreq(final List<Integer> input, final int targetFrequency){
        //fill in
        Map<Integer,Integer> hm = new HashMap<>();
        List<Integer> keyList = new ArrayList<>();

        for(int x : input) {
            if (hm.containsKey(x)) {
                hm.put(x, hm.get(x) + 1);
            } else {
                hm.put(x, 1);
            }
        }

            //Check which set of keys has the value of exactly 2.
            for(Integer key : hm.keySet()) {
                if(hm.get(key) == targetFrequency) {
                    keyList.add(key);
                }
            }


        return keyList;
    }

    private static void test1(){
        final Integer data[] = new Integer[]{7, 44, -10, 21, 12, 62, 5, 45, 31, 73, 57, 10, 100, 11, 94, 78, 71, 87, 88, -1};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{7, 44, -10, 21, 12, 62, 5, 45, 31, 73, 57, 10, 100, 11, 94, 78, 71, 87, 88, -1};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, repeatedNumsWithGivenFreq(input, 1));
    }
    private static void test2(){
        final Integer data[] = new Integer[]{-7, 14, 69, 22, 96, 10, 97, 0, 0, 27, 4, 32, -1, -4, 7, 7, 53, 9, 48, 18};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{0, 7};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, repeatedNumsWithGivenFreq(input, 2));
    }
    private static void test3(){
        final Integer data[] = new Integer[]{21, -8, 47, 91, 7, 87, 91, 33, 95, 29, 59, 88, 6, -5, 70, 55, 31, 3, 91 ,43, 5, 5, 5, 5};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{91};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, repeatedNumsWithGivenFreq(input, 3));
    }
    private static void test4(){
        final Integer data[] = new Integer[]{700, 398, -912, -711, -71, -301, -71, 316, 700, -71, -71, 700, 700, 316, 316};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{700, -71};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, repeatedNumsWithGivenFreq(input, 4));
    }
    private static void test5(){
        final Integer data[] = new Integer[]{45, 42, 42, 42, 99, 55, 63, 46, 99 ,70, 32, 93, 54, -9, 88, 88, -9 ,64, 1, 89, 88 ,13, 4, 35, 67, 4, 68};
        final List<Integer> input = new ArrayList<>(Arrays.asList(data));
        final Integer expectedData[] = new Integer[]{99, -9, 4};
        final List<Integer> expected = new ArrayList<>(Arrays.asList(expectedData));
        assertEqual(expected, repeatedNumsWithGivenFreq(input, 2));
    }
}