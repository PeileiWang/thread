package memoryvisibility;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wangpl
 * Time 2018/8/29 10:07
 */
public class VisibilityDemo {

    private static boolean shutdown = false;

    static class HelloThread extends Thread {

        @Override
        public void run() {
            while (!shutdown){}
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //Thread永远不会退出。使用volatile关键字修饰shutdown
        new HelloThread().start();
        TimeUnit.SECONDS.sleep(1);
        shutdown = true;
        System.out.println("exit main");
    }
}
