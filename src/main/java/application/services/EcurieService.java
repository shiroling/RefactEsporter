package application.services;

import nouveauModele.dataRepresentation.Ecurie;
import nouveauModele.repositories.EcurieRepository;
import nouveauModele.dataRepresentation.Equipe;
import presentation.popup.PopupEcurie;

import java.util.List;
import java.util.stream.Collectors;

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

    public void afficherPopupEcurie(String nomEcurie) {
        int idEcurie = repository.findByNom(nomEcurie).getIdEcurie();
        afficherPopupEcurie(idEcurie);
    }

    public List<Equipe> getEquipes(int idEcurie) {
        return   repository.getEquipes(repository.findById(idEcurie));
    }

    public String[] getNomsEcuries() {

        List<String> nomsEquipes = repository.getEcuries().stream().map(tournoi -> tournoi.getNomEcurie()).collect(Collectors.toList());
        nomsEquipes.add(0, "Toutes");
        return nomsEquipes.toArray(new String[nomsEquipes.size()]);
    }
}
