package persons;

import java.util.Collection;

/**
 * A class for running some basic tests on classes which implement interface IPersonDB.
 * @author Charlotte Lecluze and Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France
 * @since February, 2013
 */
public class TestPersonDB {

    /**
     * Runs a series of tests on an instance of a class which implements IPersonDB.
     * The instance is assumed to represent an empty database of persons when passed to
     * this method. If tests go well, the database is empty again when the method exits.
     * The method uses assertions to run tests.
     * @param instance An instance of the class to be tested, representing an empty
     * database of persons
     * @throws Exception if an unexpected error occurs
     */
    public static void test (IPersonDB instance) throws Exception {
        instance.insert(new Person("marie.dupont@mail.fr", "Marie", "Dupont", "marie"));
        instance.insert(new Person("jean.martin@mail.com", "Jean", "Martin", "jean"));
        instance.insert(new Person("nicolas.durand@mail.com", "Nicolas", "Durand", "nicolas"));
        instance.insert(new Person("emilie.lefevre@mail.fr","Emilie", "Lefevre", "emilie"));

        // Testing "R" methods
        Collection<Person> all = instance.getAll();
        assert all.size() == 4;
        boolean nicolasFound=false;
        for (Person p: all) {
            if ("nicolas.durand@mail.com".equals(p.getEmail())) {
                nicolasFound = true;
            }
        }
        assert nicolasFound;
        assert instance.exists("marie.dupont@mail.fr");
        assert !instance.exists("jacques.durand@mail.com");
        Person marie=instance.get("marie.dupont@mail.fr");
        assert "Dupont".equals(marie.getLastName());
        assert "Marie".equals(marie.getFirstName());
        assert "marie.dupont@mail.fr".equals(marie.getEmail());
        assert instance.isValid("marie.dupont@mail.fr","marie");
        assert !instance.isValid("marie.dupont@mail.fr","jean");
        assert !instance.isValid("marie.dupont@mail.fr","");

        // Testing "U" methods
        instance.update("jean.martin@mail.com", new Person("jeannot.martinet@mail.com", "Jeannot", "Martinet", "jean"));
        assert instance.exists("jeannot.martinet@mail.com");
        Person jeannot = instance.get("jeannot.martinet@mail.com");
        assert "Martinet".equals(jeannot.getLastName());
        assert "Jeannot".equals(jeannot.getFirstName());
        assert "jeannot.martinet@mail.com".equals(jeannot.getEmail());

        instance.updatePassword("nicolas.durand@mail.com","new");
        assert !instance.isValid("nicolas.durand@mail.com","nicolas");
        assert instance.isValid("nicolas.durand@mail.com","new");
        assert !instance.isValid("marie.dupont@mail.fr","new");

        // Testing "D" methods
        instance.delete("nicolas.durand@mail.com");
        assert instance.getAll().size() == 3;
        assert !instance.exists("nicolas.durand@mail.com");
        assert instance.exists("emilie.lefevre@mail.fr");
    }
}

