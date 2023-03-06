package application.services;

import nouveauModele.dataRepresentation.Ecurie;
import nouveauModele.repositories.EcurieRepository;
import nouveauModele.dataRepresentation.Equipe;
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
        Ecurie ecurie = repository.findById(idEcurie);
        List<String> nomsJoueur = repository.getEquipes(ecurie).stream().map(Equipe::getNomEquipe).toList();
        PopupEcurie popupEcurie = new PopupEcurie(ecurie.getNomEcurie(), ecurie.getNomManager(), nomsJoueur);
        popupEcurie.setVisible(true);
    }

    public List<Equipe> getEquipes(int idEcurie) {
        return   repository.getEquipes(repository.findById(idEcurie));
    }
}
