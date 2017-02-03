package test;

import java.util.List;
import habitations.Habitation;
import habitations.House;
import habitations.Apartment;
import habitations.Country;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.InvalidMappingException;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TestHibernateHabitations {
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("org.hibernate");
        logger.setLevel(Level.WARNING);
        TestHibernateHabitations instance = new TestHibernateHabitations();
        boolean errorOccured=false;
        System.out.println("Test Hibernate habitations...");
        try {
            System.out.print("Initializing...");
            System.out.flush();
            instance.initialize();
            System.out.println("OK");
            System.out.print("Creating habitations...");
            System.out.flush();
            instance.addHabitations();
            System.out.println("OK");
            System.out.println("Retrieving habitations...");
            instance.printAllHabitations();
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            errorOccured = true;
        } finally {
            System.out.print("Closing...");
            System.out.flush();
            try {
                instance.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
                errorOccured = true;
            }
            if (!errorOccured) {
                System.out.println("OK");
                System.out.println("Tests successful");
            }
        }
    }

    protected void initialize() throws InvalidMappingException {
        ServiceRegistry serviceRegistry = null;
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            serviceRegistry = builder.build();
            this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            System.out.println("Error during the initialization of Session Factory : " + e);
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw e;
        }
    }

    protected void close() throws HibernateException {
        if (this.sessionFactory != null) {
            this.sessionFactory.close();
        }
    }

    public void addHabitations() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Habitation");
        if (((List<Habitation>)query.list()).isEmpty()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.save(new House(100, 4, Country.FRANCE, "Paris", 250));
                session.save(new Apartment(65, 3, Country.SPAIN, "Barcelona"));
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

    public void printAllHabitations() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Habitation");
            List<Habitation> allHabitations = (List<Habitation>) query.list();
            for (Habitation habitation : allHabitations) {
                System.out.println(habitation);
            }
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
