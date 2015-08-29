package integral;

/**
 * Created by Yevhen on 29.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        IntegralCalculator calculator = new IntegralCalculator(0, Math.PI, 100000000, new MyFunction());
        System.out.println(calculator.calculate());
    }
}
