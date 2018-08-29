package callable.callablefuturetask;


import java.util.concurrent.*;

/**
 * Created by Wangpl
 * Time 2018/8/29 14:59
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executorService.submit(futureTask);
        executorService.shutdown();

        //第二种方式
//        FutureTask<Integer> futureTask1 = new FutureTask<>(task);
//        Thread thread = new Thread(futureTask);
//        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + futureTask.get());
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

