package org.knapsack_problem.omsu;

import org.junit.jupiter.api.Test;
import org.knapsack_problem.omsu.data_types.ValueAndQuantity;
import org.knapsack_problem.omsu.data_types.OptimumAndSets;
import static org.junit.jupiter.api.Assertions.*;

class RestorationTest {

    @Test
    void SolutionRestorationForBooleanMethodTest() {
        int[] weight = {1, 4, 3};
        double[] value = {1500, 3000, 2000};
        ValueAndQuantity[][] res = Algorithms.BooleanKnapsackAlgorithm(4, weight, value);

        assertEquals(
                new OptimumAndSets(3500, new int[]{1, 0, 1}),
                SolutionRestoration.SolutionRestorationForBooleanMethod(res, weight);
                );
    }

    @Test
    void SolutionRestorationForGeneralMethodTest() {
        int[] weight = {3, 4, 5};
        ValueAndQuantity[][] res = Algorithms.GeneralKnapsackAlgorithm(11, weight,
                new double[]{5, 9, 13, 17},
                new double[]{-1, 5, 11},
                new double[]{2, 5, 14}))););

        assertEquals(
                new OptimumAndSets(22, new int[]{1, 2, 0}),
                SolutionRestoration.SolutionRestorationForGeneralMethod(res, weight);
    )
    }
}