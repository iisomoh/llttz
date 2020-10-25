package gapchenko.llttz;

import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimeZone;

/**
 * @author artemgapchenko
 * Created on 18.04.14.
 */
public class OurConverter implements gapchenko.llttz.IConverter {
    private TimeZoneStore tzStore;
    private static OurConverter instance = null;

    public OurConverter(Class clazz) {
        if (!TimeZoneStore.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Illegal store provided: " + clazz.getName());
        }
        try {
            tzStore = (TimeZoneStore) clazz.newInstance();
            loadData();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static OurConverter getInstance(final Class clazz) {
        if (instance == null || !instance.getStoreClass().equals(clazz)) instance = new OurConverter(clazz);
        return instance;
    }

    public Class getStoreClass() {
        return tzStore.getClass();
    }

    public TimeZoneStore getTzStore() {
        return this.tzStore;
    }

    @Override
    public TimeZone getTimeZone(final double lat, final double lon) {
        return tzStore.nearestTimeZone(new Location(new double[]{lat, lon}));
    }

    private void loadData() {
        // FAULT HERE
        BufferedReader br = new BufferedReader(
                new InputStreamReader(Converter.class.getResourceAsStream("/missing_timezones.csv"))
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
    }
}