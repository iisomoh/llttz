package gapchenko.llttz.stores;

import java.util.TimeZone;

public class TimeZoneTestStore extends TimeZoneStore{

    @Override
    public void insert(Location loc) {
        return;
    }

    @Override
    public TimeZone nearestTimeZone(Location node) {
        return null;
    }
}
