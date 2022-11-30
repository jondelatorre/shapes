package org.j4g.gc.shape.impl;

import org.j4g.gc.shape.base.Shape;

public class Square extends Shape {

    private final int side;

    public Square(String id, int side) {
        super(Square.class.getSimpleName(), id);
        this.side = side;
    }

    @Override
    protected double calculateArea() {
        return side * side;
    }
}
