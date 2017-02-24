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
        this.ownerships = new ArrayList<Ownership>();
    }

    @Override
    public void insert(Ownership o) {
        if (this.exists(o.getHabitation())) {
            throw new IllegalArgumentException("Impossible d'ajouter \n" + o.getHabitation().toString() + " : L'habitation a déjà un propriétaire.");
        }
        ownerships.add(o);
    }

    @Override
    public boolean exists(Habitation h) {
        for (Ownership o : ownerships) {
            if (o.getHabitation() == h) {
                return true;
            }
        }
        return false;
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
