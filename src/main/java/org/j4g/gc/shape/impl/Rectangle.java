package org.j4g.gc.shape.impl;

import org.j4g.gc.shape.base.Shape;

public class Rectangle extends Shape {

    private final int side1;
    private final int side2;

    public Rectangle(String id, int side1, int side2) {
        super(Rectangle.class.getSimpleName(), id);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    protected double calculateArea() {
        return side1 * side2;
    }
}
