package integral;

/**
 * Created by Yevhen on 29.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
//        IntegralCalculator calculator = new IntegralCalculator(0, Math.PI, 100000000, new MyFunction());
//        long start = System.currentTimeMillis();
//        double result = calculator.calculate();
//        long finish = System.currentTimeMillis();
//        System.out.println(finish - start);
        totalResult = 0;
        finishedThreadCount = 0;
        double a = 0;
        double b = Math.PI;
        int n = 1_000_000_000;
        double delta = (b-a)/THREADS;
        long start = System.currentTimeMillis();
        for (int i=0; i<THREADS; i++) {
            new ThreadedCalculator(this, a+i*delta, a+(i+1)*delta, n/THREADS, new MyFunction()).start();
        }
        try {
            synchronized (this) {
                while (finishedThreadCount<THREADS) {
                    wait();
                }
                System.out.println(totalResult);
                long finish = System.currentTimeMillis();
                System.out.println("time: " + (finish-start));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendResult(double result) {
        totalResult += result;
        finishedThreadCount++;
        notify();
    }

    double totalResult;
    int finishedThreadCount;
    final static int THREADS = 100;
}
