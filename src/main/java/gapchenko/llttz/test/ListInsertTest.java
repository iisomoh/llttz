package gapchenko.llttz.test;

import gapchenko.llttz.stores.Location;
import gapchenko.llttz.stores.TimeZoneListStore;
import gapchenko.llttz.stores.TimeZoneStore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ListInsertTest {
    @Test
    public void testListInsert1() {
        TimeZoneListStore tzStore = new TimeZoneListStore();
        Location loc1 = new Location(5.31666, -4.03334, "Africa/Abidjan");
        Location loc2 = new Location(5.31666, -4.03334, "Africa/Abidjan");
        tzStore.insert(loc1);
        tzStore.insert(loc2);
        fail("Should throw duplicate error");
    }

    @Test
    public void testListInsert2() {
        TimeZoneListStore tzStore = new TimeZoneListStore();
        Location loc1 = new Location(5.31666, -4.03334, "Africa/Abidjan");
        tzStore.insert(loc1);
        assertEquals(1, tzStore.getListSize());
    }
}
