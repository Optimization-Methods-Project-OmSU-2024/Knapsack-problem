package org.knapsack_problem.omsu;

import org.knapsack_problem.omsu.data_types.ValueAndQuantity;

public class Algorithms {
    public static ValueAndQuantity[][] generalKnapsackAlgorithm(int knapsackWeight, int[] weights, double[] ... values) {
        try {
            if(weights.length != values.length) throw new IllegalArgumentException();

            ValueAndQuantity[][] res = new ValueAndQuantity[weights.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new ValueAndQuantity[knapsackWeight + 1];
            }
            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j < knapsackWeight + 1; j++) {
                    res[i][j] = new ValueAndQuantity(0, 0);
                }
            }

            for (int j = 0; j < knapsackWeight + 1; j++) {
                int curCapacity = (int)Math.floor((double) j /weights[0]);
                res[0][j].setValue(values[0][curCapacity]);
                res[0][j].setQuantity(curCapacity);
            }

            for (int i = 1; i < weights.length; i++) {
                for (int j = 0; j < knapsackWeight + 1; j++) {
                    int curCapacity = (int)Math.floor((double) j / weights[i]);
                    double maxValue = Double.NEGATIVE_INFINITY;
                    int maxQuantity = (int)Double.NEGATIVE_INFINITY;
                    for (int k = 0; k <= curCapacity; k++) {
                        double curValue = values[i][k] + res[i - 1][j - k * weights[i]].getValue();
                        if (curValue > maxValue) {
                            maxValue = curValue;
                            maxQuantity = k;
                        }
                    }
                    res[i][j].setValue(maxValue);
                    res[i][j].setQuantity(maxQuantity);
                }
            }
            return res;
        } catch (IllegalArgumentException e) {
            System.out.println("Weight and Value matrices should be of the same length");
            return null;
        }
    }

}