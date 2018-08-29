package waitnotify.providerconsumer;

/**
 * Created by Wangpl
 * Time 2018/8/29 11:47
 */
public class Consumer extends Thread{
    private MyBlockQueue<String> queue;

    public Consumer(MyBlockQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String task = queue.take();
                System.out.println("handle task: " + task);
                Thread.sleep((long)(Math.random()*100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
