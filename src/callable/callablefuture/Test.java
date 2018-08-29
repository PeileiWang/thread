package callable.callablefuture;

import java.util.concurrent.*;

/**
 * Created by Wangpl
 * Time 2018/8/29 14:49
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> future = executorService.submit(task);
        executorService.shutdown();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        TimeUnit.SECONDS.sleep(3);

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
