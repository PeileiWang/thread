package racecondition;

/**
 * Created by Wangpl
 * Time 2018/8/29 9:57
 */
public class CounterThread extends Thread {
    private static int counter = 0;

    public static final int NUM = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[NUM];
        for (int i = 0; i < NUM; i++) {
            threads[i] = new CounterThread();
            threads[i].start();
        }
        for (int i = 0; i < NUM; i++) {
            threads[i].join();
        }
        //实际结果不为1000000
        System.out.println(counter);
    }
}
