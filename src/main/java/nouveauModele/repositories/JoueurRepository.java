package nouveauModele.repositories;

import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Joueur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class JoueurRepository {

    private static JoueurRepository instance;

    public static JoueurRepository getInstance() {
        if(instance == null) {
            instance = new JoueurRepository();
        }
        return instance;
    }
    public Joueur findByPseudo(String pseudoJoueur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Joueur> joueurs = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Joueur j WHERE j.pseudo = :pseudo");
            query.setParameter("pseudo", pseudoJoueur);
            joueurs = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (joueurs.size() > 1 ) {
            throw new RuntimeException("Doublon de pseudo alors qu'il est unique");
        } else if (joueurs.isEmpty())  {
            return null;
        }
        return joueurs.get(0);
    }

    public Joueur findById(int idJoueur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Joueur joueur = null;
        try {
            tx = session.beginTransaction();
            joueur = (Joueur) session.get(Joueur.class, idJoueur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return joueur;
    }

    public void save(Joueur joueur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(joueur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
