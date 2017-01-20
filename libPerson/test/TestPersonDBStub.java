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
        p.insert(new Person("robert.martin@mymail.net", "Robert", "Martin", "robert"));
        assertEquals(4, p.getAll().size());
    }

    @Test (expected=IllegalArgumentException.class)
    public void testInsertFail() {
        PersonDBStub p = new PersonDBStub();
        p.insert(new Person("marie.dupont@email.com", "Marie-Anne", "Dupond", "marieanne"));
    }

    @Test
    public void testGet() {
        PersonDBStub p = new PersonDBStub();
        Person marie = p.get("marie.dupont@email.com");
        assertEquals("Marie", marie.getFirstName());
    }

    @Test (expected=IllegalArgumentException.class)
    public void testGetFail() {
        PersonDBStub p = new PersonDBStub();
        Person person = p.get("roland.garros@mail.net");
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

    @Test (expected=IllegalArgumentException.class)
    public void testUpdatePasswordFail() {
        PersonDBStub p = new PersonDBStub();
        p.updatePassword("mail.test@mail.com", "pass");
    }

    @Test
    public void testUpdate() {
        PersonDBStub p = new PersonDBStub();
        p.update("jacques.durand@mail.com", new Person("jacques.durand@mail.com", "Jean-Jacques", "Dupont", "jacques"));
        assertEquals("Jean-Jacques", p.get("jacques.durand@mail.com").getFirstName());  
        assertEquals("Dupont", p.get("jacques.durand@mail.com").getLastName());  
    }

    @Test (expected=IllegalArgumentException.class)
    public void testUpdateFail() {
        PersonDBStub p = new PersonDBStub();
        p.update("new.person@my-mail.ok", new Person("new.person@my-mail.ok", "Mélissa", "Martin", "melissa"));
    }
}
