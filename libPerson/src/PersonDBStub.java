package persons;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A stub database of persons. This provides RAM persistency but no long-term persistency.
 */
public class PersonDBStub implements IPersonDB {

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

    @Override
    public void insert(Person p, String pass) throws IllegalArgumentException {
        if (this.exists(p.getEmail())) {
            throw new IllegalArgumentException("Impossible d'ajouter \n" + p.toString() + " : \nEmail déjà utilisé.");
        }
        persons.add(p);
        passwords.add(pass);
    }

    @Override
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

    @Override
    public boolean exists(String email) {
        for (Person p : persons) {
            if (p.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Person get(String email) throws IllegalArgumentException {
        for (Person p : persons) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        throw new IllegalArgumentException("La personne avec l'email " + email + " n'existe pas.");
    }

    @Override
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

    @Override
    public void update(String email, Person person) throws IllegalArgumentException {
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

    @Override
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

    @Override
    public List<Person> getAll() {
        return persons;
    }

}
