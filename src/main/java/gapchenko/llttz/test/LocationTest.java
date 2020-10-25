package gapchenko.llttz.test;

import gapchenko.llttz.stores.Location;
import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.*;

public class LocationTest {

    @Test(expected = Exception.class)
    public void testLocation1() throws Exception{
        try {
            Location test = new Location(90, -180, null);
        } catch(Exception e) {
            throw new Exception("Error");
        }
    }

    @Test(expected = Exception.class)
    public void testLocation2() throws Exception{
        try {
            Location test = new Location(99, -189, null);
        } catch(Exception e) {
            throw new Exception("Error");
        }
    }

    @Test
    public void testLocation3() {
        double[] coordinates = {13.75, 100.51666};
        Location test = new Location(13.75, 100.51666, "Asia/Bangkok");
        assertNotNull(test);
        assertEquals(coordinates[0], test.getCoordinates()[0], 0.0001);
        assertEquals(coordinates[1], test.getCoordinates()[1], 0.0001);
        assertEquals("Asia/Bangkok", test.getZone());
    }
}
