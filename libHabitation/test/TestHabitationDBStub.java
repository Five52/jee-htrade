package test;

import static org.junit.Assert.*;
import org.junit.Test;

import habitations.*;

public class TestHabitationDBStub {

    @Test
    public void testInsertApartment() {
       HabitationDBStub h = new HabitationDBStub();
       h.insert(13, new Apartment(75, 4, Country.FRANCE, "4 Avenue Charles de Gaulle"));
       assertEquals(13, h.getAll().size());
    }

    @Test
    public void testInsertHouse() {
       HabitationDBStub h = new HabitationDBStub();
       h.insert(13, new House(140, 6, 60, Country.FRANCE, "4 Rue du 6 Juin"));
       assertEquals(13, h.getAll().size());
    }

    @Test
    public void testGet() {
        HabitationDBStub h = new HabitationDBStub();
        Habitation hab = h.get(11);
        assertEquals(84, hab.getSurface());
        assertEquals(7, hab.getNbRooms());
        assertEquals(Country.UNITED_KINGDOM, hab.getCountry());
        assertEquals("76 Blvd Of Broken Dreams", hab.getAddress());
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetFail() {
        HabitationDBStub h = new HabitationDBStub();
        h.get(65);
    }
    
    @Test
    public void testGetAll() {
        HabitationDBStub h = new HabitationDBStub();
        assertEquals(12, h.getAll().size());
    }

    @Test
    public void testUpdate() {
        HabitationDBStub h = new HabitationDBStub();
        h.update(12, new Apartment(50, 3, Country.SWITZERLAND, "92 Rue du Chocolatier"));
        assertEquals(50, h.get(12).getSurface());
        assertEquals(3, h.get(12).getNbRooms());
        assertEquals("92 Rue du Chocolatier", h.get(12).getAddress());
    }

    @Test (expected=IllegalArgumentException.class)
    public void testUpdateFail() {
        HabitationDBStub h = new HabitationDBStub();
        h.update(48, new Apartment(99, 6, Country.SWITZERLAND, "92 Avenue du Chocolatier"));
    }

    @Test
    public void testDelete() {
        HabitationDBStub h = new HabitationDBStub();
        h.delete(11);
        assertEquals(11, h.getAll().size());
    }

    @Test (expected=IllegalArgumentException.class)
    public void testDeleteFail() {
        HabitationDBStub h = new HabitationDBStub();
        h.delete(46);
    }
    
}
