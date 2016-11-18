package test;

import static org.junit.Assert.*;
import org.junit.Test;

import habitations.*;

public class TestHabitationDBStub {

    @Test
    public void testGetAll() {
        HabitationDBStub h = new HabitationDBStub();
        assertEquals(11, h.getAll().size());
    }

    @Test
    public void testInsert() {
       HabitationDBStub h = new HabitationDBStub();
       h.insert(new Apartment(75, 4, Country.FRANCE, "4 Avenue Charles de Gaulle"));
       assertEquals(12, h.getAll().size());
    }
    
}
