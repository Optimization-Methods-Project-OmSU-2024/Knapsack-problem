package org.knapsack_problem.omsu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.knapsack_problem.omsu.data_types.OptimumAndSets;

class AlgorithmsTest {

    @Test
    void unboundedKnapsackAlgorithm() {
        int[] weight = {4, 5, 9};
        int[] value = {5, 6, 12};

        assertEquals(
                new OptimumAndSets(12, new int[]{0, 0, 1}),
                Algorithms.UnboundedKnapsackAlgorithm(10, weight, value));
    }

    @Test
    void unboundedKnapsackAlgorithm2() {
        int[] weight = {2, 3, 4, 5, 6, 7};
        int[] value = {3, 5, 9, 11, 12, 15};

        assertEquals(
                new OptimumAndSets(767, new int[]{0, 0, 84, 1, 0, 0}),
                Algorithms.UnboundedKnapsackAlgorithm(341, weight, value));
    }

    @Test
    void unboundedKnapsackAlgorithm3() {
        int[] weight = {2,2,2};
        int[] value = {2,2,2};

        assertEquals(
                new OptimumAndSets(44, new int[]{0, 0, 22}),
                Algorithms.UnboundedKnapsackAlgorithm(45, weight, value));
    }
}