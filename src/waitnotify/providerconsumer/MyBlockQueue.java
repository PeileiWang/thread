package waitnotify.providerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Wangpl
 * Time 2018/8/29 11:39
 */
public class MyBlockQueue<E> {
    private Queue<E> queue = null;
    private int limit;

    public MyBlockQueue(int limit) {
        this.queue = new ArrayDeque<>(limit);
        this.limit = limit;
    }

    public synchronized void put(E e) throws InterruptedException {
        while(queue.size() == limit) {
            wait();
        }
        queue.add(e);
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while(queue.size() == 0) {
            wait();
        }
        E e = queue.poll();
        notifyAll();
        return e;
    }

}
