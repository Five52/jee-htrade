package habitations;

/**
 * An abstract class for representing habitations, with a surface, a number of rooms, a country and an address.
 */
public abstract class Habitation {

    /**
     * The habitation surface.
     */
    protected int surface;
    
    /**
     * The habitation number of rooms.
     */
    protected int nbRooms;
    
    /**
     * The habitation country.
     */
    protected Country country;
    
    /**
     * The habitation address.
     */
    protected String address;

    /**
     * Builds a new habitation.
     * @param surface The habitation surface
     * @param nbRooms The habitation number of rooms
     * @param country The country where the habitations is located
     * @param address The habitation address
     */
    public Habitation(int surface, int nbRooms, Country country, String address) {
        this.surface = surface;
        this.nbRooms = nbRooms;
        this.country = country;
        this.address = address;
    }

    /** 
     * Returns the habitation surface.
     * @return The habitation surface
     */
    public int getSurface() {
        return this.surface;
    }

    /** 
     * Sets the habitation surface.
     * @param surface The new habitation surface
     */
    public void setSurface(int surface) {
        this.surface = surface;
    }

    /** 
     * Returns the habitation number of rooms.
     * @return The habitation number of rooms
     */
    public int getNbRooms() {
        return this.nbRooms;
    }

    /** 
     * Sets the habitation number of rooms.
     * @param nbRooms The new habitation number of rooms
     */
    public void setNbRooms(int nbRooms) {
        this.nbRooms = nbRooms;
    }

    /** 
     * Returns the country where the habitation is located
     * @return The country where the habitation is located
     */
    public Country getCountry() {
        return this.country;
    }

    /** 
     * Sets the country where the habitation is located.
     * @param country The country where the habitation is located
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /** 
     * Returns the habitation address.
     * @return The habitation address
     */
    public String getAddress() {
        return this.address;
    }

    /** 
     * Sets the habitation address.
     * @param address The new habitation address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a representation of this habitation as a string.
     * @return A representation of this habitation as a string
     */
    public String toString() {
        return
            this.surface + " m2, "
            + this.nbRooms + " pièces, situé "
            + this.address + " en "
            + this.country
        ;
    }
}
