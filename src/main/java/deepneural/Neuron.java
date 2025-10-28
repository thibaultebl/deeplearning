package deepneural;

import java.util.Arrays;

public class Neuron {
    private double[] weights;
    private double bias;
    ActivationInterface activation;
    protected double lastInputSum;
    protected double lastOutput;

    public Neuron(int inputCount,int outputCount, ActivationInterface activation, InitializationInterface init) {
        this.weights = init.initializeWeights(inputCount, outputCount);
        this.bias = init.initializeBias();
        this.activation = activation;
    }
    public double feedForward(double[] inputs) {
        double sum = bias;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * inputs[i];
        }
        lastInputSum = sum;
        lastOutput = activation.activate(sum);
        return lastOutput;
    }
    public void updateWeights(double[] inputs, double delta, double learningRate) {
        for(int i = 0; i < weights.length; i++) {
            weights[i] -= learningRate * inputs[i] * delta;
        }
        bias -= learningRate * delta;
    }
    public double getLastInputSum() { return lastInputSum; }
    public double[] getWeights() { return weights.clone(); }
    public double getBias() { return bias; }
}
