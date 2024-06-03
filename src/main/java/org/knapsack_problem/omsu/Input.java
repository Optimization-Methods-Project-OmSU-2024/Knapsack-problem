package org.knapsack_problem.omsu;

import org.knapsack_problem.omsu.knapsacks.BooleanKnapsack;
import org.knapsack_problem.omsu.knapsacks.GeneralKnapsack;
import org.knapsack_problem.omsu.knapsacks.UnboundedKnapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Input {
    public static BooleanKnapsack FileInputBoolAndUnbounded() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));
            int knapsackWeight = Integer.parseInt(scanner.nextLine());
            String[] weightString = scanner.nextLine().split(" ");
            String[] valueString = scanner.nextLine().split(" ");
            if (weightString.length != valueString.length) throw new ArrayIndexOutOfBoundsException();
            int[] weight = new int[weightString.length];
            double[] value = new double[valueString.length];
            for (int i = 0; i < weightString.length; i++) {
                weight[i] = Integer.parseInt(weightString[i]);
                value[i] = Double.parseDouble(valueString[i]);
            }
            scanner.close();
            return new BooleanKnapsack(knapsackWeight, weight, value);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The weights string does not match the values string.");
            return null;
        }
    }


    public static BooleanKnapsack RandomInputBoolAndUnbounded(int numberOfValues) {
        try (FileWriter writer = new FileWriter("input.txt")) {
            int[] weight = new int[numberOfValues];
            double[] value = new double[numberOfValues];
            Random rand = new Random();

            int knapsackWeight = rand.nextInt(100) + 1;
            writer.write(knapsackWeight + "\n");
            
            for (int j = 0; j < numberOfValues; j++) {
                weight[j] = rand.nextInt(50) + 1;
                
                writer.write(weight[j] + " ");
            }
            writer.write("\n");
            for (int j = 0; j < numberOfValues; j++) {
                value[j] = (double) Math.round((rand.nextDouble() * 100) * 10) / 10;
                writer.write(value[j] + " ");
            }
            writer.close();
            return new BooleanKnapsack(knapsackWeight, weight, value);
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            return null;
        }
    }

    public static GeneralKnapsack FileInputNonlinear() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));
            int knapsackWeight = Integer.parseInt(scanner.nextLine());
          
            List<double[]> list = new ArrayList<>();
            String[] stringData = scanner.nextLine().split(" ");
            int[] weight = new int[stringData.length];
            for (int i = 0; i < stringData.length; i++) {
                weight[i] = Integer.parseInt(stringData[i]);
            }
            while (scanner.hasNextLine()) {
                stringData = scanner.nextLine().split(" ");
                double[] doubleData = new double[stringData.length];
                for (int i = 0; i < stringData.length; i++) {
                    doubleData[i] = Double.parseDouble(stringData[i]);
                }
                list.add(doubleData);
            }
            scanner.close();

            int maxLength = list.stream().mapToInt(arr -> arr.length).max().orElse(0);
            double[][] value = new double[list.size()][maxLength];

            for (int i = 0; i < list.size(); i++) {
                double[] arr = list.get(i);
                System.arraycopy(arr, 0, value[i], 0, arr.length);
            }

            if (value.length != weight.length) throw new ArrayIndexOutOfBoundsException();
            return new GeneralKnapsack(knapsackWeight, weight, value);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The weights string does not match the values string.");
            return null;
        }
    }

    public static GeneralKnapsack RandomInputNonlinear(int numberOfValues) {
        try (FileWriter writer = new FileWriter("input.txt")) {
            Random rand = new Random();

            int knapsackWeight = rand.nextInt(100) + 1;
            writer.write(knapsackWeight+"\n");
            int[] weight = new int[numberOfValues];
            for (int i = 0; i < numberOfValues; i++) {
                weight[i] = rand.nextInt(50) + 1;
                writer.write(weight[i]+" ");
            }
            writer.write("\n");
            for (int i = 0; i < numberOfValues; i++) {
                int size = rand.nextInt(10) + 1;
                if (i == 0) size = numberOfValues;
                double[] arr = new double[size];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = (double) Math.round((rand.nextDouble() * 100) * 10) / 10;
                    writer.write(arr[j] + " ");
                }

                writer.write("\n");
                list.add(arr);
            }
            writer.write('\n');
            writer.close();

            int maxLength = list.stream().mapToInt(arr -> arr.length).max().orElse(0);
            double[][] value = new double[list.size()][maxLength];

            for (int i = 0; i < list.size(); i++) {
                double[] arr = list.get(i);
                System.arraycopy(arr, 0, value[i], 0, arr.length);
            }

            return new GeneralKnapsack(knapsackWeight, weight, value);
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            return null;
        }
    }

}
