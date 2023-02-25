package application.services;

import application.donneesPersistantes.Portee;
import application.donneesPersistantes.UtilisateurCourant;
import modele.BDPredicats;
import modele.BDSelect;
import modele.Ecurie;
import modele.Equipe;
import nouveauModele.*;

import presentation.Popup.PopupInscrireEquipe.PopupInscrireEquipe;

import presentation.Popup.PopupTournoi.PopupTournoi;

import java.time.LocalDate;

//singleton
// préssente les Sf de l'application à présentation
public class TournoiService {
    private static TournoiService instance;
    private TournoiRepository repository;

    private TournoiService() {
        repository = TournoiRepository.getInstance();
    }

    public static TournoiService getInstance() {
        if(instance == null) {
            instance = new TournoiService();
        }
        return instance;
    }

    public static void procedureInscrireEquipe(Equipe equipeAInscrire, Tournoi nouveauTournoi) {
        if(estTournoiValide(nouveauTournoi))
        TournoiRepository.getInstance().save(nouveauTournoi);

    }

    private static boolean estTournoiValide(Tournoi nouveauTournoi) {
        return nouveauTournoi.getDateFinInscriptions().isBefore(LocalDate.now())
                && nouveauTournoi.getDateDebutTournoi().isBefore(LocalDate.now())
                && nouveauTournoi.getDateFinTournoi().isBefore(LocalDate.now())
                && isValidNom(nouveauTournoi.getNom());
    }

    public static boolean isValidNom(String nomTounoi) {
        return BDPredicats.estLibreNomTournoi(nomTounoi);
    }


    public static void procedureInitierInscrireEquipe(modele.Tournoi tournoi) {
        PopupInscrireEquipe popupInscrireEquipe = new PopupInscrireEquipe(new Ecurie(UtilisateurCourant.getInstance().getIdLog()), tournoi);
        popupInscrireEquipe.setVisible(true);
    }

    public void afficherPopupTournoi(int id_tournoi) {
        //PopupTournoi popupTournoi = new PopupTournoi(repository.getTournoiById(id_tournoi));
        PopupTournoi popupTournoi = new PopupTournoi(new modele.Tournoi(id_tournoi));
        popupTournoi.setVisible(true);
    }
/*      In finae ca deverais étre ça !
    public void afficherPopupTournoi(int id_tournoi) {
        PopupTournoi popupTournoi = new PopupTournoi(repository.getTournoiById(id_tournoi));
        popupTournoi.setVisible(true);
    }
 */


    public boolean verifierJeuTournoi(int idTournoi, int idJeu) {
        Tournoi tournoiAVerifier = this.repository.findById(idTournoi);
        return tournoiAVerifier.verifierJeuTournoi(idJeu);
    }



    public void enregistrerNouveauTounoi(String nomTounoi, Portee porteeTournoi, LocalDate dateFinInscription, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, int idJeu, int idGerant) {
        Jeu jeuDuTournoiACreer = JeuRepository.findById(idJeu);
        Gerant gerantCreateurDuTournoi = GerantRepository.findById(idJeu);
        if (TournoiRepository.getInstance().findByNom(nomTounoi) != null) {
            throw new IllegalArgumentException("le tournoi existe déja");
        }
        Tournoi tournoiAInserer = new Tournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, jeuDuTournoiACreer, gerantCreateurDuTournoi);
        repository.save(tournoiAInserer);
    }

}
