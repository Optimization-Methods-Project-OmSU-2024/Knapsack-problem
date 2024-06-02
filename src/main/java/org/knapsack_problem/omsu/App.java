package org.knapsack_problem.omsu;

import org.knapsack_problem.omsu.data_types.OptimumAndSets;
import org.knapsack_problem.omsu.knapsacks.BooleanKnapsack;
import org.knapsack_problem.omsu.knapsacks.GeneralKnapsack;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Knapsack Problem Solver!");
        int appMode = -1;
        Scanner sc = new Scanner(System.in);
        boolean correctInput = false;
        while (appMode != 0) {
            appMode = -1;
            while (!(correctInput) || !(appMode == 1 || appMode == 2 || appMode == 0)) {
                System.out.println();
                System.out.println("1 - start program");
                System.out.println("2 - open Input.txt");
                System.out.println("0 - exit");
                System.out.print("Select a mode: ");
                if (sc.hasNextInt()) {
                    appMode = sc.nextInt();
                    correctInput = true;
                } else {
                    sc.nextLine();
                }
            }
            File file = new File("Input.txt");
            if (!file.exists()) { file.createNewFile(); }
            switch (appMode) {
                case 1:
                    int problemType = 0;
                    int inputMode = 0;
                    BooleanKnapsack booleanKnapsack = null;
                    GeneralKnapsack generalKnapsack = null;
                    OptimumAndSets solution = null;
                    System.out.println();
                    correctInput = false;
                    while (!(correctInput) || !(problemType == 1 || problemType == 2 || problemType == 3)) {
                        System.out.print("What problem are we solving? (1 - Boolean, 2 - Unbounded, 3 - General): ");
                        if (sc.hasNextInt()) {
                            problemType = sc.nextInt();
                            correctInput = true;
                        } else {
                            sc.nextLine();
                        }
                    }
                    System.out.println();
                    correctInput = false;
                    while (!(correctInput) || !(inputMode == 1 || inputMode == 2)) {
                        System.out.println("How to input Knapsack? (1 - manually, 2 - randomly): ");
                        if (sc.hasNextInt()) {
                            inputMode = sc.nextInt();
                            correctInput = true;
                        } else {
                            sc.nextLine();
                        }
                    }

                        if (inputMode == 1) {
                            file.setWritable(true);
                            java.awt.Desktop.getDesktop().edit(file);
                            System.out.print("Confirm your input by pressing Enter key...");
                            System.in.read();
                            if (problemType == 1 || problemType == 2) {
                                booleanKnapsack = Input.FileInputBoolAndUnbounded();
                            } else {
                                generalKnapsack = Input.FileInputNonlinear();
                            }
                        } else {
                            correctInput = false;
                            if (problemType == 1 || problemType == 2) {
                                while (!(correctInput)) {
                                    System.out.print("How many items there are? : ");
                                    if (sc.hasNextInt()) {
                                        file.setWritable(true);
                                        booleanKnapsack = Input.RandomInputBoolAndUnbounded(sc.nextInt());
                                        correctInput = true;
                                        file.setWritable(false);
                                        java.awt.Desktop.getDesktop().open(file);
                                    } else {
                                        sc.nextLine();
                                    }
                                }
                            } else {
                                while (!(correctInput)) {
                                    System.out.print("How many value rows are there in the knapsack? : ");
                                    if (sc.hasNextInt()) {
                                        file.setWritable(true);
                                        generalKnapsack = Input.RandomInputNonlinear(sc.nextInt());
                                        correctInput = true;
                                        file.setWritable(false);
                                        java.awt.Desktop.getDesktop().open(file);
                                    } else {
                                        sc.nextLine();
                                    }
                                }
                            }
                        }
                        System.out.println("Processing...");
                    try {
                        solution = switch (problemType) {
                            case 1 -> SolutionRestoration.SolutionRestorationForBooleanMethod(
                                    Algorithms.BooleanKnapsackAlgorithm(booleanKnapsack.getKnapsackWeight(), booleanKnapsack.getWeights(), booleanKnapsack.getValues()),
                                    booleanKnapsack.getWeights()
                            );
                            case 2 ->  Algorithms.UnboundedKnapsackAlgorithm(booleanKnapsack.getKnapsackWeight(), booleanKnapsack.getWeights(), booleanKnapsack.getValues());
                            case 3 -> SolutionRestoration.SolutionRestorationForGeneralMethod(
                                    Algorithms.generalKnapsackAlgorithm(generalKnapsack.getKnapsackWeight(), generalKnapsack.getWeights(), generalKnapsack.getValues()), generalKnapsack.getWeights()
                            );
                            default -> throw new IllegalStateException("Unexpected value: " + problemType);
                        };
                        System.out.println("Optimal Value: " + solution.getOptimum() + ", Set: " + Arrays.toString(solution.getSets()));
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    file.setWritable(true);
                    java.awt.Desktop.getDesktop().open(file);
                    break;
            }
        }
        exit(0);
    }
}
