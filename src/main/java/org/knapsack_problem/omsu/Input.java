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
            int knapsackWeight = scanner.nextInt();
            scanner.nextLine();
            String[] weightString = scanner.nextLine().split(" ");
            String[] valueString = scanner.nextLine().split(" ");
            System.out.println(Arrays.toString(weightString));
            System.out.println(Arrays.toString(valueString));
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
            double[][] arr = new double[2][numberOfValues];
            Random rand = new Random();
            writer.write(rand.nextInt() + "\n");

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < numberOfValues; j++) {
                    arr[i][j] = (double) Math.round((rand.nextDouble() * 100) * 10) / 10;
                    writer.write(arr[i][j] + " ");
                }
                writer.write('\n');
            }
            writer.write('\n');
            writer.close();
            return FileInputBoolAndUnbounded();
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            return null;
        }
    }

    public static GeneralKnapsack FileInputNonlinear() {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));
            int knapsackWeight = scanner.nextInt();
            scanner.nextLine();

            String[] stringData = scanner.nextLine().split(" ");
            int[] weights = new int[stringData.length];
            for (int i = 0; i < stringData.length; i++) {
                weights[i] = Integer.parseInt(stringData[i]);
            }
            List<double[]> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                stringData = scanner.nextLine().split(" ");
                double[] doubleData = new double[stringData.length];
                for (int i = 0; i < stringData.length; i++) {
                    doubleData[i] = Double.parseDouble(stringData[i]);
                }
                list.add(doubleData);
            }
            scanner.close();

            double[][] values = new double[list.size()][weights.length];
            for(int i = 0; i < list.size(); ++i) {
                values[i] = Arrays.copyOfRange(list.get(i), 0, weights.length);
            }
            return new GeneralKnapsack(knapsackWeight, weights, values);

        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
            return null;
        }
    }

    public static GeneralKnapsack RandomInputNonlinear(int numberOfValues) {
        try (FileWriter writer = new FileWriter("input.txt")) {
            Random rand = new Random();
            writer.write(rand.nextInt() + "\n");
            for (int i = 0; i < numberOfValues+1; i++) {
                int size = rand.nextInt(20) + 1;
                if (i == 0) size = numberOfValues;
                double[] arr = new double[size];
                for (int j = 0; j < arr.length; j++){
                    arr[j] = (double) Math.round((rand.nextDouble() * 100) * 10) / 10;
                    writer.write(arr[j] + " ");
                }
                writer.write('\n');
            }
            writer.write('\n');
            writer.close();
            return FileInputNonlinear();
        } catch (IOException e) {
            System.out.println("File doesn't exist");
            return null;
        }
    }

}
