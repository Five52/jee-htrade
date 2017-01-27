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
     * Builds a new list of persons.
     */
    public PersonDBStub() {
        this.persons = new ArrayList<Person>();
    }

    @Override
    public void insert(Person p) throws IllegalArgumentException {
        if (this.exists(p.getEmail())) {
            throw new IllegalArgumentException("Impossible d'ajouter \n" + p.toString() + " : \nEmail déjà utilisé.");
        }
        persons.add(p);
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
        return persons.get(i).getPassword().equals(password);
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
    public List<Person> getAll() {
        return persons;
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
        persons.get(index).setPlainPassword(password);
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

}
