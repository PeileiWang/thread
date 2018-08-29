package waitnotify.beginsametime;

/**
 * Created by Wangpl
 * Time 2018/8/29 12:06
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        FireFlag fireFlag = new FireFlag();
        Thread[] races = new Thread[num];
        for (int i = 0; i < num; i++) {
            races[i] = new Racer(fireFlag);
            races[i].start();
        }
        Thread.sleep(1000);
        fireFlag.fire();
    }
}
