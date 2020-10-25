package gapchenko.llttz.test;


import gapchenko.llttz.Converter;
import gapchenko.llttz.IConverter;
import gapchenko.llttz.OurConverter;
import gapchenko.llttz.stores.SomeStore;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneStore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

import static org.junit.Assert.*;

public class LoadDataTest {

    /**
     * TEST CASE 10 for loadData()
     * @throws IllegalArgumentException
     */

    // Case T1(file is exists, data is loaded into variable TzStore
    @Test(expected = IllegalArgumentException.class)
    public void testLoadData1() throws IllegalArgumentException {
        try {
            gapchenko.llttz.IConverter iconv = Converter.getInstance(SomeStore.class);
            Converter conv = (Converter) iconv;
            TimeZoneStore resource = conv.getTzStore();
            assertNotNull(resource);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    // Case T2(file is exist, data is not loaded into variable TzStore (may be file is empty?)
    @Test
    public void testLoadData2() {
        IConverter iconv = Converter.getInstance(TimeZoneListStore.class);
        Converter conv = (Converter) iconv;
        TimeZoneListStore resource = (TimeZoneListStore) conv.getTzStore();
        resource.getList().clear(); //assume that data does not loaded
        assertEquals(0,resource.getListSize());
    }

    // Case T4(file is not exist, and data is not loaded into variable TzStore
    @Test(expected = IllegalArgumentException.class)
    public void testLoadData4() {
        gapchenko.llttz.IConverter iconv = OurConverter.getInstance(SomeStore.class);
        OurConverter conv = (OurConverter) iconv;
        TimeZoneStore resource = conv.getTzStore();
        assertNotNull(resource);
    }
}
