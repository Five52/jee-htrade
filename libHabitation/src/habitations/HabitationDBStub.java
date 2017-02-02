package habitations;

import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A stub of database of habitations. This provides RAM persistency but no long-term persistency.
 */
public class HabitationDBStub implements IHabitationDB {

    /**
     * The list of habitations in this database.
     */
    protected HashMap<Integer, Habitation> habitations;

    /**
     * Builds a new list of habitations with relevant data.
     */
    public HabitationDBStub() {
        habitations = new HashMap<Integer, Habitation>();
        Random random = new Random(55152);
        String[] addresses = new String[] {
            "Sesame Street",
            "Fifth Avenue",
            "JFK Street",
            "Hollywood Boulevard",
            "Insert Name Street"
        };
        Country[] countries = Country.values();
        for (int i = 0; i < 5; i++) {
            this.insert(
                i+1,
                new House(
                    random.nextInt(300),
                    random.nextInt(11),
                    countries[random.nextInt(countries.length)],
                    addresses[random.nextInt(addresses.length)],
                    random.nextInt(500)
            ));
            this.insert(
                i+6,
                new Apartment(
                    random.nextInt(200),
                    random.nextInt(8),
                    countries[random.nextInt(countries.length)],
                    addresses[random.nextInt(addresses.length)]
            ));
        }
        this.insert(11, new Apartment(84, 7, Country.UNITED_KINGDOM, "76 Blvd Of Broken Dreams"));
        this.insert(12, new House(80, 8, Country.SWITZERLAND, "21 Rue du Chocolat", 54));
    }

    @Override
    public void insert(int id, Habitation h) {
        habitations.put(id, h);
    }

    @Override
    public Habitation get(int id) throws IllegalArgumentException {
        for (Map.Entry h : habitations.entrySet()) {
            if (((Integer) h.getKey()) == id) {
                return ((Habitation) h.getValue());
            }
        }
        throw new IllegalArgumentException("L'habitation demandée n'existe pas.");
    }

    @Override
    public HashMap<Integer, Habitation> getAll() {
        return habitations;
    }

    @Override
    public void update(int id, Habitation habitation) throws IllegalArgumentException {
        int index = -1;
        int i = 1;
        Iterator iterator = habitations.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry h = (Map.Entry) iterator.next();
            if (((Integer) h.getKey()) == id) {
                index = i;
                break;
            }
            i++;
        }
        if (index == -1) { 
            throw new IllegalArgumentException("L'habitation demandée n'existe pas.");
        }
        habitations.replace(index, habitation);
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        int index = -1;
        int i = 0;
        Iterator iterator = habitations.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry h = (Map.Entry) iterator.next();
            if (((Integer) h.getKey()) == id) {
                index = i;
                break;
            }
            i++;
        }
        if (index == -1) {
            throw new IllegalArgumentException("Aucune habitation avec l'identifiant " + id + " n'a été trouvé.");
        }
        habitations.remove(index);
    }
}
