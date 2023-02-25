package application.services;

import nouveauModele.Ecurie;
import nouveauModele.EcurieRepository;
import nouveauModele.Equipe;
import presentation.Popup.PopupEcurie.PopupEcurie;

import java.util.List;

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

    public void afficherPopupEcurie(int idEcurie) {
        PopupEcurie popupEcurie = new PopupEcurie(idEcurie);
        popupEcurie.setVisible(true);
    }

    public List<Equipe> getEquipes(int id_Ecurie) {
        Ecurie e = repository.findById(id_Ecurie);
        return null;
    }

    public Ecurie getEcurieFromId(int idEcurie) {
        return repository.findById(idEcurie);
    }

}
