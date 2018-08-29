package waitnotify.beginsametime;

/**
 * Created by Wangpl
 * Time 2018/8/29 12:01
 */
public class FireFlag {
    private boolean fired = false;
    public synchronized void waitForFire() throws InterruptedException {
        while (!fired) {
            wait();
        }
    }

    public synchronized void fire() {
        this.fired = true;
        notifyAll();
    }
}
