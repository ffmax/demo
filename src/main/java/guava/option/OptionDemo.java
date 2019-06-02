package guava.option;

import java.util.Optional;

/**
 * Created by 71518 on 2019/6/2.
 *
 * 1. null can cause ambiguous case， for example,  if you get null from map.get(key),
 * either because the value in map is null, or the value is not in the map.
 * in Guava,
 * 2. Optional  can force you to consider how to solve null case
 *
 * In my opinion, fast fail is best method for null, or you can use Optional to package it, and consider null case.
 */
public class OptionDemo {
    public static void main(String[] args) throws Exception {
        // construct method
        Optional<Integer> i = Optional.of(1);
        Optional<Integer> nullOptional =  Optional.ofNullable(null);
        Optional<Integer> possible = Optional.ofNullable(5);

        //return value
        if(i.isPresent()){
            i.get();
        }
        nullOptional.orElse(1);
        nullOptional.orElseGet(() -> 5);
        nullOptional.orElseThrow(() -> new Exception());


    }
}
