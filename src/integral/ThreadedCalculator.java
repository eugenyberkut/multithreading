package integral;

/**
 * Created by Yevhen on 02.09.2015.
 */
public class ThreadedCalculator extends Thread {
    Main main;
    double a;
    double b;
    int n;
    Function f;

    public ThreadedCalculator(Main main, double a, double b, int n, Function f) {
        this.main = main;
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }

    @Override
    public void run() {
        IntegralCalculator calculator = new IntegralCalculator(a, b, n, f);
        double result = calculator.calculate();
        main.sendResult(result);
    }
}
