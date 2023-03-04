package application.services;

import nouveauModele.dataRepresentation.Ecurie;
import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.dataRepresentation.Jeu;
import nouveauModele.dataRepresentation.Joueur;
import nouveauModele.repositories.EcurieRepository;
import nouveauModele.repositories.EquipeRepository;
import nouveauModele.repositories.JeuRepository;

import java.time.Duration;
import java.time.LocalDate;
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

    public List<Joueur> getJoueurs(int idEquipe) {
        Equipe equipe = repository.findById(idEquipe);
        if (equipe ==  null ) {throw new RuntimeException("L'equipe n'existe pas");}
        return repository.getJoueurs(equipe);
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
        List<Joueur> listeJoueurs = repository.getJoueurs(equipeTemp);
        if (listeJoueurs.size() != 4) {
            throw new RuntimeException("Il n'y a pas assez de joueurs et");
        }
        float ageMoyen = 0;
        for (Joueur j : listeJoueurs) {
            Duration d = Duration.between(LocalDate.now(), j.getDateDeNaissance());
            ageMoyen += Math.abs(d.toMinutes());
        }
        return ageMoyen/4;
    }
}
