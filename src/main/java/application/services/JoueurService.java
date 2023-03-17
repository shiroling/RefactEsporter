package application.services;

import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.dataRepresentation.Joueur;
import nouveauModele.repositories.EquipeRepository;
import nouveauModele.repositories.JoueurRepository;
import presentation.Popup.PopupJoueur.PopupJoueur;

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

    public void afficherPopupJoueur(int idJoueur) {
        Joueur joueur = repository.findById(idJoueur);
        PopupJoueur popupJoueur = new PopupJoueur(joueur.getPrenom(), joueur.getPseudo(), joueur.getNom(), joueur.getDateDeNaissance().toString(), joueur.getEquipe().getEcurie().getNomEcurie(), joueur.getEquipe().getNomEquipe());
        popupJoueur.setVisible(true);
    }

    public void afficherPopupJoueur(String pseudoJoueur) {
        int idJoueur = repository.findByPseudo(pseudoJoueur).getIdJoueur();
        afficherPopupJoueur(idJoueur);
    }


    // Ici on admet que la date est dans la passé, ceci est testé dans le controleur du formulaire joueur
    public boolean estValideJoueur(String nom, String prenom, String pseudo, LocalDate dateDeNaissance, int idEquipe) {
        Equipe equipeEnCharge = EquipeRepository.getInstance().findById(idEquipe);
        return JoueurRepository.getInstance().findByPseudo(pseudo) != null && equipeEnCharge == null;
    }
}
