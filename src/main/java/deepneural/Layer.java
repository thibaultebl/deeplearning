package deepneural;

public abstract class Layer implements LayerInterface {
    protected final Neuron[] neurons;
    protected double[] lastInputs;

    public Layer(int neuronCount, int inputCount, int outputCount, ActivationInterface activation, InitializationInterface init) {
        neurons = new Neuron[neuronCount];
        for (int i = 0; i < neuronCount; i++) {
            neurons[i] = new Neuron(inputCount, outputCount, activation, init);
        }
    }
    @Override
    public abstract double[] forward(double[] inputs);
    @Override
    public abstract void backward(double[] deltas, double learningRate);
    @Override
    public Neuron[] getNeurons() {return neurons;}

}
