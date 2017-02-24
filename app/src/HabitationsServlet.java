package src;

import java.util.List;
import java.io.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.servlet.http.*;
import javax.servlet.ServletException;

public class HabitationsServlet extends HttpServlet {

    private static final String HABITATIONs_ATTR_NAME = "habitation";

    private SessionFactory sessionFactory;

    public void init() throws ServletException {
        Configuration config = null;
        ServiceRegistry registry = null;
        try {
            config = new Configuration().configure();
            registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        } catch (Throwable e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
        this.sessionFactory = config.buildSessionFactory(registry);
    }

    public void destroy() {
        if (this.sessionFactory != null) {
            this.sessionFactory.close();
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.processRequest(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.processRequest(req, res);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getSession().getAttribute(HabitationsServlet.HABITATIONs_ATTR_NAME) == null) {
            this.loadHabitations(req.getSession());
        }
        String action = req.getParameter("action");
        if (action == null || "list".equals(action)) {
            this.getServletContext().getRequestDispatcher("/pages/all.jsp").forward(req, res);
        }
    }


    /**
     * Load every database habitation.
     */
    protected void loadHabitations (HttpSession httpSession) {
        Session hibernateSession = this.sessionFactory.openSession();

        Transaction transaction = null;
        transaction = hibernateSession.beginTransaction();
        Query query=hibernateSession.createQuery("from habitation");

        List allHabitations = query.list();

        // Stores all habitations into HTTP session
        httpSession.setAttribute(HabitationsServlet.HABITATIONs_ATTR_NAME, allHabitations);

        httpSession.setAttribute("habitations", allHabitations);
        hibernateSession.close();
    }
}
