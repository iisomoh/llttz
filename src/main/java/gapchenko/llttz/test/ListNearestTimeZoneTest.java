package gapchenko.llttz.test;

import gapchenko.llttz.Converter;
import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneTreeStore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class ListNearestTimeZoneTest {

    @Test(expected = Exception.class)
    public void testListNearestTimeZone2() throws Exception {
        TimeZoneListStore tzStore = new TimeZoneListStore();
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
        Location loc1 = null;
        try {
            tzStore.nearestTimeZone(loc1).getID();
        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    public void testListNearestTimeZone3() {
        TimeZoneListStore tzStore = new TimeZoneListStore();
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
        Location loc1 = new Location(new double[] {5.299845231256514, -4.035228277364237});
        assertEquals("Africa/Abidjan", tzStore.nearestTimeZone(loc1).getID());
    }

    @Test
    public void testListNearestTimeZone4() {
        TimeZoneListStore tzStore = new TimeZoneListStore();
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
