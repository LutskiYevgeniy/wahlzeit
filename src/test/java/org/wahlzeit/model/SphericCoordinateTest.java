package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;


public class SphericCoordinateTest extends TestCase {

    @Test
    public void testEqual(){
        SphericCoordinate pointA = SphericCoordinate.createNew(5,0.5,0.3);
        SphericCoordinate pointATwice = SphericCoordinate.createNew(5,0.5,0.3);
        CartesianCoordinates pointACartesian = pointA.asCartesianCoordinate();


        assertTrue(pointA.isEqual(pointATwice));
        assertTrue( pointA.isEqual(pointACartesian));
    }

    @Test
    public void testValueObj(){
        SphericCoordinate pointA =  SphericCoordinate.createNew(5,0.5,0.3);
        SphericCoordinate poaintATwice = SphericCoordinate.createNew(5,0.5,0.3);

        assertEquals( 1, SphericCoordinate.Spherical.size() );
    }

    @Test
    public void testDistanceToCartesian(){
        CartesianCoordinates pointA =  CartesianCoordinates.createNew(1,0,0);
        CartesianCoordinates pointB =  CartesianCoordinates.createNew(6,0,0);
        SphericCoordinate pointASpheric = pointA.asSphericCoordinate();

        double distance = pointASpheric.getCartesianDistance(pointB);

        assertEquals(5.0, distance, 0.0001 );
    }

    @Test
    public void testDistance(){
        SphericCoordinate pointA = SphericCoordinate.createNew(1,0.15,0.3);
        SphericCoordinate pointB = SphericCoordinate.createNew(2,0.15,0.3);

        double ret = pointA.getCartesianDistance(pointB);

        assertEquals( 1.0 , ret, 0.0001);
    }

    @Test
    public void testNullArgument(){
        SphericCoordinate pointA = SphericCoordinate.createNew(1,0,0);
        try{
            double ret = pointA.getCentralAngle(null);
        } catch(NullPointerException e){
            return;
        }
        fail();
    }
}
