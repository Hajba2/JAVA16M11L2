import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        //Stream<String> stream = Stream.of(1, "2");
        System.out.println("Hello world!");

        int [] arr = {1,2,3,4,5,6};
        of(arr);
        ofVarArgs(2,3,4,5,66,78,9);
    }

    public static void of(int[] arr) {

    }

    public static void ofVarArgs(int... arr) {
        for(int i : arr) {
            System.out.println(i);
        }
    }
}