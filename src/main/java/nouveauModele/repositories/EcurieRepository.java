package nouveauModele.repositories;

import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Ecurie;
import nouveauModele.dataRepresentation.Equipe;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.net.SecureCacheResponse;
import java.util.List;

public class EcurieRepository {
    private static EcurieRepository instance;

    public static EcurieRepository getInstance() {
        if(instance == null) {
            instance = new EcurieRepository();
        }
        return instance;
    }

    public Ecurie findById(int idEcurie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Ecurie ecurie = null;
        try {
            tx = session.beginTransaction();
            ecurie = (Ecurie) session.get(Ecurie.class, idEcurie);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ecurie;
    }
    public Ecurie findByNom(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Ecurie> ecuries = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Ecurie e WHERE e.nomEcurie = :nom");
            query.setParameter("nom", nom);
            ecuries = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (ecuries.size() > 1 ) {
            throw new RuntimeException("Doublon de nom pour ecurie alors que le nom est unique");
        } else if (ecuries.size() == 0)  {
            return null;
        }
        return ecuries.get(0);
    }
    public List<Equipe> getEquipes(Ecurie ecurie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Equipe> equipes = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Equipe e WHERE e.ecurie.idEcurie = :idEcurie");
            query.setParameter("idEcurie", ecurie.getIdEcurie());
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

    public int getPoints(Ecurie ecurie) {
        List<Equipe> equipesACompter = EcurieRepository.getInstance().getEquipes(ecurie);
        int totalPoints = 0;
        for (Equipe e : equipesACompter) {
            totalPoints += EquipeRepository.getInstance().getPoints(e);
        }
        return totalPoints;
    }

    public List<Ecurie> getEcuries() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Ecurie> ecuries = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Ecurie e");
            ecuries = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ecuries;
    }
}
