import deepneural.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<LayerInterface> layers = List.of(
                new HiddenLayer(512, 784, 256, new LeakyRelu(), new HeInitialization()),// hidden layer
                new HiddenLayer(256, 512, 128, new LeakyRelu(), new HeInitialization()),
                new HiddenLayer(128, 256, 64, new LeakyRelu(), new HeInitialization()),
                new HiddenLayer(64, 128, 10, new LeakyRelu(), new HeInitialization()),
                new OutputLayer(10, 64, new XavierInitialization())   // output layer, change the activation function regarding the output expected.
        );
        NeuralNetwork nn = new NeuralNetwork(layers);

    }
}
