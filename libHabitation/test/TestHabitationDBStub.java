package test;

import static org.junit.Assert.*;
import org.junit.Test;

import habitations.*;

public class TestHabitationDBStub {

    @Test
    public void testGetAll() {
        HabitationDBStub h = new HabitationDBStub();
        assertEquals(10, h.getAll().size());
    }
}
