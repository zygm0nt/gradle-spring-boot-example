package hello;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamsTest {


    @Test
    public void shouldExecuteASimpleTest() {
        initialData()
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Optional<String> reduced =
                initialData()
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }

    private List<String> initialData() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        return stringCollection;
    }
}
