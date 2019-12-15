package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CartesianCoordinates extends AbstractCoordinate {

    private double x, y, z;


    public CartesianCoordinates() {
        x = 0;
        y = 0;
        z = 0;

    }

    private CartesianCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public static CartesianCoordinates createNew( double x, double y, double z ){
        String Key = genKey(x,y,z);
        CartesianCoordinates result = Cartesians.get(Key);
        if(result == null){//Contains no such element
            result = new CartesianCoordinates(x,y,z);
            Cartesians.put(Key, result);
            return result;
        }else{
            return result;
        }
    }

    public CartesianCoordinates(SphericCoordinate c) {

        assertIsNonNullArgument(c);

        x = c.getRadius() * Math.sin(c.getTheta()) * Math.cos(c.getPhi());
        y = c.getRadius() * Math.sin(c.getTheta()) * Math.sin(c.getPhi());
        z = c.getRadius() * Math.cos(c.getTheta());
        String Key = genKey(x,y,z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public CartesianCoordinates asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return new SphericCoordinate(this);
    }

    @Override
    protected void assertClassinvariants() {
        //No restriction here sofar
    }

    @Override
    protected double computeDistance(Coordinate c) {
        assertIsNonNullArgument(c);

        CartesianCoordinates cc = c.asCartesianCoordinate();
        double distX = this.x - cc.x;
        double distY = this.y - cc.y;
        double distZ = this.z - cc.z;



        return Math.sqrt( (Math.pow(distX,2) + Math.pow(distY,2) + Math.pow(distZ,2) ) );
    }

    @Override
    public boolean isEqual(Coordinate c) {
        CartesianCoordinates cc = c.asCartesianCoordinate();
        return Math.abs(cc.getX() - getX()) < 0.0001 &&
                Math.abs(cc.getY() - getY()) < 0.0001 &&
                Math.abs(cc.getZ() - getZ()) < 0.0001;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartesianCoordinates)) return false;
        CartesianCoordinates that = (CartesianCoordinates) o;
        return isEqual(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }
}
