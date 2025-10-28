package deepneural;


public class OutputLayer extends Layer {
    private final SoftMax softmax = new SoftMax();

    public OutputLayer(int neuronCount, int inputCount, InitializationInterface init) {
        super(neuronCount, inputCount, 0, null, init); // no activation needed for neurons
    }
    public double[] computeOutputDeltas(double[] predicted, double[] target) {
        double[] deltas = new double[predicted.length];
        for (int i = 0; i < predicted.length; i++) {
            deltas[i] = (predicted[i] - target[i]); // softmax + cross-entropy
        }
        return deltas;
    }
    @Override
    public double[] forward(double[] inputs) {
        this.lastInputs = inputs.clone();
        double[] sums = new double[neurons.length];
        for (int i = 0; i < neurons.length; i++) {
            sums[i] = neurons[i].getBias();
            double[] weights = neurons[i].getWeights();
            for (int j = 0; j < weights.length; j++) sums[i] += weights[j] * inputs[j];
            neurons[i].lastInputSum = sums[i];
        }
        double[] output = softmax.activate(sums);

        for (int i = 0; i < neurons.length; i++) neurons[i].lastOutput = output[i];

        return output;
    }
    @Override
    public void backward(double[] deltas, double learningRate){}
}
