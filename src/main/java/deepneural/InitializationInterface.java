package deepneural;

public interface InitializationInterface {
    double[] initializeWeights(int inputCount, int outputCount);
    double initializeBias();
}
