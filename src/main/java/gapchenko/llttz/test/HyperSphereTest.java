package gapchenko.llttz.test;

import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneStore;
import gapchenko.llttz.stores.TimeZoneTreeStore;
import org.junit.Test;

import static org.junit.Assert.*;

public class HyperSphereTest {
    @Test
    public void testHyperSphere1() {
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        Location loc2 = new Location(new double[] {13.731967,100.3565472});
        double result = TimeZoneStore.centralAngle2(loc1.getLatitude(), loc1.getLongitude(), loc2.getLatitude(), loc2.getLongitude());
        boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(13.7946584, 13.731967, result);
        assertTrue(bool);
    }

    @Test(expected = Exception.class)
    public void testHyperSphere2() throws Exception{
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        Location loc2 = new Location(new double[] {13.731967,100.3565472});
        double result = TimeZoneStore.centralAngle2(loc1.getLatitude(), loc1.getLongitude(), loc2.getLatitude(), loc2.getLongitude());
        try {
            boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(13.7946584, 1, result);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    public void testHyperSphere3() {
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        Location loc2 = new Location(new double[] {13.7946584,100.2883976});
        double result = TimeZoneStore.centralAngle2(loc1.getLatitude(), loc1.getLongitude(), loc2.getLatitude(), loc2.getLongitude());
        boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(13.7946584, 13.7946584, result);
        assertFalse(bool);
    }

    @Test
    public void testHyperSphere4() {
        Location loc2 = new Location(new double[] {13.7946584,100.2883976});
        Location loc1 = new Location(new double[] {13.731967,100.3565472});
        double result = TimeZoneStore.centralAngle2(loc1.getLatitude(), loc1.getLongitude(), loc2.getLatitude(), loc2.getLongitude());
        boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(13.731967, 13.7946584, result);
        assertTrue(bool);
    }

    @Test(expected = Exception.class)
    public void testHyperSphere5() throws Exception{
        try {
            boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(15, 13.731967, 0.091);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void testHyperSphere6() throws Exception{
        try {
            boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(15, 13, 0.091);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void testHyperSphere7() throws Exception{
        try {
            boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(15, 15.00000, 0.091);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void testHyperSphere8() throws Exception{
        try {
            boolean bool = TimeZoneStore.hypersphereAndHyperplaneIntersection2(13, 13.7946584, 0.091);
        } catch (Exception e) {
            throw e;
        }
    }
}
