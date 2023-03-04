package application.services;

import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.repositories.EquipeRepository;
import nouveauModele.repositories.JoueurRepository;

import java.time.LocalDate;

public class JoueurService {

    private static JoueurService instance;
    private JoueurRepository repository;
    private JoueurService() {
        repository = JoueurRepository.getInstance();
    }

    public static JoueurService getInstance() {
        if(instance == null) {
            instance = new JoueurService();
        }
        return instance;
    }

    public void afficherPopupJoueur(String pseudoJoueur) {
        //PopupJoueur popupJoueur = new PopupJoueur(repository.findByPseudo(pseudoJoueur));
        //popupJoueur.setVisible(true);
    }

    // Ici on admet que la date est dans la passé, ceci est testé dans le controleur du formulaire joueur
    public boolean estValideJoueur(String nom, String prenom, String pseudo, LocalDate dateDeNaissance, int idEquipe) {
        Equipe equipeEnCharge = EquipeRepository.getInstance().findById(idEquipe);
        return JoueurRepository.getInstance().findByPseudo(pseudo) != null && equipeEnCharge == null;
    }
}
