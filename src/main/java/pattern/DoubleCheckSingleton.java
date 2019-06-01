package pattern;

/**
 * Created by 71518 on 2019/6/1.
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton inst;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (inst == null) {
            synchronized (DoubleCheckSingleton.class) {
                inst = new DoubleCheckSingleton();
            }
        }
        return inst;
    }
}
