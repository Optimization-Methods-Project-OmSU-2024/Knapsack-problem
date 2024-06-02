package org.knapsack_problem.omsu;

import org.knapsack_problem.omsu.data_types.OptimumAndSets;
import org.knapsack_problem.omsu.data_types.ValueAndQuantity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
    public static ValueAndQuantity[][] BooleanKnapsackAlgorithm(int knapsackWeight, int[] weight, double[] value) {
        try {
            if(weight.length != value.length) throw new IllegalArgumentException();

            //создаём таблицу
            ValueAndQuantity[][] res = new ValueAndQuantity[weight.length][knapsackWeight + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = new ValueAndQuantity[knapsackWeight + 1];
            }
            for (int i = 0; i < weight.length; i++) {
                for (int j = 0; j < knapsackWeight + 1; j++) {
                    res[i][j] = new ValueAndQuantity(0, 0);
                }
            }

            //заполняем
            //1 строчка
            for (int j = 0; j < knapsackWeight + 1; j++) {
                if (j < weight[0]) {
                    res[0][j].setValue(0);
                    res[0][j].setQuantity(0);
                }
                else {
                    res[0][j].setValue(value[0]);
                    res[0][j].setQuantity(1);
                }
            }
            //все остальные
            for (int i = 1; i < weight.length; i++) {
                for (int j = 0; j < knapsackWeight + 1; j++) {
                    if (j < weight[i]) {
                        res[i][j].setValue(res[i - 1][j].getValue());
                        res[i][j].setQuantity(0);
                    }
                    else {
                        res[i][j].setValue(Math.max(res[i - 1][j].getValue(), value[i] + res[i -1][j - weight[i]].getValue()));
                        res[i][j].setQuantity(1);
                    }
                }
            }
            return res;
        }catch (IllegalArgumentException e) {
            System.out.println("Weight and Value matrices should be of the same length");
            return null;
        }
    }

        public static OptimumAndSets UnboundedKnapsackAlgorithm(int knapsackWeight, int[] weight, double[] value) {
                if(weight == null || value == null) { throw new IllegalArgumentException("Table is null!"); }
                if(knapsackWeight < 0) { throw new IllegalArgumentException("Weight of the knapsack is negative!"); }
                if( !Arrays.stream(weight).allMatch( a -> a > 0)) { throw new IllegalArgumentException("Some weight is not positive!"); }
                if( !Arrays.stream(value).allMatch( a -> a > 0)) { throw new IllegalArgumentException("Some value is not positive!"); }

                int[] optimum = new int[knapsackWeight + 1];
                optimum[0] = 0;
                int[][] sets = new int[2][knapsackWeight + 1];
                sets[0][0] = -1;
                sets[1][0] = 0;

                for(int i = 1; i <= knapsackWeight; ++i) {
                        optimum[i] = 0;
                        sets[0][i] = -1;
                        sets[1][i] = 0;
                        for (int j = 0; j < weight.length; ++j) {
                                if (weight[j] <= i) {
                                        if (value[j] + optimum[i - weight[j]] >= optimum[i])
                                         {
                                                optimum[i] = (int) value[j] + optimum[i - weight[j]];
                                                sets[0][i] = j;
                                                sets[1][i] = i - weight[j];
                                        }
                                }
                        }
                }

                int[] setsResult = new int[weight.length];

                int maxIndex = knapsackWeight;
                while (maxIndex >= 0 && optimum[maxIndex-1] == optimum[knapsackWeight]){
                        maxIndex--;
                }

                int elem = sets[0][maxIndex];
                int pointer = sets[1][maxIndex];
                while (elem != -1) {
                        setsResult[elem]++;
                        elem = sets[0][pointer];
                        pointer = sets[1][pointer];
                }

                return new OptimumAndSets(optimum[knapsackWeight], setsResult);
        }
  
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