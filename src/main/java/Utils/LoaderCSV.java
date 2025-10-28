package Utils;

import java.io.*;

public class LoaderCSV {

    public static double[][] loadCSV(String filePath) {
        double[][] data = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int rowCount = 0;

            while ((line = br.readLine()) != null) {
                rowCount++;
            }
            br.close();
            data = new double[rowCount][];

            BufferedReader br2 = new BufferedReader(new FileReader(filePath));
            br2.readLine();
            int index = 0;
            while ((line = br2.readLine()) != null) {
                String[] values = line.split(",");
                double[] sample = new double[values.length];
                sample[0] = Double.parseDouble(values[0]);

                for (int i = 1; i < values.length; i++) {
                    sample[i] = Double.parseDouble(values[i]) / 255.0; // normalize dataset MNIST
                }
                data[index++] = sample;
            }
            br2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}