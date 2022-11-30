package org.j4g.gc.shape.impl;

import org.j4g.gc.shape.base.Shape;

public class Circle extends Shape {

    private final double radius;

    public Circle(String id, int radius) {
        super(Circle.class.getSimpleName(), id);
        this.radius = radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * radius * radius;
    }
}
