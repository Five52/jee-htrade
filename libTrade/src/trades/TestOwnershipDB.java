package trades;

import persons.*;
import habitations.*;

import java.util.Collection;

/**
 * A class for running basic tests on classes which implement interface IOwnershipDB.
 */
public class TestOwnershipDB {

    public static void test (IOwnershipDB instance) throws Exception {
        // Creation of persons for the database
        Person marie = new Person("marie.dupont@mail.fr", "Marie", "Dupont", "marie");
        Person jean = new Person("jean.martin@mail.com", "Jean", "Martin", "jean");
        Person nicolas = new Person("nicolas.durand@mail.com", "Nicolas", "Durand", "nicolas");
        Person emilie = new Person("emilie.lefevre@mail.fr","Emilie", "Lefevre", "emilie");
        // Creation of habitations for the database
        Habitation h1 = new Apartment(84, 7, Country.UNITED_KINGDOM, "76 Blvd Of Broken Dreams");
        Habitation h2 = new House(80, 8, Country.SWITZERLAND, "21 Rue du Chocolat", 54);
        Habitation h3 = new Apartment(57, 5, Country.FRANCE, "6 rue de la République");
        Habitation h4 = new Apartment(77, 6, Country.UNITED_STATES, "4 Washington Street");
        Habitation h5 = new House(98, 8, Country.BELGIUM, "18 Avenue de la Jupiler", 45);
        // Insert ownerships
        instance.insert(new Ownership(marie, h1));
        instance.insert(new Ownership(jean, h2));
        instance.insert(new Ownership(nicolas, h3));
        instance.insert(new Ownership(emilie, h4));
        instance.insert(new Ownership(emilie, h5));

        Collection<Ownership> all = instance.getAll();
        assert all.size() == 4;
        boolean marieApartment = false;
        int index = 0;
        for (Ownership o : all) {
            if (o.getHabitation() == h1 && o.getOwner() == marie) {
                marieApartment = true;
            }
        }
        assert marieApartment;
    }
}
