package integral;

/**
 * Created by Yevhen on 29.08.2015.
 */
public class MyFunction implements Function {
    @Override
    public double f(double x) {
        return Math.sin(x);
    }
}
