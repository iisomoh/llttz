package gapchenko.llttz.test;

import gapchenko.llttz.Converter;
import gapchenko.llttz.IConverter;
import gapchenko.llttz.stores.SomeStore;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneTestStore;
import gapchenko.llttz.stores.TimeZoneTreeStore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConverterTest {

    @Test
    public void testConverter7() {
        IConverter iconv = Converter.getInstance(TimeZoneListStore.class);
        assertNotNull(iconv);
    }

    @Test
    public void testConverter8() {
        IConverter iconv = Converter.getInstance(TimeZoneTreeStore.class);
        assertNotNull(iconv);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConverter9() throws IllegalArgumentException {
        try {
            IConverter iconv = Converter.getInstance(SomeStore.class);
            assertNotNull(iconv);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
