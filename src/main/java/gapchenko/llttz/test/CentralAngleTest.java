package gapchenko.llttz.test;

import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CentralAngleTest {
    @Test
    public void testCentralAngle1() {
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        Location loc2 = new Location(new double[] {13.7946584,100.2883976});
        double result = TimeZoneStore.centralAngle2(loc1.getLatitude(), loc1.getLongitude(), loc2.getLatitude(), loc2.getLongitude());
        assertEquals(0, result, 0.1);
    }

    @Test(expected = Exception.class)
    public void testCentralAngle2() throws Exception {
        Double emp = null;
        try {
            double result = TimeZoneStore.centralAngle2(emp, emp, emp, emp);
        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    public void testCentralAngle3() {
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        Location loc2 = new Location(new double[] {13.731967,100.3565472});
        double result = TimeZoneStore.centralAngle2(loc1.getLatitude(), loc1.getLongitude(), loc2.getLatitude(), loc2.getLongitude());
        assertEquals(0.091, result, 0.01);
    }
}
