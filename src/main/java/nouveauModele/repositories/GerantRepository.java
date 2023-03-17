package nouveauModele.repositories;

import nouveauModele.HibernateUtil;
import nouveauModele.dataRepresentation.Gerant;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GerantRepository {
    public static Gerant findById(int idGerant) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Gerant gerant = null;
        try {
            tx = session.beginTransaction();
            gerant = (Gerant) session.get(Gerant.class, idGerant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return gerant;
    }

    public static int findByLogs(String username, String password) {
        throw new UnsupportedOperationException("unimplemented");
    }
}
