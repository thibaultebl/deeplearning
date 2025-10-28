package deepneural;

import java.util.List;

public class NeuralNetwork {
    private List<LayerInterface> layers;
    private double learningRate;

    public NeuralNetwork(List<LayerInterface> layers) {
        this.layers = layers;
        this.learningRate = 0.001;
    }
    public double[] forward(double[] input) {
        double[] output = input.clone();
        for(LayerInterface layer : layers){
            output = layer.forward(output);
        }
        return output;
    }
    public void backward(double[] predicted, double[] target) {
        double[] nextDeltas = null;
        for(int l = layers.size() - 1; l >= 0; l--){
            LayerInterface current = layers.get(l);
            double[] deltas;
            if(current instanceof OutputLayer outputLayer){
                deltas = outputLayer.computeOutputDeltas(predicted, target);
            } else
            {
                LayerInterface next = layers.get(l + 1);
                deltas = new double[current.getNeurons().length];
                for (int i = 0; i < current.getNeurons().length; i++) {
                    double errorSum = 0;
                    for (int j = 0; j < next.getNeurons().length; j++) {
                        errorSum += next.getNeurons()[j].getWeights()[i] * nextDeltas[j];
                    }
                    deltas[i] = errorSum *
                            current.getNeurons()[i].activation.derivative(current.getNeurons()[i].getLastInputSum());
                }
            }
            current.backward(deltas, learningRate);
            nextDeltas = deltas;
        }
    }
    public void train(DataSet[] trainingSet, int iterations) {

        for(int i = 0; i < iterations; i++){
            System.out.println("Starting training iteration " + i);
            for(DataSet trainingSetData : trainingSet){
                double[] predicted = forward(trainingSetData.getFeatures());
                backward(predicted, trainingSetData.getLabels());
            }

        }
    }
}
