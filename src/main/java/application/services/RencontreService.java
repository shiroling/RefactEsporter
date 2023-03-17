package application.services;

import nouveauModele.dataRepresentation.*;
import nouveauModele.repositories.EquipeRepository;
import nouveauModele.repositories.RencontreRepository;
import presentation.popup.popupIndiquerVainqueur.PopupIndiquerVainqueur;
import presentation.popup.popupRencontre.PopupRencontre;

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

    public void afficherPopupRencontre(int idRencontre) {
        Rencontre rencontre = repository.findById(idRencontre);
        String nomEquipe1 = repository.getEquipes(rencontre).get(0).getNomEquipe();
        String nomEquipe2 = repository.getEquipes(rencontre).get(1).getNomEquipe();
        String nomTournoi = rencontre.getPoule().getTournoi().getNom();
        String dateRencontre = rencontre.getDateRencontre().toString();
        List<String> pseudosJoueursEquipe1 = EquipeRepository.getInstance().getJoueursFromNomEquipe(nomEquipe1).stream().map(Joueur::getPseudo).toList();
        List<String> pseudosJoueursEquipe2 = EquipeRepository.getInstance().getJoueursFromNomEquipe(nomEquipe2).stream().map(Joueur::getPseudo).toList();
        String nomArbitre = rencontre.getArbitre().getNom();
        int statutRencontre = getStatutRencontre(rencontre, nomEquipe1);
        PopupRencontre popupRencontre = new PopupRencontre(idRencontre, nomEquipe1, nomEquipe2, nomTournoi, dateRencontre, statutRencontre, pseudosJoueursEquipe1, pseudosJoueursEquipe2, nomArbitre);
        popupRencontre.setVisible(true);
    }

    private int getStatutRencontre(Rencontre rencontre, String nomEquipe1) {
        int statutRencontre;
        if(repository.estResultatRenseigne(rencontre)) {
            if(repository.getGagnant(rencontre).getNomEquipe().equals(nomEquipe1)) {
                statutRencontre = 1;
            } else {
                statutRencontre = 2;
            }
        } else {
            statutRencontre = 0;
        }
        return statutRencontre;
    }

    public List<Equipe> getEquipesParticipantes(int idRencontre) { return repository.getEquipes(repository.findById(idRencontre)); }
    public Rencontre getRencontreFromId(int idRencontre) {
        return repository.findById(idRencontre);
    }

    public boolean estResultatRenseigne(int idRencontre) {
        Rencontre rencontre = repository.findById(idRencontre);
        if (rencontre == null) {
            throw new IllegalArgumentException("la rencontre renseigné n'existe pas ");
        }
        return repository.estResultatRenseigne(rencontre);
    }

    public void afficherIndiquerVainqueur(int idRencontre) {
        Rencontre rencontre = repository.findById(idRencontre);
        String nomEquipe1 = repository.getEquipes(rencontre).get(0).getNomEquipe();
        String nomEquipe2 = repository.getEquipes(rencontre).get(1).getNomEquipe();
        PopupIndiquerVainqueur fen = new PopupIndiquerVainqueur(nomEquipe1, nomEquipe2, idRencontre);
        fen.setVisible(true);
    }

    public void designerVainqueur(String nomEquipeVainqueur, int idRencontre) {
        Equipe equipe = EquipeRepository.getInstance().findByNom(nomEquipeVainqueur);
        Rencontre rencontre = repository.findById(idRencontre);
        repository.setVainqueur(equipe, rencontre);
    }
}
