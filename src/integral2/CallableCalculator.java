package integral2;

import integral.Function;
import integral.IntegralCalculator;

import java.util.concurrent.Callable;

/**
 * Created by Yevhen on 02.09.2015.
 */
public class CallableCalculator implements Callable<Double> {

    double a;
    double b;
    int n;
    Function f;

    public CallableCalculator(double a, double b, int n, Function f) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }

    @Override
    public Double call() throws Exception {
        return new IntegralCalculator(a,b,n,f).calculate();
    }
}
