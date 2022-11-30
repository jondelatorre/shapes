package org.j4g.gc.shape.base;

import java.util.Objects;

public abstract class Shape {

    private final String name;
    private final String id;
    private Double area;

    public Shape(String name, String id) {
        this.name = new String(name);
        this.id = id;
    }

    public double getArea(){
        if(area == null) {
            area = calculateArea();
        }
        return area;
    }

    protected abstract double calculateArea();

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", area=" + area +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return name.equals(shape.name) && id.equals(shape.id) && area.equals(shape.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, area);
    }
}
