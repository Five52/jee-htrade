package habitations;

public class Apartment extends Habitation {
    
    public Apartment(int surface, int nbRooms, Country country, String address) {
        super(surface, nbRooms, country, address);
    }

    public String toString() {
        return "Appartement de " + super.toString();
    }
}
