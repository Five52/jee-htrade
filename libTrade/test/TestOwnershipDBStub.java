package test;

import persons.Person;
import habitations.*;
import trades.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestOwnershipDBStub {

    @Test
    public void testInsertOwnership() {
       OwnershipDBStub os = new OwnershipDBStub();
       Person p = new Person("jacques.dupond@mail.fr","Jacques", "Dupont", "jacques");;
       Habitation h = new Apartment(75, 4, Country.FRANCE, "4 Avenue Charles de Gaulle");
       os.insert(new Ownership(p, h));
       assertEquals(6, os.getAll().size());
    }

}
