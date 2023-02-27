package nouveauModele;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
