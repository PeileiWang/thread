package ordinary;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Wangpl
 * Time 2018/8/28 17:14
 */
public class ThreadTest {

    public static final int COUNT = 200000;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final List<Integer> integers = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            Thread thread = new Thread(() -> integers.add(random.nextInt()));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(integers.size());

    }
}
