package deepneural;

import java.util.Arrays;

public class SoftMax implements ActivationInterface {

    @Override
    public double activate(double x) {
        throw new UnsupportedOperationException("SoftMax only works with vector input");
    }
    @Override
    public double derivative(double x) {
        throw new UnsupportedOperationException("Use vector version with Jacobian");
    }
    public double[] activate(double[] inputs) {
        double max = Double.NEGATIVE_INFINITY;
        for (double val : inputs) if (val > max) max = val;

        double sum = 0;
        double[] exps = new double[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            exps[i] = Math.exp(inputs[i] - max);
            sum += exps[i];
        }
        for (int i = 0; i < exps.length; i++) exps[i] /= sum;
        return exps;
    }
}