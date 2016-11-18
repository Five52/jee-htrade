package habitations;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class HabitationDBStub {
    protected List<Habitation> habitations;

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
                random.nextInt(300),
                random.nextInt(11),
                random.nextInt(500),
                countries[random.nextInt(countries.length)],
                addresses[random.nextInt(addresses.length)]
            ));
            this.insert(new Apartment(
                random.nextInt(200),
                random.nextInt(8),
                countries[random.nextInt(countries.length)],
                addresses[random.nextInt(addresses.length)]
            ));
        }
    }

    public void insert(Habitation h) {
        habitations.add(h);
    }

    public void delete(Habitation h) {
        habitations.remove(h);
    }

    public List<Habitation> getAll() {
        return habitations;
    }
}
