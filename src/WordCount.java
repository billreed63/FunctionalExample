import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {

    static public void main(String args[]) {
        List<String> words = Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");
        WordCount.count(words);

    }
    public static void count(List<String> words) {

        Stream<String> word = words.parallelStream();
        Map<String, Long> result =  word.collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()
        ));

        System.out.print(result);

    }

}
