package habitations;

import java.util.HashMap;

/**
 * An interface for databases of habitations.
 */
public interface IHabitationDB {

    /**
     * Adds a habitation in this database.
     * @param h The new habitation to add
     */
    public void insert(int id, Habitation h);

    /**
     * Returns the habitation with the given id.
     * @param id The id of the habitation we search for
     * @return The habitation with the given id
     * @throws Exception if no habitation exists with the given id in the database
     */
    public Habitation get(int id) throws Exception;

    /**
     * Gives the entire list of habitations in this database.
     * @return habitations The list of habitations
     */
    public HashMap<Integer, Habitation> getAll();

    /**
     * Updates the habitation with the given id.
     * @param id The id of the habitation to update
     * @param h The new habitation
     * @throws Exception if no habitation exists with the given id in the database
     */
    public void update(int id, Habitation h) throws Exception;

    /**
     * Removes the habitation with the given id from this database.
     * @param id The id of the habitation to remove
     * @throws Exception if the given id does not exist in the database
     */
    public void delete(int id) throws Exception;
}
