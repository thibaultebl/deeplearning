package Utils;

public class DataSet {
    private final double[] features;
    private final double[] labels;

    public DataSet(double[] features, double[] labels) {
        this.features = features.clone();
        this.labels = labels.clone();
    }
    public double[] getFeatures() {
        return features.clone();
    }
    public double[] getLabels() {
        return labels.clone();
    }
}
