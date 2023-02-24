package nouveauModele;

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
}
