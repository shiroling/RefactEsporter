package nouveauModele;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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


}
