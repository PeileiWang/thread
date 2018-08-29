package waitnotify.providerconsumer;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wangpl
 * Time 2018/8/29 11:43
 */
public class Producer extends Thread {
    private MyBlockQueue<String> queue;

    public Producer(MyBlockQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (true) {
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("Produce task: " + task);
                num++;
                Thread.sleep((long)(Math.random()*100));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
