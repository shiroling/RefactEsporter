package application.services;

import nouveauModele.JoueurRepository;

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
        PopupJoueur popupJoueur = new PopupJoueur(repository.findByPseudo(pseudoJoueur));
        popupJoueur.setVisible(true);
    }
}
