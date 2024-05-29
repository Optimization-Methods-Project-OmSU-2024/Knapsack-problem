package org.knapsack_problem.omsu;

import org.junit.jupiter.api.Test;
import org.knapsack_problem.omsu.data_types.ValueAndQuantity;
import static org.junit.jupiter.api.Assertions.*;
class AlgorithmsTest {
    @Test
    void BooleanKnapsackAlgorithmTest(){
        int[] weight = {1, 4, 3};
        double[] value = {1500, 3000, 2000};
        ValueAndQuantity[][] res = Algorithms.BooleanKnapsackAlgorithm(4, weight, value);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(res[i][j].getValue() + "\t");
            }
            System.out.println();
        }
        assertEquals(3500, res[2][4].getValue());
    }

}