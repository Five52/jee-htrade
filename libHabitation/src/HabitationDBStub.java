package habitations;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * A stub of database of habitations. This provides RAM persistency but no long-term persistency.
 */
public class HabitationDBStub implements IHabitationDB {

    /**
     * The list of habitations in this database.
     */
    protected List<Habitation> habitations;

    /**
     * Builds a new list of habitations with relevant data.
     */
    public HabitationDBStub() {
        habitations = new ArrayList<Habitation>();
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
            this.insert(new House(
                i+1,
                random.nextInt(300),
                random.nextInt(11),
                random.nextInt(500),
                countries[random.nextInt(countries.length)],
                addresses[random.nextInt(addresses.length)]
            ));
            this.insert(new Apartment(
                i+6,
                random.nextInt(200),
                random.nextInt(8),
                countries[random.nextInt(countries.length)],
                addresses[random.nextInt(addresses.length)]
            ));
        }
        this.insert(new Apartment(11, 99, 7, Country.UNITED_KINGDOM, "76 Blvd Of Broken Dreams"));
        this.insert(new House(12, 150, 8, 80, Country.SWITZERLAND, "21 Rue du Chocolat"));
    }

    @Override
    public void insert(Habitation h) {
        habitations.add(h);
    }

    @Override
    public void delete(int id) throws IllegalArgumentException {
        int index = -1;
        for (int i = 0; i < habitations.size(); i++) {
            if (habitations.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Aucune habitation avec l'identifiant " + id + " n'a été trouvé.");
        }
        habitations.remove(index);
    }

    @Override
    public List<Habitation> getAll() {
        return habitations;
    }
}
