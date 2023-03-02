package application.services;

import nouveauModele.*;

import java.util.List;

public class EquipeService {
    private static EquipeService instance;
    private EquipeRepository repository;

    private EquipeService() {
        repository = EquipeRepository.getInstance();
    }

    public static EquipeService getInstance() {
        if(instance == null) {
            instance = new EquipeService();
        }
        return instance;
    }

    public void afficherPopupEquipe(String nomEquipe) {
        //PopupEquipe popupEquipe = new PopupEquipe(repository.findByName(nomEquipe));
        //popupEquipe.setVisible(true);
    }

    public String getNomFromId(int idEquipe) {
        return EquipeRepository.getInstance().findById(idEquipe).getNomEquipe();
    }

    public List<Joueur> getJoueurs(int id_Equipe) {
        return repository.getJoueurs(id_Equipe);
    }

    public void enregistrerNouvelleEquipe(String nomEquipe, int idJeu, int idEcurie, List<Joueur> joueurAEnregistrer) {
        if (estPrisNomEquipe(nomEquipe)) {
            throw new IllegalArgumentException("Le nom de l'equipe est déja pris");
        }
        Jeu jeuJoue = JeuRepository.getInstance().findById(idJeu);
        if (jeuJoue == null) {throw new IllegalArgumentException("Le jeu n'existe pas");}
        Ecurie ecurieEnCharge = EcurieRepository.getInstance().findById(idEcurie);
        if (ecurieEnCharge == null) {throw new IllegalArgumentException("L'écurie n'existe pas");}
        Equipe equipeAEnregistrer = new Equipe(nomEquipe, ecurieEnCharge, jeuJoue);
        EquipeRepository.getInstance().enregistrerEquipe(equipeAEnregistrer, joueurAEnregistrer);
    }

    private boolean estPrisNomEquipe(String nomEquipe) {
        return EquipeRepository.getInstance().findByNom(nomEquipe) != null;
    }

    public float getPoints() {
        // TODO et giga important
        return -6969;
    }

    public float getAgeMoyen(Equipe equipeTemp) {
        // TODO et giga important
        return -6969;
    }
}
