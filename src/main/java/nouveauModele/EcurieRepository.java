package nouveauModele;

public class EcurieRepository {
    private static EcurieRepository instance;

    public static EcurieRepository getInstance() {
        if(instance == null) {
            instance = new EcurieRepository();
        }
        return instance;
    }

    public Ecurie findById(int idEcurie) {
        return new Ecurie();
    }

    public Ecurie findByName(String nomEcurie) {
        return new Ecurie();
    }
}
