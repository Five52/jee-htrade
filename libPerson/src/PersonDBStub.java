package persons;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A stub database of persons. This provides RAM persistency but no long-term persistency.
 */
public class PersonDBStub {

    /**
     * The list of persons (without passwords).
     */
    protected List<Person> persons;

    /**
     * A list of passwords, associated with persons in {@link #persons}.
     */
    protected List<String> passwords;

    /**
     * Builds a new list of persons.
     */
    public PersonDBStub() {
        this.persons = new ArrayList<Person>();
        this.passwords = new ArrayList<String>();

        this.insert(new Person("jacques.durand@mail.com", "Jacques", "Durand"), "jacques");
        this.insert(new Person("marie.dupont@email.com", "Marie", "Dupont"), "marie");
        this.insert(new Person("jean-pierre.bar@mail.fr", "Jean-Pierre", "Bar"), "bar");
    }

    /**
     * Tells if a given couple email/password exists in this database.
     * @param email The email we search for
     * @param password The password to test with the given email
     * @return true if the given couple exists in the database, false otherwise
     */
    public boolean isValid(String email, String password) {
        int i;
        for (i = 0; i < persons.size(); i++) {
            if (persons.get(i).getEmail().equals(email)) {
                break;
            }
        }
        if (i == persons.size()) {
            return false;
        }
        return passwords.get(i).equals(password);
    }

    /**
     * Tells if a person with the given email already exists in this database.
     * @param email The email to test
     * @return true if the given email already exists. Otherwise, false
     */
    public boolean exists(String email) {
        for (Person p : persons) {
            if (p.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a person to this database.
     * @param p The person to add
     * @param pass The password for the person p
     * @throws IllegalArgumentException if the same email is already used
     */
    public void insert(Person p, String pass) throws IllegalArgumentException {
        if (this.exists(p.getEmail())) {
            throw new IllegalArgumentException("Impossible d'ajouter \n" + p.toString() + " : \nEmail déjà utilisé.");
        }
        persons.add(p);
        passwords.add(pass);
    }

    /**
     * Returns the person with the given email.
     * @param email The email to search for
     * @return The person with the given email in this database
     * @throws IllegalArgumentException if the email does not exist in the database
     */
    public Person get(String email) throws IllegalArgumentException {
        for (Person p : persons) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        throw new IllegalArgumentException("La personne avec l'email " + email + " n'existe pas.");
    }

    /**
     * Update the passowrd of the person with the given email.
     * @param email The email address of the person whose password to update
     * @param password The new password of the person
     * @throws IllegalArgumentException if the given email doesn't exist in this database
     */
    public void updatePassword(String email, String password) throws IllegalArgumentException {
        int index = -1;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getEmail().equals(email)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("La personne avec l'email " + email + " n'existe pas.");
        }
        passwords.set(index, password);
    }

    /**
     * Updates the person associated to the given address, in this database.
     * @param email The email of the person to update
     * @param person The new instance of the person with the given email
     * @throws IllegalArgumentException if the given email is currently not in this database
     */
    public void update (String email, Person person) throws IllegalArgumentException {
        int index = -1;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getEmail().equals(email)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("La personne avec l'email " + email + " n'existe pas.");
        }
        persons.set(index, person);
    }

    /**
     * Removes the person with the given email.
     * @param email The email address of the person to remove
     * @throws IllegalArgumentException if no person is currently associated with the given email
     */
    public void delete(String email) {
        int index = -1;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getEmail().equals(email)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Personne ne possède l'email " + email);
        }
        persons.remove(index);
    }

    /**
     * Gives the entire list of persons in this database.
     * @return persons The list of persons
     */
    public List<Person> getAll() {
        return persons;
    }

}
