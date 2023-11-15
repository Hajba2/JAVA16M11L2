package random;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomAlgStream {

    public static void main(String[] args) {
        RandomAlg ra = new RandomAlg();
        Stream<Integer> iterate = Stream.iterate(485222, (seed) -> ra.withSeed(seed).next());

        List<Integer> collect = iterate
                .peek(System.out::println)
                .limit(10)
                .collect(Collectors.toList());
    }
}
