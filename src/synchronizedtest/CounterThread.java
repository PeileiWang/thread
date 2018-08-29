package synchronizedtest;

/**
 * Created by Wangpl
 * Time 2018/8/29 10:21
 */
public class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void start() {
        for (int i = 0; i < 1000; i++) {
            counter.incr();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.getCount());
    }
}
