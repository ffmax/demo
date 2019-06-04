package guava.concurent;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by 71518 on 2019/6/4.
 */
public class ListenFutureDemo {
    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1));

        ListenableFuture<Integer> future = service.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });

         service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> explosion = service.submit(new Callable<Integer>() {
            public Integer call() {
                return 1;
            }
        });
//        Futures.addCallback(explosion, new myCallBack(),MoreExecutors.directExecutor());
        Futures.addCallback(explosion, new myCallBack(),service);

    }

    private static class myCallBack implements FutureCallback<Integer>{


        @Override
        public void onSuccess(@Nullable Integer integer) {
            System.out.println(Thread.currentThread() + " success");

        }

        @Override
        public void onFailure(Throwable throwable) {
            System.out.println(Thread.currentThread()+" fail");

        }
    }
}
