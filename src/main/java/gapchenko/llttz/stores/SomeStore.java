package gapchenko.llttz.stores;

import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public class SomeStore {
    private List<Location> timeZones = new LinkedList<>();

    public void insert(Location loc) {
        timeZones.add(loc);
    }

}
