package gapchenko.llttz.test;

import gapchenko.llttz.Converter;
import gapchenko.llttz.IConverter;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneTreeStore;
import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SampleTest {

    /*
    TEST FOR getTimeZone()
     */
    @Test
    public void testGetTimeZone() {
        IConverter iconv = Converter.getInstance(TimeZoneListStore.class);
        TimeZone tz = iconv.getTimeZone(15.33333, 38.88333);
        assertEquals("Africa/Asmara", tz.getID());

        try {
            TimeZone tz2 = iconv.getTimeZone(61.21805000000000000000, -149.90028000000000000000);
            fail("This method should thrown an exception due to not double input!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
