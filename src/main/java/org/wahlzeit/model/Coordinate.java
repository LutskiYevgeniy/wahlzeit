package org.wahlzeit.model;

import java.util.Objects;

public interface Coordinate {

    public CartesianCoordinates asCartesianCoordinate();

    public double getCartesianDistance(Coordinate c);

    public SphericCoordinate asSphericCoordinate();

    public double getCentralAngle(Coordinate c);

    public boolean isEqual(Coordinate c);

}
