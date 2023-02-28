package nouveauModele;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class RencontreRepository {

    private static RencontreRepository instance;

    private RencontreRepository() {
    }

    public static RencontreRepository getInstance() {
        if( instance ==  null) {
            instance = new RencontreRepository();
        }
        return instance;
    }

    public List<Equipe> getEquipes(int idRencontre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT j.id.equipe FROM Jouer j WHERE j.id.rencontre.idRencontre = :idRencontre");
            query.setParameter("idRencontre", idRencontre);
            equipes = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (equipes.size() >2 || equipes.isEmpty()) {
            throw new RuntimeException("Il deverais y avoir des équipes la dedans, pabon...");
        }
        return equipes;
    }

    public Rencontre findById(int idRencontre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Rencontre rencontre = null;
        try {
            tx = session.beginTransaction();
            rencontre = (Rencontre) session.get(Rencontre.class, idRencontre);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rencontre;
    }

    public boolean estResultatRenseigne(Rencontre rencontre) {
        return false;
    }
}
