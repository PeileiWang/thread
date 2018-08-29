package waitnotify.waitend;

/**
 * Created by Wangpl
 * Time 2018/8/29 14:19
 */
public class MyLatch {

    private int count;

    public MyLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        count--;
        if (count <= 0) {
            notifyAll();
        }
    }

}
