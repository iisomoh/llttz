package gapchenko.llttz.test;

import gapchenko.llttz.Converter;
import gapchenko.llttz.IConverter;
import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DistanceInKmTest {
    @Test
    public void testDistanceInKm1() {
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        Location loc2 = new Location(new double[] {13.731967,100.3565472});
        double result = TimeZoneStore.distanceInKilometers2(loc1, loc2);
        assertEquals(10.14, result, 0.1);
    }

    @Test(expected = Exception.class)
    public void testDistanceInKm2() {
        Location loc1 = null;
        Location loc2 = null;
        try {
            double result = TimeZoneStore.distanceInKilometers2(loc1, loc2);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void testDistanceInKm3() {
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        Location loc2 = null;
        try {
            double result = TimeZoneStore.distanceInKilometers2(loc1, loc2);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void testDistanceInKm4() {
        Location loc1 = null;
        Location loc2 = new Location(new double[] {13.731967,100.3565472});
        try {
            double result = TimeZoneStore.distanceInKilometers2(loc1, loc2);
        } catch (Exception e) {
            throw e;
        }
    }
}
