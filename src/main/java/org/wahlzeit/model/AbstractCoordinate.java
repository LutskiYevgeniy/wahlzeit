package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

    public double getCartesianDistance(Coordinate c) {
        assertIsNonNullArgument(c);

        if(this instanceof CartesianCoordinates){
            CartesianCoordinates cc = c.asCartesianCoordinate();
            return computeDistance(cc);
        }else if( this instanceof SphericCoordinate ){
            CartesianCoordinates cc1 = this.asCartesianCoordinate();
            CartesianCoordinates cc2 = c.asCartesianCoordinate();
            return cc1.computeDistance(cc2);
        }else{
            throw new IllegalArgumentException();
        }
    }

    protected void assertIsNonNullArgument(Coordinate c){
        if(c == null)
            throw new NullPointerException();
    }

    public double getCentralAngle(Coordinate c) {

        assertIsNonNullArgument(c);

        if(this instanceof SphericCoordinate){
            SphericCoordinate cc = c.asSphericCoordinate();
            return computeDistance(cc);
        }else if( this instanceof CartesianCoordinates ){
            SphericCoordinate cc1 = this.asSphericCoordinate();
            SphericCoordinate cc2 = c.asSphericCoordinate();
            return cc1.computeDistance(cc2);
        }else{
            throw new IllegalArgumentException();
        }
    }

    protected abstract void assertClassinvariants();

    protected abstract double computeDistance(Coordinate c);
}
