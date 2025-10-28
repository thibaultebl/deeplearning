package deepneural;

import java.util.Random;

public class HeInitialization implements InitializationInterface {
    private static final Random rand = new Random();

    @Override
    public double[] initializeWeights(int inputCount, int outputCount) {
        double std = Math.sqrt(2.0 / inputCount);
        double[] weights = new double[inputCount];
        for (int i = 0; i < inputCount; i++) {
            weights[i] = rand.nextGaussian() * std;
        }
        return weights;
    }

    @Override
    public double initializeBias() {
        return 0.0;
    }
}
