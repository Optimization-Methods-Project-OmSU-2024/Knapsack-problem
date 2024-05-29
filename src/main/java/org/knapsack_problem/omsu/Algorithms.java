package org.knapsack_problem.omsu;

import org.knapsack_problem.omsu.data_types.ValueAndQuantity;

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

}