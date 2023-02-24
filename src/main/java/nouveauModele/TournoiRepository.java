package nouveauModele;

public class TournoiRepository {

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

    public void save(Tournoi tournoiAInserer) {

    }
}
