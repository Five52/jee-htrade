package habitations;

import java.util.Collection;

/**
 * An interface for databases of habitations.
 */
public interface IHabitationDB {

    /**
     * Adds a habitation in this database.
     * @param h The new habitation to add
     */
    public void insert(Habitation h);

    /**
     * Gives the entire list of habitations in this database.
     * @return habitations The list of habitations
     */
    public Collection<Habitation> getAll();

    /**
     * Removes the habitation with the given id from this database.
     * @param id The id of the habitation to remove
     * @throws Exception if the given id does not exist in the database
     */
    public void delete(int id) throws Exception;
}
