package habitations;

/**
 * A class for representing a house.
 */
public class House extends Habitation {

    /** 
     * The house outdoor surface.
     */
    protected int outdoorSurface;

    /** Builds a new house.
     * @param surface The house surface
     * @param nbRooms The house number of rooms
     * @param outdoorSurface The house outdoor surface
     * @param country The country where the house is located
     * @param address The house address
     */
    public House(int surface, int nbRooms, int outdoorSurface, Country country, String address) {
        super(surface, nbRooms, country, address);
        this.outdoorSurface = outdoorSurface;
    }

    /**
     * Returns the house outdoor surface.
     * @return The house outdoor surface
     */
    public int getOutdoorSurface() {
        return this.outdoorSurface;
    }

    /**
     * Sets the house outdoor surface
     * @param outdoorSurface The new house outdoor surface
     */
    public void setOutdoorSurface(int outdoorSurface) {
        this.outdoorSurface = outdoorSurface;
    }

    /**
     * Returns a representation of this house as a string.
     * @return A representation of this house as a string
     */
    public String toString() {
        return "Maison de " + super.toString();
    }
}
