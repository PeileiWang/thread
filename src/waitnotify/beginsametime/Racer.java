package waitnotify.beginsametime;

/**
 * Created by Wangpl
 * Time 2018/8/29 12:03
 */
public class Racer extends Thread {

    private FireFlag fireFlag = null;

    public Racer(FireFlag fireFlag) {
        this.fireFlag = fireFlag;
    }

    @Override
    public void run() {
        try {
            this.fireFlag.waitForFire();
            System.out.println("start run " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
