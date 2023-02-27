package nouveauModele;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.List;

public class EquipeRepository {
    private static EquipeRepository instance;

    public static EquipeRepository getInstance() {
        if(instance == null) {
            instance = new EquipeRepository();
        }
        return instance;
    }

    public List<Equipe> getListeIdsEquipesFromIdEcurie(int idEcurie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            //transaction = session.beginTransaction();

            Query query = session.createQuery("select equipe from Equipe equipe where equipe.ecurie.id = :idEcurie");
            query.setParameter("idEcurie", idEcurie);

            List<Equipe> equipes = query.list();

            //transaction.commit();
            return equipes;

        } catch (HibernateException e) {
            //if (transaction != null) {
            //    transaction.rollback();
            //}
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public int getPoints(int idEquipe) {
        // TODO
        return -1;
    }

    public Equipe findById(int idEquipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Equipe equipe = null;
        try {
            tx = session.beginTransaction();
            equipe = (Equipe) session.get(Equipe.class, idEquipe);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return equipe;
    }

    public List<Joueur> getJoueurs(int idEquipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Joueur> joueurs = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Joueur j WHERE j.equipe.idEquipe = :idEquipe");
            query.setParameter("idEquipe", idEquipe);
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
        return joueurs;
    }

    public Equipe findByNom(String nomEquipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Equipe e WHERE e.nomEquipe = :nom");
            query.setParameter("nom", nomEquipe);
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
        if (equipes.size() > 1 ) {
            throw new RuntimeException("Doublon de nom pour ecurie alors que le nom est unique");
        } else if (equipes.size() == 0)  {
            return null;
        }
        return equipes.get(0);
    }

    // ici on assume que la liste déquipe est valide puisqu'elle est fournie par le formulaire equipe qui les contolentRe
    public void enregistrerEquipe(Equipe equipeAEnregistrer, List<Joueur> joueursAEnregistrer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(equipeAEnregistrer);
            for (Joueur j: joueursAEnregistrer) {
                j.setEquipe(equipeAEnregistrer);
                session.save(j);
            }
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
