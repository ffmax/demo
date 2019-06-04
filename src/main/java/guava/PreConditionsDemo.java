package guava;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by 71518 on 2019/6/3.
 * precondition checking utilities help us check arguments and fail fast
 */
public class PreConditionsDemo {
    public static void main(String[] args) {
        checkNotNull(new PreConditionsDemo());
        checkArgument(true);
        int i = 1;int j = 2;
        checkArgument(i>j," %s <= %j",i,j);

    }
}
