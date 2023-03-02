package nouveauModele;

import application.services.EquipeService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

public class PouleRepository {
    private static PouleRepository instance;

    private PouleRepository() {
    }

    public static PouleRepository getInstance() {
        if( instance ==  null) {
            instance = new PouleRepository();
        }
        return instance;
    }

    public void creerPoules(int idTournoiHote) {
        // TODO, surement un appel à procedure stockée en PLSQL
        /* ANCIENNEMENT
        ### Creation
        public static void genererPoules(int idTournoi) {
            CallableStatement stmt;
            try {
                stmt = ConnexionBase.getConnectionBase().prepareCall("{ call GEN_POULES_4_TOURNOI(?) }");
                stmt.setInt(1, idTournoi); // enregistrement du premier paramètre d'entrée

                stmt.execute(); // appel de la procédure
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ### PEUPLAGE
        public static void peuplerPoules(int idTournoi) {
            CallableStatement stmt;
            try {
                stmt = ConnexionBase.getConnectionBase().prepareCall("{ call POPULATE_POULE_4_TOURNOI(?) }");
                stmt.setInt(1, idTournoi); // enregistrement du premier paramètre d'entrée

                stmt.execute(); // appel de la procédure
                stmt.close();

            } catch (SQLException e) {
                if(!e.getMessage().contains("CTQ4266A.SYS_C001313482")) {
                    e.printStackTrace();
                }

            }
        }

         */
    }


    public Poule findById(int idPoule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Poule poule = null;
        try {
            tx = session.beginTransaction();
            poule = (Poule) session.get(Poule.class, idPoule);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return poule;
    }





    public List<Rencontre> getRencontres(Poule poule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Rencontre> rencontres = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT r FROM Rencontre r WHERE r.poule.idPoule = :idPoule");
            query.setParameter("idPoule", poule.getIdPoule());
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

    public List<Equipe> getEquipes(Poule poule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT c.id.equipe FROM Composer c WHERE c.id.poule.idPoule = :idPoule");
            query.setParameter("idPoule", poule.getIdPoule());
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
        return equipes;
    }


}

