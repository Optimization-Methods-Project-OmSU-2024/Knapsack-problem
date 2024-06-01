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

    public void setKnapsackWeight(int knapsackWeight) {
        this.knapsackWeight = knapsackWeight;
    }

    public int[] getWeights() {
        return weights;
    }

    public void setWeights(int[] weights) {
        this.weights = weights;
    }

    public double[][] getValues() {
        return values;
    }

    public void setValues(double[][] values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GeneralKnapsack that = (GeneralKnapsack) object;
        return knapsackWeight == that.knapsackWeight && Arrays.equals(weights, that.weights) && Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(knapsackWeight);
        result = 31 * result + Arrays.hashCode(weights);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public String toString() {
        return "GeneralKnapsack{" +
                "knapsackWeight=" + knapsackWeight +
                ", weights=" + Arrays.toString(weights) +
                ", values=" + Arrays.toString(values) +
                '}';
    }

}
