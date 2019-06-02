package java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Created by 71518 on 2019/6/1.
 */
public class Test {

    public static void main(String[] args) {

        Arrays.asList(1,2).stream().collect(Collectors.toList());
        Arrays.asList(1,2).stream().collect(Collectors.toSet());
        Arrays.asList(1,2).stream().collect(Collectors.toMap(id->id,id->id));
        Arrays.asList(1,2).stream().collect(Collectors.toCollection(HashSet::new));


    }
}
