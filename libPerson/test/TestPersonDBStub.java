package test;

import static org.junit.Assert.*;
import org.junit.Test;

import persons.*;

public class TestPersonDBStub {

    @Test
    public void testGetAll() {
        PersonDBStub p = new PersonDBStub();
        assertEquals(3, p.getAll().size());
    }

    @Test
    public void testInsert() {
        PersonDBStub p = new PersonDBStub();
        p.insert(new Person("robert.martin@mymail.net", "Robert", "Martin"), "robert");
        assertEquals(4, p.getAll().size());
    }

    @Test
    public void testGet() {
        PersonDBStub p = new PersonDBStub();
        Person marie = p.get("marie.dupont@email.com");
        assertEquals("Marie", marie.getFirstName());
    }

    @Test
    public void testDelete() {
        PersonDBStub p = new PersonDBStub();
        p.delete("jean-pierre.bar@mail.fr");
        assertEquals(2, p.getAll().size());
    }

    @Test
    public void testIsValid() {
        PersonDBStub p = new PersonDBStub();
        assert p.isValid("jacques.durand@mail.com", "jacques");
    }

    @Test
    public void testUpdatePassword() {
        PersonDBStub p = new PersonDBStub();
        p.updatePassword("marie.dupont@email.com", "marie2");
        assert p.isValid("marie.dupont@email.com", "marie2");
    }

    @Test
    public void testUpdate() {
        PersonDBStub p = new PersonDBStub();
        p.update("jacques.durand@mail.com", new Person("jacques.durand@mail.com", "Jean-Jacques", "Dupont"));
        assertEquals("Jean-Jacques", p.get("jacques.durand@mail.com").getFirstName());  
    }
}
