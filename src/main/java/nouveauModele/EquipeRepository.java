package nouveauModele;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EquipeRepository {
    private static EquipeRepository instance;

    public static EquipeRepository getInstance() {
        if(instance == null) {
            instance = new EquipeRepository();
        }
        return instance;
    }

    public Equipe findById(int idEquipe) {
        return new Equipe();
    }

    public Equipe findByName(String nomEquipe) {
        return new Equipe();
    }

    public List<Integer> getListeIdsEquipesFromIdEcurie(int idEcurie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            //transaction = session.beginTransaction();

            Query query = session.createQuery("select equipe.id from Equipe equipe where equipe.ecurie.id = :idEcurie");
            query.setParameter("idEcurie", idEcurie);

            List<Integer> idsEquipes = query.list();

            //transaction.commit();
            return idsEquipes;

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
}
