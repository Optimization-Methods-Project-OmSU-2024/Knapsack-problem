package org.knapsack_problem.omsu;

import org.knapsack_problem.omsu.data_types.OptimumAndSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {

        public static OptimumAndSets UnboundedKnapsackAlgorithm(int knapsackWeight, int[] weight, int[] value) {
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
                                                optimum[i] = value[j] + optimum[i - weight[j]];
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

}