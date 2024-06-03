package org.knapsack_problem.omsu.data_types;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OptimumAndSets {
    private double optimum;
    private int[] sets;

    public OptimumAndSets(double optimum, int[] sets) {
        this.optimum = optimum;
        this.sets = sets;
    }

    public double getOptimum() {
        return optimum;
    }

    public void setOptimum(double optimum) {
        this.optimum = optimum;
    }

    public int[] getSets() {
        return sets;
    }

    public void setSets(int[] sets) {
        this.sets = sets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptimumAndSets that = (OptimumAndSets) o;
        return Double.compare(getOptimum(), that.getOptimum()) == 0 && Arrays.equals(getSets(), that.getSets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOptimum(), Arrays.hashCode(getSets()));
    }
}
