package nouveauModele.repositories;

import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.dataRepresentation.Inscrit;
import nouveauModele.dataRepresentation.Poule;
import nouveauModele.dataRepresentation.Tournoi;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    public Tournoi findByNom(String nomTournoi) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Tournoi> tournois = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Tournoi t WHERE t.nom = :nomTournoi");
            query.setParameter("nomTournoi", nomTournoi);
            tournois = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (tournois.size() > 1 ) {
            throw new RuntimeException("Doublon de tournois alors qu'il est unique");
        } else if (tournois.isEmpty())  {
            return null;
        }
        return tournois.get(0);
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
            Query query = session.createQuery("SELECT i.id.equipe FROM Inscrit i WHERE i.id.tournoi.id = :idTournoi AND i.id.equipe.idEquipe = :idEquipe");
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
    public List<Tournoi> getTournois() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Tournoi> tournoi = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Tournoi t");
            tournoi = query.list();
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

    public List<Poule> getAllPoules(Tournoi tournoiAvecPoules) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Poule> poules = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Poule p  WHERE p.idTournoi = :idTournoi");
            query.setParameter("idTournoi", tournoiAvecPoules.getId());
            poules = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return poules;
    }

    public List<Poule> getPoulesClassiques(Tournoi tournoiAvecPoules) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Poule> poules = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Poule p  WHERE p.idTournoi = :idTournoi AND p.finale = 0");
            query.setParameter("idTournoi", tournoiAvecPoules.getId());
            poules = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return poules;
    }

    public Poule getPouleFinale(Tournoi tournoiAvecPoules) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Poule> poules = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Poule p  WHERE p.idTournoi = :idTournoi AND p.finale = 1");
            query.setParameter("idTournoi", tournoiAvecPoules.getId());
            poules = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (poules.size() > 1) {
            throw new RuntimeException("Le tournois à plusieurs poules finales");
        }
        if (poules.size() ==1) {
            return poules.get(0);
        }else {
            return null;
        }
    }
}
