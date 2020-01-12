package org.wahlzeit.model;

@interface DesignPattern {
    String name();
    String[] participants();
}

@DesignPattern(name = "State", participants = {"CartesianCoordinates", "SphericCoordinate", "Coordinate"})
public interface Coordinate {

    public CartesianCoordinates asCartesianCoordinate();

    public double getCartesianDistance(Coordinate c) throws NullPointerException;

    public SphericCoordinate asSphericCoordinate();

    public double getCentralAngle(Coordinate c) throws NullPointerException;

    public boolean isEqual(Coordinate c) throws NullPointerException;

}
