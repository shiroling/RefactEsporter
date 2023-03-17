package nouveauModele.repositories;

import nouveauModele.ConnexionBase;
import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.dataRepresentation.Jouer;
import nouveauModele.dataRepresentation.Poule;
import nouveauModele.dataRepresentation.Rencontre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.CallableStatement;
import java.sql.SQLException;
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

    public List<Equipe> getEquipes(Rencontre rencontre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT j.id.equipe FROM Jouer j WHERE j.id.rencontre.idRencontre = :idRencontre");
            query.setParameter("idRencontre", rencontre.getIdRencontre());
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

    public Equipe getGagnant(Rencontre r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT j.id.equipe FROM Jouer j WHERE j.id.rencontre.idRencontre = :idRencontre AND j.aGagne = 1");
            query.setParameter("idRencontre", r.getIdRencontre());
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
        if (equipes.size() >1 ) {
            throw new RuntimeException("Il deverais y avoir qu'un gagnant la dedans, pabon...");
        }
        if (equipes.isEmpty()) {
            return null;
        }
        return equipes.get(0);
    }

    public String getPorteeRenconre(Rencontre r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        String porteeTournoi = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT t.portee FROM Tournoi t, Poule p, Rencontre r WHERE t.id = p.idTournoi AND p.idPoule = r.poule.idPoule AND r.idRencontre = :idRencontre");
            query.setParameter("idRencontre", r.getIdRencontre());
            porteeTournoi = (String) query.getSingleResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return porteeTournoi;
    }

    public void creerPeuplerRencontres(Poule poule) {
        CallableStatement stmt;
        try {
            stmt = ConnexionBase.getConnectionBase().prepareCall("{ call GEN_RENCONTRE_4_POULE(?) }");
            stmt.setInt(1, poule.getIdPoule()); // enregistrement du premier paramètre d'entrée

            stmt.execute(); // appel de la procédure
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt = ConnexionBase.getConnectionBase().prepareCall("{ call POPULATE_RENCONTRE_4_POULE(?) }");
            stmt.setInt(1, poule.getIdPoule()); // enregistrement du premier paramètre d'entrée

            stmt.execute(); // appel de la procédure
            stmt.close();

        } catch (SQLException e) {
            if(!e.getMessage().contains("CTQ4266A.SYS_C001313482")) {
                e.printStackTrace();
            }

        }
    }

    public List<Rencontre> getRencontres() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Rencontre> rencontres = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT r FROM Rencontre r ");
            rencontres = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rencontres;
    }

    public void setVainqueur(Equipe equipeGagnante, Rencontre rencontre) {
        Equipe equipe1 = this.getEquipes(rencontre).get(0);
        Equipe equipe2 = this.getEquipes(rencontre).get(1);

        Jouer tupleJouerEquipe1 = JouerRepository.getInstance().findByIdRencontreIdEquipe(rencontre.getIdRencontre(), equipe1.getIdEquipe());
        Jouer tupleJouerEquipe2 = JouerRepository.getInstance().findByIdRencontreIdEquipe(rencontre.getIdRencontre(), equipe2.getIdEquipe());
        if(equipe1.equals(equipeGagnante)) {
            tupleJouerEquipe1.setAGagne(true);
            tupleJouerEquipe2.setAGagne(false);
        } else {
            tupleJouerEquipe1.setAGagne(false);
            tupleJouerEquipe2.setAGagne(true);
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(tupleJouerEquipe1);
        session.saveOrUpdate(tupleJouerEquipe2);
        session.getTransaction().commit();
        session.close();
    }
}
