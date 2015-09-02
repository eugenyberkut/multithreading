package integral2;

import integral.MyFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Yevhen on 02.09.2015.
 */
public class Main {
    private static final int THREADS = 100;

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int p = runtime.availableProcessors();
        System.out.println("Processors = " + p);
        new Main().run();
    }

    private void run() {
        List<Future<Double>> futureList = new ArrayList<>();
        double a = 0;
        double b = Math.PI;
        int n = 1_000_000_000;
        double delta = (b - a) / THREADS;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < THREADS; i++) {
            Future<Double> future = executorService.submit(new CallableCalculator(a + i * delta, a + (i + 1) * delta, n / THREADS, new MyFunction()));
            futureList.add(future);
        }
        executorService.shutdown();
        try {
            double totalResult = 0;
            for (int i = 0; i < futureList.size(); i++) {
                totalResult += futureList.get(i).get();
            }
            long finish = System.currentTimeMillis();
            System.out.println(totalResult);
            System.out.println("time: " + (finish-start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
