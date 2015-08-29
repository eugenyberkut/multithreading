package integral;

/**
 * Created by Yevhen on 29.08.2015.
 */
public class IntegralCalculator {
    double a;
    double b;
    int n;
    Function f;

    public IntegralCalculator(double a, double b, int n, Function f) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.f = f;
    }

    public double calculate() {
        double h = (b-a)/n;
        double sum = (f.f(a) + f.f(b))/2;
        for (int i=1; i<n; i++) {
            sum += f.f(a+i*h);
        }
        return sum*h;
    }
}
