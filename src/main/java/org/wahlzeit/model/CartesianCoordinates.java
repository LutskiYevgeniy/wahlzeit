package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinates extends AbstractCoordinate {

    private double x, y, z;

    public CartesianCoordinates() {
        x = 0;
        y = 0;
        z = 0;
    }
    public CartesianCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CartesianCoordinates(SphericCoordinate c) {
        x = c.getRadius() * Math.sin(c.getTheta()) * Math.cos(c.getPhi());
        y = c.getRadius() * Math.sin(c.getTheta()) * Math.sin(c.getPhi());
        z = c.getRadius() * Math.cos(c.getTheta());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public CartesianCoordinates asCartesianCoordinate() {
        return this;
    }
/*
    @Override
    public double getCartesianDistance(Coordinate c) {
        CartesianCoordinates cc = c.asCartesianCoordinate();
        double distX = this.x - cc.x;
        double distY = this.y - cc.y;
        double distZ = this.z - cc.z;
        return Math.sqrt( (Math.pow(distX,2) + Math.pow(distY,2) + Math.pow(distZ,2) ) );
    }
*/
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return new SphericCoordinate(this);
    }
/*
    @Override
    public double getCentralAngle(Coordinate c) {
        SphericCoordinate sc = c.asSphericCoordinate();
        SphericCoordinate me = this.asSphericCoordinate();
        return me.getCentralAngle(sc);
    }
*/
    @Override
    protected double computeDistance(Coordinate c) {
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
