package logic;

/**
 * Created by Yevhen on 29.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        // Thread - class
        // Runnable - interface
        MyThread mt1 = new MyThread();
        mt1.setName("t1");
        MyThread mt2 = new MyThread();
        mt2.setName("t2");
        MyThread2 mt3 = new MyThread2();
        mt3.setName("t3");
        MyThread2 mt4 = new MyThread2();
        mt4.setName("t4");

        mt1.start();
        mt2.start();
        new Thread(mt3).start();
        new Thread(mt4).start();

        System.out.println("Hello");
    }
}
