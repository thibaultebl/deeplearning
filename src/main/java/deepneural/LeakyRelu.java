package deepneural;

public class LeakyRelu implements ActivationInterface{
    private final double alpha;

    public LeakyRelu() {
        this.alpha = 0.01;
    }
    @Override
    public double activate(double x) {
        return x > 0 ? x : alpha * x;
    }

    @Override
    public double derivative(double x) {
        return x > 0 ? 1.0 : alpha;
    }


}
