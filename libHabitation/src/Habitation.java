package habitations;

public abstract class Habitation {

    protected int surface;
    protected int nbRooms;
    protected Country country;
    protected String address;

    public Habitation(int surface, int nbRooms, Country country, String address) {
        this.surface = surface;
        this.nbRooms = nbRooms;
        this.country = country;
        this.address = address;
    }

    public int getSurface() {
        return this.surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getNbRooms() {
        return this.nbRooms;
    }

    public void setNbRooms(int nbRooms) {
        this.nbRooms = nbRooms;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country Country) {
        this.country = country;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return
            this.surface + " m2, "
            + this.nbRooms + " pièces, situé "
            + this.address + " en "
            + this.country
        ;
    }
}
