import Utils.DataSet;
import Utils.DataSplit;
import Utils.LoaderCSV;
import deepneural.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double[][] dataset2 = LoaderCSV.loadCSV("src/main/resources/mnist_train.csv");

        DataSplit split = new DataSplit(dataset2, 0.1);
        DataSet[] training = split.getTrainingSet();
        DataSet[] testing = split.getTestSet();

        List<LayerInterface> layers = List.of(
                new HiddenLayer(512, 784, 256, new LeakyRelu(), new HeInitialization()),// hidden layer
                new HiddenLayer(256, 512, 128, new LeakyRelu(), new HeInitialization()),
                new HiddenLayer(128, 256, 64, new LeakyRelu(), new HeInitialization()),
                new HiddenLayer(64, 128, 10, new LeakyRelu(), new HeInitialization()),
                new OutputLayer(10, 64, new XavierInitialization())   // output layer, change the activation function regarding the output expected.
        );
        NeuralNetwork nn = new NeuralNetwork(layers);
        System.out.println("trainingSet length: " + training.length);
        nn.train(training, 10);


        for (int i = 0; i <= 20; i++) {
            double[] output = nn.forward(training[i].getFeatures());
            int predictedIndex = 0;
            double maxProb = output[0];
            for (int j = 0; j < output.length; j++) {
                if (output[j] > maxProb) {
                    maxProb = output[j];
                    predictedIndex = j;
                }
            }
            System.out.println("Training sample " + i + " predicted as: " + predictedIndex);
        }


    }
}
