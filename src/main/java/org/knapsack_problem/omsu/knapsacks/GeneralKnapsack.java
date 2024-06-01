package org.knapsack_problem.omsu.knapsacks;

import java.util.Arrays;
import java.util.Objects;

public class GeneralKnapsack {
    private int knapsackWeight;
    private int[] weights;
    private double[][] values;

    public GeneralKnapsack(int knapsackWeight, int[] weights, double[][] values) {
        this.knapsackWeight = knapsackWeight;
        this.weights = weights;
        this.values = values;
    }

    public int getKnapsackWeight() {
        return knapsackWeight;
    }

    public int[] getWeights() {
        return weights;
    }

    public double[][] getValues() {
        return values;
    }

    public void setKnapsackWeight(int knapsackWeight) {
        this.knapsackWeight = knapsackWeight;
    }

    public void setWeights(int[] weights) {
        this.weights = weights;
    }

    public void setValues(double[][] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Knapsack Weight: ").append(knapsackWeight).append("\n");
        sb.append("Weights: ").append(Arrays.toString(weights)).append("\nValues:");
        for (int i = 0; i < values.length; i++) {
            sb.append("\n");
            sb.append(Arrays.toString(values[i]));
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralKnapsack that = (GeneralKnapsack) o;
        return knapsackWeight == that.knapsackWeight && Arrays.equals(weights, that.weights) && Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(knapsackWeight);
        result = 31 * result + Arrays.hashCode(weights);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
