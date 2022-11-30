package org.j4g.gc;

import org.j4g.gc.shape.base.MultiThreadShapeCalculator;

import java.util.Scanner;

public class Main {

    private final static String PARSE_INT_ERROR_MESSAGE = "Both 1st and 2nd parameters must be positive integer numbers";

    public static void main(String[] args) {
        System.out.println("Start JMC and input any character");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        if (args.length < 2){
            throw new IllegalArgumentException("At least 2 parameters are required when calling this program, " +
                    "the first is the number of objects and the second is the number of threads");
        }
        int numberOfObjects;
        int numberOfThreads;
        try {
            numberOfObjects = Integer.parseInt(args[0]);
            numberOfThreads = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(PARSE_INT_ERROR_MESSAGE);
        }

        if(numberOfObjects < 1 || numberOfThreads < 1){
            throw new IllegalArgumentException(PARSE_INT_ERROR_MESSAGE);
        }

        MultiThreadShapeCalculator calc = new MultiThreadShapeCalculator(numberOfThreads, numberOfObjects);
        try {
            calc.process();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of Main");
        System.out.println("Input any character to finish");
        scanner.nextLine();
    }


}