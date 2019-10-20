package mypackage;

import java.io.*;

public class Application {
    public static void main(String[] args) {
        Triangle selector = null;

        String inputFile = args[0];
        String outFile = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String newLine = line.trim().replaceAll("[^0-9|\\-]+"," ");
                String[] stringArray = newLine.split(" ");

                if (stringArray.length >= 6) {
                    double doubleArray[] = new double[stringArray.length];

                    for (int i = 0; i < 6; i++) {
                        doubleArray[i] = Double.valueOf(stringArray[i]);
                    }

                    Triangle triangle = new Triangle(new Point(doubleArray[0], doubleArray[1]), new Point(doubleArray[2], doubleArray[3]), new Point(doubleArray[4], doubleArray[5]));

                    if (triangle.isIsoscelesTriangle()) {
                        if (selector == null || triangle.isGreaterThan(selector)) {
                            selector = triangle;
                        }
                    }
                }
            }
        } catch (Exception e) {}

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8");
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("" + selector.toString());
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}