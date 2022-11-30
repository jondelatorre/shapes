package org.j4g.gc.shape.impl;

import org.j4g.gc.shape.base.Shape;

public class Triangle extends Shape {

    private final int base;
    private final int height;

    public Triangle(String id, int base, int height) {
        super(Triangle.class.getSimpleName(), id);
        this.base = base;
        this.height = height;
    }


    @Override
    protected double calculateArea() {
        return base * height / 2.0;
    }
}
