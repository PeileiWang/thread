package waitnotify.providerconsumer;

/**
 * Created by Wangpl
 * Time 2018/8/29 11:50
 */
public class Main {

    public static void main(String[] args) {
        MyBlockQueue<String> queue = new MyBlockQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }

}
