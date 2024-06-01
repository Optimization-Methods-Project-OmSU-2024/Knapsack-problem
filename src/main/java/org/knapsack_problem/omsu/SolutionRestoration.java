package org.knapsack_problem.omsu;

import org.knapsack_problem.omsu.data_types.OptimumAndSets;
import org.knapsack_problem.omsu.data_types.ValueAndQuantity;

public class SolutionRestoration {
    public static OptimumAndSets SolutionRestorationForBooleanMethod(ValueAndQuantity[][] arr, int[] weight){
        try{
            if(arr == null) {throw new IllegalArgumentException("Algorithm for boolean method had some problems");}

            double optimum = arr[arr.length - 1][arr[0].length - 1].getValue();
            int[] sets = new int[arr.length];

            int j = arr[0].length - 1;
            for(int i = arr.length - 1; i>=0; i--){
                if(j<0){
                    sets[i] = 0;
                }
                else{
                    sets[i] = arr[i][j].getQuantity();
                    j = j - arr[i][j].getQuantity() * weight[i];
                }
            }

            return new OptimumAndSets(optimum,sets);
        }
        catch (IllegalArgumentException e){
            System.out.println("Algorithm for boolean method had some problems");
            return null;
        }
    }

    public static OptimumAndSets SolutionRestorationForGeneralMethod(ValueAndQuantity[][] arr, double[] ... values){
        try{
            if(arr == null) {throw new IllegalArgumentException("Algorithm for general method had some problems");}

            double optimum = arr[arr.length - 1][arr[0].length - 1].getValue();
            int[] sets = new int[arr.length];

            int j = arr[0].length - 1;
            for(int i = arr.length - 1; i>=0; i--){
                if(j<0){
                    sets[i] = 0;
                }
                else{
                    sets[i] = arr[i][j].getQuantity();
                    j = j - values[i][arr[i][j].getQuantity()];
                }
            }

            return new OptimumAndSets(optimum,sets);
        }
        catch (IllegalArgumentException e){
            System.out.println("Algorithm for general method had some problems");
            return null;
        }
    }
}
