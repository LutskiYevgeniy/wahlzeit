package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

    private double x, y ,z;

    public Coordinate(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double[] getCoordinates(){
        return (new double[]{this.x, this.y, this.z});
    }

    public void setCoordinates(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setZ(double z){
        this.z = z;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }

    public double getDistance(Coordinate coordinate){
        double distX = this.x - coordinate.x;
        double distY = this.y - coordinate.y;
        double distZ = this.z - coordinate.z;
        return Math.sqrt( (Math.pow(distX,2) + Math.pow(distY,2) + Math.pow(distZ,2) ) );
    }

    public boolean isEqual(Coordinate coordinate){
        return this.equals(coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.getX(), getX()) == 0 &&
                Double.compare(that.getY(), getY()) == 0 &&
                Double.compare(that.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }
}
