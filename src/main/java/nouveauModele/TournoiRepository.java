package nouveauModele;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TournoiRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static TournoiRepository instance;

    public static TournoiRepository getInstance() {
        if(instance == null) {
            instance = new TournoiRepository();
        }
        return instance;
    }
    public Tournoi findById(int idTournoi) {
        return null;
    }

    public void save(Tournoi nouveauTournoi) {
        entityManager.getTransaction().begin();
        entityManager.persist(nouveauTournoi);
        entityManager.getTransaction().commit();
    }

    public Tournoi getTournoiById(int id_tournoi) {
        return entityManager.find(Tournoi.class, id_tournoi);
    }
}
