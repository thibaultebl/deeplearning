package deepneural;

public interface LayerInterface {

    double[] forward(double[] input);
    void backward(double[] deltas, double learningRate);
    Neuron[] getNeurons();
}
