package org.j4g.gc.shape.base;

import org.j4g.gc.shape.impl.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomShapeGenerator {

    public static Set<Shape> getAllShapes(String  id){
        final int number1 = ThreadLocalRandom.current().nextInt(1,100);
        final int number2 = ThreadLocalRandom.current().nextInt(1,100);
        return  Stream.of(
                    new Circle(id, number1),
                    new Square(id, number2),
                    new Rectangle(id, number1, number2),
                    new Triangle(id, number1, number2),
                    new Octagon(id, number1)
                ).collect(Collectors.toCollection(HashSet::new));
    }

}
