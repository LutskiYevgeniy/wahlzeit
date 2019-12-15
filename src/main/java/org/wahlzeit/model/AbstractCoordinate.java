package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCoordinate implements Coordinate {

    public static Map<String, CartesianCoordinates> Cartesians = new HashMap<String,CartesianCoordinates>();
    public static Map<String, SphericCoordinate> Spherical = new HashMap<String, SphericCoordinate>();

    public static String genKey(double value1, double value2, double value3){
        return ( Double.toString(value1) + "," + Double.toString(value2) + "," +Double.toString(value3) );
    }

    public double getCartesianDistance(Coordinate c) throws NullPointerException{
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

    public double getCentralAngle(Coordinate c) throws NullPointerException{

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

    protected abstract double computeDistance(Coordinate c) throws NullPointerException;
}
