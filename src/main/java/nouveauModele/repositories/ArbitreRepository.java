package nouveauModele.repositories;

import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Arbitre;
import nouveauModele.dataRepresentation.Gerant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class ArbitreRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private static ArbitreRepository instance;
    private ArbitreRepository() {
    }

    public static ArbitreRepository getInstance() {
        if( instance ==  null) {
            instance = new ArbitreRepository();
        }
        return instance;
    }

    public Arbitre findById(int idArbitre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Arbitre arbitre = null;
        try {
            tx = session.beginTransaction();
            arbitre = (Arbitre) session.get(Arbitre.class, idArbitre);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return arbitre;
    }

    public Arbitre findByLogs(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Arbitre> arbitres = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Arbitre a WHERE a.nom = :nomArbitre AND a.mdp = :mdpArbitre");
            query.setParameter("nomArbitre", username);
            query.setParameter("mdpArbitre", password);
            arbitres = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (arbitres.size() > 1 ) {
            throw new RuntimeException("Doublon d'arbitre alors que l'arbitre est unique");
        } else if (arbitres.size() == 0)  {
            return null;
        }
        return arbitres.get(0);
    }

}
