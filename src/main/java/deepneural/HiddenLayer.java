package deepneural;

import java.util.Arrays;

public class HiddenLayer extends Layer {

    public HiddenLayer(int neuronCount, int inputCount, int outputCount, ActivationInterface activation, InitializationInterface init) {
        super(neuronCount, inputCount, outputCount, activation, init);
    }
    @Override
    public double[] forward(double[] inputs) {
        lastInputs = inputs.clone();
        return Arrays.stream(neurons)
                .mapToDouble(n -> n.feedForward(inputs))
                .toArray();
    }
    @Override
    public void backward(double[] deltas, double learningRate) {
        for (int j = 0; j < neurons.length; j++) {
            neurons[j].updateWeights(lastInputs, deltas[j], learningRate);
        }
    }

}
