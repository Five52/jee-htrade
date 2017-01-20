package habitations;

/**
 * A class for representing an apartment.
 */
public class Apartment extends Habitation {
   
    /**
     * Builds a new apartment.
     * @param surface The apartment surface
     * @param nbRooms The apartment number of rooms
     * @param country The country where the apartment is located
     * @param address The apartment address
     */
    public Apartment(int surface, int nbRooms, Country country, String address) {
        super(surface, nbRooms, country, address);
    }
    
    public Apartment() {
        super();
    }

    /**
     * Returns a representation of this apartment as a string.
     * @return A representation of this apartment as a string
     */
    public String toString() {
        return "Appartement de " + super.toString();
    }
}
