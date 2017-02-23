package trades;

import persons.Person;
import habitations.*;

import java.util.ArrayList;

/**
 * A stub of database of ownerships. This provides RAM persistency but no long-term persistency.
 */
public class OwnershipDBStub implements IOwnershipDB {

    /**
     * The list of ownerships in this database.
     */
    protected ArrayList<Ownership> ownerships;

    /**
     * Builds a new list of ownerships with relevant data.
     */
    public OwnershipDBStub() {
        ownerships = new ArrayList<Ownership>();
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
        this.insert(new Ownership(marie, h1));
        this.insert(new Ownership(jean, h2));
        this.insert(new Ownership(nicolas, h3));
        this.insert(new Ownership(emilie, h4));
        this.insert(new Ownership(emilie, h5));
    }

    @Override
    public void insert(Ownership o) {
        ownerships.add(o);
    }

    @Override
    public Ownership get(Habitation h) throws IllegalArgumentException {
        for (Ownership o : ownerships) {
            if (o.getHabitation() == h) {
                return o;
            }
        }
        throw new IllegalArgumentException("Cette habitation n'a pas de propriétaire connu.");
    }

    @Override
    public ArrayList<Ownership> getAll() {
        return ownerships;
    }

    @Override
    public void update(Habitation h, Person o) throws IllegalArgumentException {
        int index = -1;
        for (Ownership os : ownerships) {
            if (os.getHabitation() == h) {
                index = ownerships.indexOf(o);
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("L'habitation demandée n'a pas de propriétaire connu.");
        }
        ownerships.set(index, new Ownership(o, h));
    }

    @Override
    public void delete(Habitation h) throws IllegalArgumentException {
        int index = -1;
        for (Ownership o : ownerships) {
            if (o.getHabitation() == h) {
                index = ownerships.indexOf(o);
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("L'habitation demandée n'a pas de propriétaire connu.");
        }
        ownerships.remove(index);
    }
}
