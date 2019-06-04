package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.Arrays;

/**
 * Created by 71518 on 2019/6/4.
 */
public class StringsUtilDemo {
    public static void main(String[] args) {

        // jdk String.split method is very confusing
        String str = ",a,b,,,,";
        Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
        splitter.split(str).forEach(item -> System.out.println(item));

        //alternately,instead of using skipNulls, you may specify a string to use instead of null with useForNull(String)
        System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList(1, 2, 3, 4)));

    }
}
