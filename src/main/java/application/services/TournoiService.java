package application.services;

import application.donneesPersistantes.Portee;
import application.donneesPersistantes.UtilisateurCourant;
import modele.BDPredicats;
import modele.Ecurie;
import nouveauModele.*;

import presentation.Popup.PopupInscrireEquipe.PopupInscrireEquipe;

import presentation.Popup.PopupTournoi.PopupTournoi;

import java.time.LocalDate;
import java.util.List;

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

    public void inscrireEquipeATournoi(int idEquipeAInscrire, int idTournoi) {
        Equipe equipeAInscrire = EquipeRepository.getInstance().findById(idEquipeAInscrire);
        Tournoi tournoiHote = TournoiRepository.getInstance().findById(idTournoi);
        if(!estInscrivableEquipeATournoi(equipeAInscrire, tournoiHote)) {
            throw new RuntimeException("L'equipe n'est pas inscrivable");
        }
        TournoiRepository.getInstance().inscrireEquipeATournoi(equipeAInscrire, tournoiHote);
    }

    public boolean estInscrivableEquipeATournoi(Equipe equipeAInscrire, Tournoi tournoiHote) {
        if (equipeAInscrire == null || tournoiHote == null) {
            return false;
        }
        if (isFull(tournoiHote)) {
            return false;
        }
        if (TournoiRepository.getInstance().estEquipeInscrite(equipeAInscrire, tournoiHote)) {
            return  false;
        };
        return true;
    }

    public boolean isFull(Tournoi tournoiHote) {
        return TournoiRepository.getInstance().getEquipesInscrites(tournoiHote).size() >= 16;
    }
    public void procedureInitierInscrireEquipe(modele.Tournoi tournoi) {
        PopupInscrireEquipe popupInscrireEquipe = new PopupInscrireEquipe(new Ecurie(UtilisateurCourant.getInstance().getIdLog()), tournoi);
        popupInscrireEquipe.setVisible(true);
    }

    public List<Equipe> getEquipesInscrites(int idTournoi) {
        Tournoi tournoi = repository.findById(idTournoi);
        if (tournoi == null) { throw new IllegalArgumentException("le tournoi n'existe pas ");}
        return repository.getEquipesInscrites(tournoi);

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
    public void enregistrerNouveauTournoiMultigaming(String nomTounoi, Portee porteeTournoi, LocalDate dateFinInscription, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, List<Integer> ListeDeJeux, int idGerant) {
        for (Integer idJeu: ListeDeJeux) {
            Jeu jeuJoue = JeuRepository.getInstance().findById(idJeu);
            enregistrerNouveauTournoi(nomTounoi + " - " + jeuJoue.getNomJeu(), porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, idJeu.intValue(), idGerant);
        }
    }

    public void enregistrerNouveauTournoi(String nomTounoi, Portee porteeTournoi, LocalDate dateFinInscription, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, int idJeu, int idGerant) {
        Jeu jeuDuTournoiACreer = JeuRepository.getInstance().findById(idJeu);
        Gerant gerantCreateurDuTournoi = GerantRepository.findById(idJeu);
        if (TournoiRepository.getInstance().findByNom(nomTounoi) != null) {
            throw new IllegalArgumentException("le tournoi existe déja");
        }
        Tournoi tournoiAEnregistrer = new Tournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, jeuDuTournoiACreer, gerantCreateurDuTournoi);
        repository.enregistrerNouveauTournoi(tournoiAEnregistrer);
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

    public boolean estTournoiMultigaming(int idTournoi) {
        Tournoi tournoiATester = repository.findById(idTournoi);
        return tournoiATester.getNom().contains(" - ");    }

    public boolean verifierJeuTournoi(int idTournoi, int idJeu) {
        Tournoi tournoiAVerifier = this.repository.findById(idTournoi);
        return tournoiAVerifier.verifierJeuTournoi(idJeu);
    }

}
