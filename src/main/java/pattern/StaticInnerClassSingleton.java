package pattern;

/**
 * Created by 71518 on 2019/6/1.
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {

    }

    private static class Holder {
        private static StaticInnerClassSingleton inst = new StaticInnerClassSingleton();
    }

    public StaticInnerClassSingleton getInst() {
        return Holder.inst;
    }
}
