package application.services;

import nouveauModele.Tournoi;
import nouveauModele.TournoiRepository;

//singleton
// préssente les Sf de l'application à présentation
public class TournoiService {
    private TournoiRepository repository;

    private TournoiService() {

    }

    public TournoiService getInstance() {
        return this;
    }
    public boolean verifierJeuTournoi(int idTournoi, int idJeu) {
        Tournoi tournoiAVerifier = repository.findById(idTournoi);
        return tournoiAVerifier.verifierJeuTournoi(idJeu);
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
