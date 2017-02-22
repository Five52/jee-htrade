package trades;

import persons.Person;
import habitations.Habitation;

public class Ownership {

    /**
     * The owner of the habitation.
     */
    protected Person owner;

    /**
     * The habitation concerned.
     */
    protected Habitation habitation;

    /** 
     * Empty constructor for Hibernante.
     */
    public Ownership() {}

    /**
     * Builds a new ownership.
     * @param owner The owner
     * @param habitation The habitation
     */
    public Ownership(Person owner, Habitation habitation) {
        this.owner = owner;
        this.habitation = habitation;
    }

    /**
     * Returns the owner.
     * @return The owner
     */
    public Person getOwner() {
        return this.owner;
    }
    
    /**
     * Sets the owner.
     * @param newOwner The new owner
     */
    public void setOwner(Person newOwner) {
        this.owner = newOwner;
    }

    /**
     * Returns the habitation.
     * @return The habitation
     */
    public Habitation getHabitation() {
        return this.habitation;
    }

    /**
     * Sets the habitation.
     * @param newHabitation The new habitation
     */
    public void setHabitation(Habitation newHabitation) {
        this.habitation = newHabitation;
    }
}
