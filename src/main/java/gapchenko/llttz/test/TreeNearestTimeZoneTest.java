package gapchenko.llttz.test;

import gapchenko.llttz.Converter;
import gapchenko.llttz.IConverter;
import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneTreeStore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TreeNearestTimeZoneTest {
    @Test
    public void testTreeNearestTimeZone() {
        TimeZoneTreeStore tzStore = new TimeZoneTreeStore();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(Converter.class.getResourceAsStream("/timezones.csv"))
        );

        try {
            String line;
            String[] location;

            while ((line = br.readLine()) != null) {
                location = line.split(";");
                tzStore.insert(new Location(Double.valueOf(location[1]), Double.valueOf(location[2]), location[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Location loc1 = new Location(new double[] {13.7946584,100.2883976});
        assertEquals("Asia/Bangkok", tzStore.nearestTimeZone(loc1).getID());
    }

}
