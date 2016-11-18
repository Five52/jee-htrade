package habitations;

public class House extends Habitation {

    protected int outdoorSurface;

    public House(int surface, int nbRooms, int outDoorSurface, Country country, String address) {
        super(surface, nbRooms, country, address);
        this.outdoorSurface = outdoorSurface;
    }

    public int getOutdoorSurface() {
        return this.outdoorSurface;
    }

    public void setOutdoorSurface(int outdoorSurface) {
        this.outdoorSurface = outdoorSurface;
    }

    public String toString() {
        return "Maison de " + super.toString();
    }
}
