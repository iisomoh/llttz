package gapchenko.llttz.test;

import gapchenko.llttz.Converter;
import gapchenko.llttz.IConverter;
import gapchenko.llttz.stores.TimeZoneListStore;
import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetTimeZoneTest {

    private IConverter iconv = Converter.getInstance(TimeZoneListStore.class);

    @Test
    public void testGetTimeZone1() {
        TimeZone tz = iconv.getTimeZone(15.33333, 38.88333);
        assertEquals("Africa/Asmara", tz.getID());
    }

    @Test(expected = Exception.class)
    public void testGetTimeZone2() throws Exception {
        Double empty = null;
        try {
            TimeZone tz = iconv.getTimeZone(empty, empty);
        } catch (Exception e) {
            throw new Exception("Error");
        }
    }

    @Test(expected = Exception.class)
    public void testGetTimeZone3() throws Exception {
        try {
            TimeZone tz = iconv.getTimeZone(-68.58334, 15);
        } catch (Exception e) {
            throw new Exception("Error");
        }
    }

    @Test(expected = Exception.class)
    public void testGetTimeZone4() throws Exception {
        try {
            TimeZone tz = iconv.getTimeZone(-9, 16.21547);
        } catch (Exception e) {
            throw new Exception("Error");
        }
    }
}
