package waitnotify.assemblepoint;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wangpl
 * Time 2018/8/29 15:15
 */
public class Tourist extends Thread {

    private AssemblePoint assemblePoint;

    public Tourist(AssemblePoint assemblePoint) {
        this.assemblePoint = assemblePoint;
    }

    @Override
    public void run() {
        try {
            //各自独立运行
            TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 1000));

            System.out.println("arrived  " + System.currentTimeMillis());
            //集合
            assemblePoint.await();
            //集合后执行其他操作
            System.out.println("all arrived  " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
