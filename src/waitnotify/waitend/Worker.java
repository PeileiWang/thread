package waitnotify.waitend;

/**
 * Created by Wangpl
 * Time 2018/8/29 14:21
 */
public class Worker extends Thread {

    private MyLatch latch;

    public Worker(MyLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Hi");
            Thread.sleep((int) (Math.random() * 1000));
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
