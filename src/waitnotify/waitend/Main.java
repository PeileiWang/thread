package waitnotify.waitend;

/**
 * Created by Wangpl
 * Time 2018/8/29 14:24
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int workNum = 100;
        MyLatch latch = new MyLatch(workNum);
        Worker[] workers = new Worker[workNum];
        for (int i = 0; i < workNum; i++) {
            workers[i] = new Worker(latch);
            workers[i].start();
        }
        latch.await();
        System.out.println("collect worker results");
    }
}
