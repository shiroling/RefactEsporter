package application.services;

import nouveauModele.*;

import java.util.List;

public class RencontreService {
    private static RencontreService instance;
    private RencontreRepository repository;

    private RencontreService() {
        repository = RencontreRepository.getInstance();
    }

    public static RencontreService getInstance() {
        if(instance == null) {
            instance = new RencontreService();
        }
        return instance;
    }

    public void afficherPopupRencontre(Rencontre rencontre) {

    }
    public List<Equipe> getEquipesParticipantes(int idRencontre) {
        return   repository.getEquipes(idRencontre);
    }
    public Rencontre getRencontreFromId(int idRencontre) {
        return repository.findById(idRencontre);
    }

    public boolean estResultatRenseigne(int idRencontre) {
        Rencontre rencontre = repository.findById(idRencontre);
        if (rencontre == null) {
            throw new IllegalArgumentException("la rencontre renseigné n'existe pas ");
        }
        return repository.getInstance().estResultatRenseigne(rencontre);
    }

}
