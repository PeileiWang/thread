package waitnotify.assemblepoint;

/**
 * Created by Wangpl
 * Time 2018/8/29 15:18
 */
public class Main {
    public static void main(String[] args) {
        int num = 10;
        Tourist[] tourists = new Tourist[num];
        AssemblePoint assemblePoint = new AssemblePoint(num);

        for (int i = 0; i < num; i++) {
            tourists[i] = new Tourist(assemblePoint);
            tourists[i].start();
        }
    }
}
