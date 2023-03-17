package modele.repositories;


import modele.HibernateUtil;
import modele.dataRepresentation.Jouer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class JouerRepository {

    private static JouerRepository instance;

    private JouerRepository() {}

    public static JouerRepository getInstance() {
        if(instance == null) {
            instance = new JouerRepository();
        }
        return instance;
    }

    public Jouer findByIdRencontreIdEquipe(int idRencontre, int idEquipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Jouer> jouerList = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Jouer j WHERE j.id.rencontre.idRencontre = :idRencontre AND j.id.equipe.idEquipe = :idEquipe");
            query.setParameter("idRencontre", idRencontre);
            query.setParameter("idEquipe", idEquipe);
            jouerList = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (jouerList.size() > 1 ) {
            throw new RuntimeException("Doublon de jouer alors qu'il est unique");
        } else if (jouerList.isEmpty())  {
            return null;
        }
        return jouerList.get(0);
    }
}
