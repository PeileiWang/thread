package pool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wangpl
 * Time 2018/8/28 17:06
 */
public class ThreadPoolTest {

    public static final int COUNT = 200000;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        final List<Integer> integers = new LinkedList<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(COUNT));
        final Random random = new Random();

        for (int i = 0; i < COUNT; i++) {
            executor.execute(() -> integers.add(random.nextInt()));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(integers.size());
    }
}
