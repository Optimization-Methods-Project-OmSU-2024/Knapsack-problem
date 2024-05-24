package org.knapsack_problem.omsu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Input {
    public static double[][] FileInputBoolAndUnbounded() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));
            String[] weightString = scanner.nextLine().split(" ");
            String[] valueString = scanner.nextLine().split(" ");
            if (weightString.length != valueString.length) throw new ArrayIndexOutOfBoundsException();
            double[] weight = new double[weightString.length];
            double[] value = new double[valueString.length];
            double[][] arrays = new double[2][valueString.length];
            for (int i = 0; i < weightString.length; i++) {
                weight[i] = Double.parseDouble(weightString[i]);
                value[i] = Double.parseDouble(valueString[i]);
                arrays[0][i] = weight[i];
                arrays[1][i] = value[i];
            }
            scanner.close();
            return arrays;
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The weights string does not match the values string.");
            return null;
        }
    }

    public static double[][] RandomInputBoolAndUnbounded(int numberOfValues) {
        try (FileWriter writer = new FileWriter("input.txt")) {
            double[][] arr = new double[2][numberOfValues];
            Random rand = new Random();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < numberOfValues; j++) {
                    arr[i][j] = (double) Math.round((rand.nextDouble() * 100) * 10) / 10;
                    writer.write(arr[i][j] + " ");
                }
            }
            writer.write('\n');
            writer.close();
            return arr;
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            return new double[0][0];
        }
    }

    public static List<double[]> FileInputNonlinear() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));
            List<double[]> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] stringData = scanner.nextLine().split(" ");
                double[] doubleData = new double[stringData.length];
                for (int i = 0; i < stringData.length; i++) {
                    doubleData[i] = Double.parseDouble(stringData[i]);
                }
                list.add(doubleData);
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            return null;
        }
    }

    public static List<double[]> RandomInputNonlinear(int numberOfValues) {
        try (FileWriter writer = new FileWriter("input.txt")) {
            List<double[]> list = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < numberOfValues+1; i++) {
                int size = rand.nextInt(20) + 1;
                if (i == 0) size = numberOfValues;
                double[] arr = new double[size];
                for (int j = 0; j < arr.length; j++){
                    arr[j] = (double) Math.round((rand.nextDouble() * 100) * 10) / 10;
                    writer.write(arr[j] + " ");
                }
            list.add(arr);
            }
            writer.write('\n');
            writer.close();
            return list;
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            return null;
        }
    }

}
