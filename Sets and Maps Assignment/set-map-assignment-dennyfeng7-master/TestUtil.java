import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TestUtil{
    public static void assertTrue(final boolean input) throws IllegalArgumentException{
        if( ! input ) {
            throw new IllegalArgumentException("Condition is not true");
        }
    }

    public static void assertFalse(final boolean input) throws IllegalArgumentException{
        if( input ) {
            throw new IllegalArgumentException("Condition is not false");
        }
    }

    public static void assertEqual(final List<Integer> expected, final List<Integer> actual ){
        if(expected == null || actual == null){
            throw new InvalidParameterException("One or both parameters are null");
        }
        if(expected.size() != actual.size() ){
            throw new InvalidParameterException("Parameters do not have the same size");
        }
        if(!listContainSameContent(expected, actual)) {
            throw new IllegalArgumentException("Two lists are not the same");
        }
    } 
    
    public static void assertEqual(final int expected, final int actual ){
        if (expected!=actual) {
            throw new IllegalArgumentException("two numbers are not the same");
        }
    } 
    
    private static boolean listContainSameContent(final List<Integer> list1, final List<Integer> list2 ){
        Set<Integer> set = new HashSet<>();
        for(Integer num : list1){
            set.add(num);
        }
        for(Integer num : list2){
            if(set.contains(num)) {
                set.remove(num);
            }else{
                return false;
            }
        }
        return set.isEmpty();
    }
}