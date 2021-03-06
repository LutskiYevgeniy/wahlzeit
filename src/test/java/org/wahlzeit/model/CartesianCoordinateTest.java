package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Assert.*;
import org.junit.Test;


public class CartesianCoordinateTest extends TestCase {

    @Test
    public void testEqual(){
        CartesianCoordinates pointA =  CartesianCoordinates.createNew(1,2,3);
        CartesianCoordinates poaintATwice = CartesianCoordinates.createNew(1,2,3);
        SphericCoordinate sc = pointA.asSphericCoordinate();

        assertTrue(pointA.isEqual(poaintATwice));
        assertTrue(pointA.isEqual(sc));
    }

    @Test
    public void testValueObj(){
        CartesianCoordinates pointA =  CartesianCoordinates.createNew(1,2,3);
        CartesianCoordinates poaintATwice = CartesianCoordinates.createNew(1,2,3);

        assertEquals( 1, CartesianCoordinates.Cartesians.size() );
    }

    @Test
    public void testDistance(){
        CartesianCoordinates pointA = CartesianCoordinates.createNew(1,0,0);
        CartesianCoordinates pointB = CartesianCoordinates.createNew(6,0,0);


        double distance = pointA.getCartesianDistance(pointB);

        assertEquals(5.0, distance, 0.0001 );
    }

    @Test
    public void testDistanceToSpheric(){
        CartesianCoordinates pointA = CartesianCoordinates.createNew(1,0,0);
        CartesianCoordinates pointB = CartesianCoordinates.createNew(6,0,0);
        SphericCoordinate pointASpheric = pointB.asSphericCoordinate();

        double ret = pointA.getCartesianDistance(pointASpheric);

        assertEquals( 5.0 , ret, 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArgument(){
        CartesianCoordinates pointA = CartesianCoordinates.createNew(1,0,0);
     try{
         double ret = pointA.getCartesianDistance(null);
     } catch(NullPointerException e){
         return;
     }
        fail();
    }

}
