package logic;

/**
 * Created by Yevhen on 29.08.2015.
 */
public class MyThread2 implements Runnable {
    private String name;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + ":" + i);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
