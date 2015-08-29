package logic;

/**
 * Created by Yevhen on 29.08.2015.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}
