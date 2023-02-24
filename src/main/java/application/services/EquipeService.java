package application.services;

import nouveauModele.EquipeRepository;
import presentation.Popup.PopupEquipe.PopupEquipe;

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
}
