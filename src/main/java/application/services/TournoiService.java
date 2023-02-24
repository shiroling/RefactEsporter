package application.services;

import application.donneesPersistantes.UtilisateurCourant;
import modele.BDPredicats;
import modele.Ecurie;
import modele.Equipe;
import nouveauModele.Tournoi;
import nouveauModele.TournoiRepository;

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

    public TournoiService getInstance() {
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

    public static void afficherPopupTournoi(modele.Tournoi tournoi) {
        PopupTournoi popupTournoi = new PopupTournoi(tournoi);
        popupTournoi.setVisible(true);
    }
    public boolean verifierJeuTournoi(int idTournoi, int idJeu) {
        Tournoi tournoiAVerifier = repository.findById(idTournoi);
        return tournoiAVerifier.verifierJeuTournoi(idJeu);
    }

    public void afficherPopupTournoi(int idTournoi) {
        //PopupTournoi popupTournoi = new PopupTournoi(repository.findById(idTournoi));
        //popupTournoi.setVisible(true);
    }

    /*public void creerNouveauTounoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, int idJeu, int idGerant) {
        Jeu jeuDuTournoiACreer = JeuRepository.findById(idJeu);
        Gerant gerantCreateurDuTournoi = GerantRepository.findById(idJeu);
        if (TournoiRepository.findByNom(nomTounoi) != null) {
            throw
        }
        Tournoi tournoiAInserer = new Tournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, jeuDuTournoiACreer, gerantCreateurDuTournoi);
        repository.save(tournoiAInserer);
    }*/

}
