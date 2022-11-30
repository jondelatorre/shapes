package org.j4g.gc.shape.base;

import org.j4g.gc.shape.impl.Circle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultiThreadShapeCalculator {

    private final static double PERCENTAGE = 5;
    private final int numberOfThreads;
    private final int numberOfElementsPerThread;
    private final int initialSizeForLongLivedElements;
    private final Set<Shape> longLivedShapes;
    private final int elementsToSkip;

    public MultiThreadShapeCalculator(int numberOfThreads, int numberOfElementsPerThread) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfElementsPerThread = numberOfElementsPerThread;
        this.elementsToSkip = (int) (numberOfElementsPerThread * (PERCENTAGE / 100));
        this.initialSizeForLongLivedElements = numberOfThreads * elementsToSkip * 5; // 5 is the number of classes implementing Shape
        longLivedShapes = ConcurrentHashMap.newKeySet(initialSizeForLongLivedElements);
    }

    public void process() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Set<Shape>>> futures = new ArrayList<>();
        for(int i = 0; i < numberOfThreads; i++){
            System.out.println("Starting Object creation for Thread " + i);
            final int finalI = i;
            Future<Set<Shape>> result = executorService.submit(() -> {
                final Set<Shape> threadShortLiveShapes = new HashSet<>();
                final Set<Shape> threadLongLiveShapes = new HashSet<>();
                    for(int j=0; j<= numberOfElementsPerThread; j++){
                        Set<Shape> randomShapes = RandomShapeGenerator.getAllShapes(finalI + "-" + j);
                        if((j % (elementsToSkip + 1)) == 0){
                            threadLongLiveShapes.addAll(randomShapes);
                        }
                        else{
                            threadShortLiveShapes.addAll(randomShapes);
                        }
                    }
                    Thread.sleep(1000);
                return threadLongLiveShapes;
            });
            futures.add(result);
        }
        futures.forEach(f-> {
            try {
                longLivedShapes.addAll(f.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("Processing finished");
        executorService.shutdown();
    }
}
