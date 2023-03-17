package modele.repositories;

import modele.HibernateUtil;
import modele.dataRepresentation.Gerant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GerantRepository {

    private static GerantRepository instance;

    public static GerantRepository getInstance() {
        if(instance == null) {
            instance = new GerantRepository();
        }
        return instance;
    }

    public Gerant findById(int idGerant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Gerant gerant = null;
        try {
            tx = session.beginTransaction();
            gerant = (Gerant) session.get(Gerant.class, idGerant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return gerant;
    }

    public Gerant findByLogs(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Gerant> gerants = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Gerant g WHERE g.nom = :nomGerant AND e.mdp = :mdpGerant");
            query.setParameter("nomGerant", username);
            query.setParameter("mdpGerant", password);
            gerants = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (gerants.size() > 1 ) {
            throw new RuntimeException("Doublon de gerant alors que le gerant est unique");
        } else if (gerants.size() == 0)  {
            return null;
        }
        return gerants.get(0);
    }

}
