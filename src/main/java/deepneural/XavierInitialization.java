package deepneural;

import java.util.Random;

public class XavierInitialization implements InitializationInterface {
    private static final Random rand = new Random();

    @Override
    public double[] initializeWeights(int inputCount, int outputCount) {
        double limit = Math.sqrt(6.0 / (inputCount + outputCount));
        double[] weights = new double[inputCount];
        for (int i = 0; i < inputCount; i++) {
            weights[i] = rand.nextDouble() * 2 * limit - limit;
        }
        return weights;
    }
    @Override
    public double initializeBias() {
        return 0.0;
    }
}
