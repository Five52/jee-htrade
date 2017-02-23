package trades;

import habitations.Habitation;
import persons.Person;

import java.util.ArrayList;

/**
 * An interface for databases of trades.
 */
public interface IOwnershipDB {

    /**
     * Adds an ownership in this database.
     * @param o The new ownership to add
     */
    public void insert(Ownership o);

    /**
     * Returns the ownership with the given habitation.
     * @param h The habitation of the ownership we search for
     * @return The trade with the given id
     * @throws Exception if no ownership exists with the given id in the database
     */
    public Ownership get(Habitation h) throws Exception;

    /**
     * Gives the entire list of ownerships in this database.
     * @return ownerships The list of ownerships
     */
    public ArrayList<Ownership> getAll();

    /**
     * Updates the ownership with the given id.
     * @param h The habitation of the ownership to update
     * @param o The new owner
     * @throws Exception if no ownership exists with the given id in the database
     */
    public void update(Habitation h, Person o) throws Exception;

    /**
     * Removes the trade with the given habitation from this database.
     * @param h The habitation of the ownership to remove
     * @throws Exception if the given ownership does not exist in the database
     */
    public void delete(Habitation h) throws Exception;
}
