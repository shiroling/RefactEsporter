package nouveauModele;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.TrueFalseType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class TournoiRepository {
    private static TournoiRepository instance;

    public static TournoiRepository getInstance() {
        if(instance == null) {
            instance = new TournoiRepository();
        }
        return instance;
    }

    public Tournoi findByNom(String nomTounoi) {
        return null;
    }

    public Tournoi findById(int idTournoi) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Tournoi tournoi = null;
        try {
            tx = session.beginTransaction();
            tournoi = (Tournoi) session.get(Tournoi.class, idTournoi);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tournoi;
    }

    public void enregistrerNouveauTournoi(Tournoi nouveauTournoi) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(nouveauTournoi);
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


    public boolean estEquipeInscrite(Equipe equipeAInscrire, Tournoi tournoiHote) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT i.id.equipe FROM Inscrit i WHERE i.id.tournoi.id = :idTournoi AND i.id.Equipe.id.idEquipe = :idEquipe");
            query.setParameter("idTournoi", tournoiHote.getId());
            query.setParameter("idEquipe", equipeAInscrire.getIdEquipe());
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
        if (equipes.size() >2) {
            throw new RuntimeException("Il deverais y avoir plusieurs fois la méme equipe inscrite, pabon...");
        }
        return !equipes.isEmpty();
    }

    public void inscrireEquipeATournoi(Equipe equipeAInscrire, Tournoi tournoiHote) {
        Inscrit inscription = new Inscrit(equipeAInscrire, tournoiHote, Date.from(Instant.now()));
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(inscription);
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

    public List<Equipe> getEquipesInscrites(Tournoi tournoiHote) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT i.id.equipe FROM Inscrit i WHERE i.id.tournoi.id = :idTournoi");
            query.setParameter("idTournoi", tournoiHote.getId());
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
