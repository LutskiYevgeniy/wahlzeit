package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

    private double phi, theta, radius;

    public SphericCoordinate() {
    }

    //phi and theta are entered as rad
    private SphericCoordinate(double radius, double phi, double theta) {
        this.radius = radius;
        this.phi = phi;
        this.theta = theta;
        assertClassinvariants();
    }

    public SphericCoordinate(CartesianCoordinates c) {
        assertIsNonNullArgument(c);
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

    public static SphericCoordinate createNew( double r, double phi, double theta ){
        String Key = genKey(r, phi, theta);
        SphericCoordinate result = Spherical.get(Key);
        if(result == null){//Contains no such element
            result = new SphericCoordinate(r, phi, theta);
            Spherical.put(Key, result);
            return result;
        }else{
            return result;
        }
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        assertClassinvariants();
        this.phi = phi;
        assertClassinvariants();
    }

    public double getTheta() {
        return theta;
    }


    public double getRadius() {
        return radius;
    }

    @Override
    public CartesianCoordinates asCartesianCoordinate() {

        return new CartesianCoordinates(this);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    protected void assertClassinvariants() {
        assert getRadius() >= 0 &&
                getTheta() >= -1 &&
                getTheta() <= 1 &&
                getPhi() >= -1 &&
                getPhi() <= 1;
    }

    @Override
    protected double computeDistance(Coordinate c) {
        assertIsNonNullArgument(c);

        SphericCoordinate sc = c.asSphericCoordinate();
        double deltaPhi = Math.abs(getPhi() - sc.getPhi());
        double deltaTheta = Math.abs(getTheta() - sc.getTheta());

        return Math.acos(
                Math.sin(getPhi()) * Math.sin(sc.getPhi()) +
                Math.cos(getPhi()) * Math.cos(sc.getPhi()) * Math.cos(deltaPhi) );
    }

    @Override
    public boolean isEqual(Coordinate c) {
        assertIsNonNullArgument(c);

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
