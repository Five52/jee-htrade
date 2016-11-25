package persons;

import java.util.Collection;

/**
 * An interface for databases of persons. This interface essentially includes CRUD operations.
 */
public interface IPersonDB {
    
    /**
     * Adds a person to this database.
     * @param p The person to add
     * @param pass The password for the person p
     * @throws Exception if the same email is already used
     */
    public void insert(Person p, String pass) throws Exception;

    /**
     * Tells if a given couple email/password exists in this database.
     * @param email The email we search for
     * @param password The password to test with the given email
     * @return true if the given couple exists in the database, false otherwise
     */
    public boolean isValid(String email, String password);
    /**
     * Tells if a person with the given email already exists in this database.
     * @param email The email to test
     * @return true if the given email already exists. Otherwise, false
     */
    public boolean exists(String email);
    /**
     * Returns the person with the given email.
     * @param email The email to search for
     * @return The person with the given email in this database
     * @throws Exception if the email does not exist in the database
     */
    public Person get(String email) throws Exception;

    /**
     * Update the passowrd of the person with the given email.
     * @param email The email address of the person whose password to update
     * @param password The new password of the person
     * @throws Exception if the given email doesn't exist in this database
     */
    public void updatePassword(String email, String password) throws Exception;

    /**
     * Updates the person associated to the given address, in this database.
     * @param email The email of the person to update
     * @param person The new instance of the person with the given email
     * @throws Exception if the given email is currently not in this database
     */
    public void update(String email, Person person) throws Exception;

    /**
     * Removes the person with the given email.
     * @param email The email address of the person to remove
     * @throws Exception if no person is currently associated with the given email
     */
    public void delete(String email) throws Exception;

    /**
     * Gives the entire list of persons in this database.
     * @return persons The list of persons
     */
    public Collection<Person> getAll();
}
