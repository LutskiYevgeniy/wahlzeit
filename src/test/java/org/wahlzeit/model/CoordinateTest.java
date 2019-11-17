package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Test;

public class CoordinateTest extends TestCase {


    @Test
    public void testgetCartesianDistance(){
        CartesianCoordinates cc = new CartesianCoordinates(0,0,0);
        CartesianCoordinates cc2 = new CartesianCoordinates(5,0,0);

        double ret = cc.getCartesianDistance(cc2);

        assertEquals( Double.toString(ret),5.0 , ret);
    }

    @Test
    public void isEqualTest(){
        CartesianCoordinates cc = new CartesianCoordinates(1,2,3);
        SphericCoordinate sc = cc.asSphericCoordinate();

        assertTrue(cc.isEqual(sc));
    }

    @Test
    public void testDualSphericGetCartesianDist(){
        CartesianCoordinates cc = new CartesianCoordinates(1,0,0);
        CartesianCoordinates cc2 = new CartesianCoordinates(6,0,0);
        SphericCoordinate sc = cc.asSphericCoordinate();
        SphericCoordinate sc2 = cc2.asSphericCoordinate();

        double ret = sc.getCartesianDistance(sc2);

        assertEquals( 5.0 , ret);
    }
    @Test

    public void testSphericCartesianGetCartesianDist(){
        CartesianCoordinates cc = new CartesianCoordinates(1,0,0);
        CartesianCoordinates cc2 = new CartesianCoordinates(6,0,0);
        SphericCoordinate sc = cc.asSphericCoordinate();

        double ret = sc.getCartesianDistance(cc2);

        assertEquals( 5.0 , ret);
    }
}
