package synchronizedtest;

/**
 * Created by Wangpl
 * Time 2018/8/29 10:20
 */
public class Counter {
    private int count;

    public synchronized void incr() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
