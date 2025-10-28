package Utils;


public class DataSplit {
    private DataSet[] trainingSet;
    private DataSet[] testSet;

    public DataSplit(double[][] dataset, double trainRatio) {
        int trainingSize = (int) (dataset.length * trainRatio);
        int testingSize = dataset.length - trainingSize;
        double[][] trainingMatrix = new double[trainingSize][dataset[0].length];
        double[][] testMatrix = new double[testingSize][dataset[0].length];
        System.arraycopy(dataset, 0, trainingMatrix, 0, trainingSize);
        System.arraycopy(dataset, trainingSize, testMatrix, 0, testingSize);

        trainingSet = convertIntoHandable(trainingMatrix);
        testSet = convertIntoHandable(testMatrix);
    }
    private DataSet[] convertIntoHandable(double[][] MatrixSet) {
        DataSet[] set = new DataSet[MatrixSet.length];
        for (int i = 0; i < MatrixSet.length; i++) {
            int label = (int) MatrixSet[i][0];
            double[] inputs = new double[MatrixSet[i].length - 1];
            System.arraycopy(MatrixSet[i], 1, inputs, 0, MatrixSet[i].length - 1);
            double[] output = oneHot(label, 10);
            set[i] = new DataSet(inputs, output);
        }
        return set;
    }
    public DataSet[] getTrainingSet() {
        return trainingSet;
    }
    public DataSet[] getTestSet() {
        return testSet;
    }
    public double[] oneHot(int label, int numClasses) {
        double[] target = new double[numClasses];
        target[label] = 1.0;
        return target;
    }
}
