package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;


public class SphericCoordinateTest extends TestCase {

    @Test
    public void testEqual(){
        SphericCoordinate pointA = new SphericCoordinate(5,0.5,0.3);
        SphericCoordinate pointATwice = new SphericCoordinate(5,0.5,0.3);
        CartesianCoordinates pointACartesian = pointA.asCartesianCoordinate();


        assertTrue(pointA.isEqual(pointATwice));
        assertTrue( pointA.isEqual(pointACartesian));
    }

    @Test
    public void testDistanceToCartesian(){
        CartesianCoordinates pointA = new CartesianCoordinates(1,0,0);
        CartesianCoordinates pointB = new CartesianCoordinates(6,0,0);
        SphericCoordinate pointASpheric = pointA.asSphericCoordinate();

        double distance = pointASpheric.getCartesianDistance(pointB);

        assertEquals(5.0, distance, 0.0001 );
    }

    @Test
    public void testDistance(){
        SphericCoordinate pointA = new SphericCoordinate(1,0.15,0.3);
        SphericCoordinate pointB = new SphericCoordinate(2,0.15,0.3);

        double ret = pointA.getCartesianDistance(pointB);

        assertEquals( 1.0 , ret, 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArgument(){
        SphericCoordinate pointA = new SphericCoordinate(1,0,0);
        try{
            double ret = pointA.getCentralAngle(null);
        } catch(NullPointerException e){
            return;
        }
        fail();
    }
}
