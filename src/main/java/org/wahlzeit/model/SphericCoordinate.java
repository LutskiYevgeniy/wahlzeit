package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private double phi, theta, radius;

    public SphericCoordinate() {
    }

    //phi and theta are entered as rad
    public SphericCoordinate(double radius, double phi, double theta) {
        this.radius = radius;
        this.phi = phi;
        this.theta = theta;
    }

    public SphericCoordinate(CartesianCoordinates c) {
        // x,y,z == 0 ?
        if(c.getX() == 0 && c.getY() == 0 && c.getZ() == 0){
            radius = 0;
            phi = 0;
            theta = 0;
            return;
        }
        radius = Math.sqrt( (Math.pow(c.getX(),2) + Math.pow(c.getY(),2) + Math.pow(c.getZ(),2) ) );
        phi = Math.atan2(c.getY() , c.getX());
        theta = Math.acos(c.getZ() / radius);
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public CartesianCoordinates asCartesianCoordinate() {
        return new CartesianCoordinates(this);
    }
/*
    @Override
    public double getCartesianDistance(Coordinate c) {
        CartesianCoordinates cc = c.asCartesianCoordinate();
        CartesianCoordinates me = this.asCartesianCoordinate();
        return me.getCartesianDistance(cc);
    }
*/
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }
/*
    @Override
    public double getCentralAngle(Coordinate c) {
        SphericCoordinate sc = c.asSphericCoordinate();
        double deltaPhi = Math.abs(getPhi() - sc.getPhi());
        double deltaTheta = Math.abs(getTheta() - sc.getTheta());

        return Math.acos(Math.sin(getPhi()) * Math.sin(sc.getPhi()) + Math.cos(getPhi()) * Math.cos(sc.getPhi()) * Math.cos(deltaPhi));
    }
*/
    @Override
    protected double computeDistance(Coordinate c) {
        SphericCoordinate sc = c.asSphericCoordinate();
        double deltaPhi = Math.abs(getPhi() - sc.getPhi());
        double deltaTheta = Math.abs(getTheta() - sc.getTheta());

        return Math.acos(Math.sin(getPhi()) * Math.sin(sc.getPhi()) + Math.cos(getPhi()) * Math.cos(sc.getPhi()) * Math.cos(deltaPhi));
    }

    @Override
    public boolean isEqual(Coordinate c) {
        SphericCoordinate cc = c.asSphericCoordinate();
        return Math.abs(cc.getPhi() - getPhi()) < 0.0001 &&
                Math.abs(cc.getTheta() - getTheta()) < 0.0001 &&
                Math.abs(cc.getRadius() - getRadius()) < 0.0001;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SphericCoordinate)) return false;
        SphericCoordinate that = (SphericCoordinate) o;
      return isEqual(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhi(), getTheta(), getRadius());
    }
}
