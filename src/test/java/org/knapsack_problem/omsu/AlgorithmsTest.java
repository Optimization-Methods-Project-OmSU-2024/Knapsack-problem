package org.knapsack_problem.omsu;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    @org.junit.jupiter.api.Test
    void generalKnapsackAlgorithm() {
        System.out.println(Arrays.deepToString(Algorithms.generalKnapsackAlgorithm(11, new int[]{3, 4, 5},
                new double[]{5, 9, 13, 17},
                new double[]{-1, 5, 11},
                new double[]{2, 5, 14})));
    }
}