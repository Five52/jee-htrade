package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.InvalidMappingException;
import org.hibernate.HibernateException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.logging.Logger;
import java.util.logging.Level;

import persons.Person;

public class TestPersonHibernate {
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("org.hibernate");
        logger.setLevel(Level.WARNING);

        TestPersonHibernate instance = new TestPersonHibernate();

        boolean errorOccured = false;

        System.out.println("Testing Hibernate persons..");
        
        try {
            System.out.println("Initializing..");
            System.out.flush();

            instance.initialize();
            System.out.println("Instance initialized.");

            System.out.println("Creating persons..");
            System.out.flush();
            instance.addPersons();

            System.out.println("Persons created.");

            System.out.println("Retrieving persons..");
            instance.displayAllPersons();

            System.out.println("Persons retrieved.");
        } catch(Exception e) {
            System.out.println("Error : " + e);
            errorOccured = true;
        } finally {
            System.out.println("Closing..");
            System.out.flush();
            try {
                instance.close();
            } catch (Exception e) {
                System.out.println("Error : " + e);
                errorOccured = true;
            }
            if (!errorOccured) {
                System.out.println("Tests finished successfully.");
            }
        }
    }

    /**
     * Initialization of the Session Factory.
     */
    protected void initialize() throws InvalidMappingException {
        ServiceRegistry serviceRegistry = null;
        try {
            Configuration config = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            serviceRegistry = builder.build();
            this.sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            System.out.println("Erreur lors de l'initialisation de la Session Factory : " + e);
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw e;
        }
    }

    /**
     * Closing Session Factory.
     */
    protected void close() throws HibernateException {
        if (this.sessionFactory != null) {
            this.sessionFactory.close();
        }
    }

    /**
     * Add persons for tests.
     */
    public void addPersons() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Person");

        if (((List<Person>) query.list()).isEmpty()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(new Person("gilles.marie@mail.com", "Gilles", "Marie", "gilles"));
                session.save(new Person("margaux.test@gmail.com", "Margaux", "Test", "margaux"));
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw e;
            } finally {
                session.close();
            }
        }
    }

    /**
     * Display all persons
     */
    public void displayAllPersons() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Person");
            List<Person> allPersons = (List<Person>) query.list();
            for (Person person: allPersons) {
                System.out.println(person);
            }
            assert allPersons.size() == 2;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
