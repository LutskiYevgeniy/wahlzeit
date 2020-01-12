package org.wahlzeit.model;

@interface DesignPattern {
    String name();
}

@DesignPattern(name = "State")
public interface Coordinate {

    public CartesianCoordinates asCartesianCoordinate();

    public double getCartesianDistance(Coordinate c) throws NullPointerException;

    public SphericCoordinate asSphericCoordinate();

    public double getCentralAngle(Coordinate c) throws NullPointerException;

    public boolean isEqual(Coordinate c) throws NullPointerException;

}
