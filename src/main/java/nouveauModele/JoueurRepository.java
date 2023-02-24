package nouveauModele;

public class JoueurRepository {

    private static JoueurRepository instance;

    public static JoueurRepository getInstance() {
        if(instance == null) {
            instance = new JoueurRepository();
        }
        return instance;
    }
    public Joueur findByPseudo(String pseudoJoueur) {
        return new Joueur();
    }
}
