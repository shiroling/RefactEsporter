package application.services;

import nouveauModele.EcurieRepository;
import nouveauModele.EquipeRepository;
import presentation.Popup.PopupEquipe.PopupEquipe;

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

    public List<Integer> getListIdEquipesFromIdEcurie(int idEcurie) {
         return EquipeRepository.getInstance().getListeIdsEquipesFromIdEcurie(idEcurie);

    }
}
