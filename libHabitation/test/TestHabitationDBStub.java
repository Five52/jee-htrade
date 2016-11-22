package test;

import static org.junit.Assert.*;
import org.junit.Test;

import habitations.*;

public class TestHabitationDBStub {

    @Test
    public void testGetAll() {
        HabitationDBStub h = new HabitationDBStub();
        assertEquals(12, h.getAll().size());
    }

    @Test
    public void testInsertApartment() {
       HabitationDBStub h = new HabitationDBStub();
       h.insert(new Apartment(12, 75, 4, Country.FRANCE, "4 Avenue Charles de Gaulle"));
       assertEquals(13, h.getAll().size());
    }

    @Test
    public void testInsertHouse() {
       HabitationDBStub h = new HabitationDBStub();
       h.insert(new House(12, 140, 6, 60, Country.FRANCE, "4 Rue du 6 Juin"));
       assertEquals(13, h.getAll().size());
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
