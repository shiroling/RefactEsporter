package application.services;

import modele.Ecurie;
import nouveauModele.EcurieRepository;
import presentation.Popup.PopupEcurie.PopupEcurie;

public class EcurieService {

    private static EcurieService instance;
    private EcurieRepository repository;

    private EcurieService() {
        repository = EcurieRepository.getInstance();
    }

    public static EcurieService getInstance() {
        if(instance == null) {
            instance = new EcurieService();
        }
        return instance;
    }

    public void afficherPopupEcurie(String nomEcurie) {
        PopupEcurie popupEcurie = new PopupEcurie(repository.findByName(nomEcurie));
        popupEcurie.setVisible(true);
    }
}
