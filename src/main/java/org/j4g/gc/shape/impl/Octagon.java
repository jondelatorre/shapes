package org.j4g.gc.shape.impl;

import org.j4g.gc.shape.base.Shape;

public class Octagon extends Shape {

    private final int side;

    public Octagon(String id, int side) {
        super(Octagon.class.getSimpleName(), id);
        this.side = side;
    }


    @Override
    protected double calculateArea() {
        return 2 * Math.pow(side, 2) * (1 + Math.sqrt(2)) ;
    }
}
