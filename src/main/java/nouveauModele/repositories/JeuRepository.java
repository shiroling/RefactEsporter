package nouveauModele.repositories;

import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.dataRepresentation.Jeu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class JeuRepository {
    private static JeuRepository instance;

    public static JeuRepository getInstance() {
        if (instance == null) {
            instance = new JeuRepository();
        }
        return instance;
    }
    public Jeu findById(int idJeu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Jeu jeux = null;
        try {
            tx = session.beginTransaction();
            jeux = (Jeu) session.get(Jeu.class, idJeu);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return jeux;
    }

    public List<Jeu> getJeux() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Jeu> jeux = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Jeu ");
            jeux = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return jeux;
    }
}
