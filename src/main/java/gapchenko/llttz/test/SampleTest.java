package gapchenko.llttz.test;

import gapchenko.llttz.Converter;
import gapchenko.llttz.IConverter;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneTreeStore;
import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class SampleTest {

    /*
    TEST FOR getTimeZone()
     */
    @Test
    public void testGetTimeZone() {
        IConverter iconv = Converter.getInstance(TimeZoneTreeStore.class);
        TimeZone tz = iconv.getTimeZone(128, 190);
        assertEquals("Asia/Bangkok", tz.getID());

    }

    @Test
    public void testGetTimeZone2() {
        IConverter iconv = Converter.getInstance(TimeZoneListStore.class);
        TimeZone tz = iconv.getTimeZone(128, 190);
        assertEquals("Asia/Bangkok", tz.getID());

    }
}
