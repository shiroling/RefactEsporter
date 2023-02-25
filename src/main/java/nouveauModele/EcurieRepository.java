package nouveauModele;

import org.hibernate.Session;
import org.hibernate.Transaction;

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


    public Ecurie findByName(String nomEcurie) {
        return new Ecurie();
    }
    
}
