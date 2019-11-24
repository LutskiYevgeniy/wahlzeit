package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

    public double getCartesianDistance(Coordinate c) {
        if(this instanceof CartesianCoordinates){
            CartesianCoordinates cc = c.asCartesianCoordinate();
            return computeDistance(cc);
        }else if( this instanceof SphericCoordinate ){
            CartesianCoordinates cc1 = this.asCartesianCoordinate();
            CartesianCoordinates cc2 = c.asCartesianCoordinate();
            return cc1.computeDistance(cc2);
        }else{
            //
        }
        return 0;
    }

    public double getCentralAngle(Coordinate c) {
        if(this instanceof SphericCoordinate){
            SphericCoordinate cc = c.asSphericCoordinate();
            return computeDistance(cc);
        }else if( this instanceof CartesianCoordinates ){
            SphericCoordinate cc1 = this.asSphericCoordinate();
            SphericCoordinate cc2 = c.asSphericCoordinate();
            return cc1.computeDistance(cc2);
        }else{
            //
        }
        return 0;
    }

    protected abstract double computeDistance(Coordinate c);
}
