package application.services;

import application.donneesPersistantes.Portee;

import modele.dataRepresentation.*;
import modele.repositories.*;
import presentation.popup.popupInscrireEquipe.PopupInscrireEquipe;

import presentation.popup.popupTournoi.PopupTournoi;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static boolean isValidNom(String text) {
        return TournoiRepository.getInstance().findByNom(text) != null;
    }

    public void inscrireEquipe(int idEquipeAInscrire, int idTournoi) {
        Equipe equipeAInscrire = EquipeRepository.getInstance().findById(idEquipeAInscrire);
        Tournoi tournoiHote = TournoiRepository.getInstance().findById(idTournoi);
        if(!estInscrivableEquipeATournoi(equipeAInscrire, tournoiHote)) {
            throw new RuntimeException("L'equipe n'est pas inscrivable");
        }
        TournoiRepository.getInstance().inscrireEquipeATournoi(equipeAInscrire, tournoiHote);
        if (getEtatTournoi(tournoiHote) ==  EtatTournoi.COMPLET)
            procedureTournoiComplet(tournoiHote); // création/peuplage des poules et rencontres

    }

    private void procedureTournoiComplet(Tournoi tournoiHote) {
        // Creation et peuplage des poules
        System.out.print("Creation des poules...");
        PouleRepository.getInstance().creerPoules(tournoiHote.getId());
        System.out.println("OK");
        List<Poule> poulesCreationRencontres = repository.getPoulesClassiques(tournoiHote);
        System.out.println("Creation et peuplage des poules : ");
        for (Poule p : poulesCreationRencontres) {
            System.out.print(p + " ...");
            RencontreRepository.getInstance().creerPeuplerRencontres(p);
            System.out.println("OK");
        }

    }

    public boolean estInscrivableEquipeATournoi(Equipe equipeAInscrire, Tournoi tournoiHote) {
        if (equipeAInscrire == null || tournoiHote == null) {
            System.out.println("blop");
            return false;
        }
        if (getEtatTournoi(tournoiHote) != EtatTournoi.INSCRIPTIONS) {
            System.out.println("blip");
            return false;
        }
        if (TournoiRepository.getInstance().estEquipeInscrite(equipeAInscrire, tournoiHote)) {
            System.out.println("blap");
            return  false;
        };
        return true;
    }

    public int getIdTournoiFromNom(String nomTournoi) {
        return repository.findByNom(nomTournoi).getId();
    }
    public boolean isFull(Tournoi tournoiHote) {
        return TournoiRepository.getInstance().getEquipesInscrites(tournoiHote).size() >= 16;
    }

    public void afficherPopupInscrireEquipe(int idTournoi, int idEcurie) {
        Tournoi tournoi = repository.findById(idTournoi);
        Ecurie ecurie = EcurieRepository.getInstance().findById(idEcurie);
        List<String> nomsEquipesPouvantSInscrire = EcurieRepository.getInstance().getEquipes(ecurie).stream().filter(e -> e.getJeu().getIdJeu() == tournoi.getJeu().getIdJeu()).filter(e -> !repository.estEquipeInscrite(e, tournoi)).map(Equipe::getNomEquipe).toList();
        PopupInscrireEquipe popupInscrireEquipe = new PopupInscrireEquipe(nomsEquipesPouvantSInscrire, tournoi.getNom());
        popupInscrireEquipe.setVisible(true);
    }

    public List<Equipe> getEquipesInscrites(int idTournoi) {
        Tournoi tournoi = repository.findById(idTournoi);
        if (tournoi == null) { throw new IllegalArgumentException("le tournoi n'existe pas ");}
        return repository.getEquipesInscrites(tournoi);
    }

    public void afficherPopupTournoi(int idTournoi) {
        Tournoi tournoi = repository.findById(idTournoi);
        String nomTournoi = tournoi.getNom();
        String dateDebut = tournoi.getDateDebutTournoi().toString();
        String dateFin = tournoi.getDateFinTournoi().toString();
        String dateFinIscription = tournoi.getDateFinInscriptions().toString();
        boolean isFini = this.getEtatTournoi(tournoi).equals(EtatTournoi.FINI);
        boolean isPlein = this.isFull(tournoi);
        List<String> nomsEquipesParticipantes = repository.getEquipesInscrites(tournoi).stream().map(Equipe::getNomEquipe).toList();
        PopupTournoi popupTournoi = new PopupTournoi(nomTournoi, dateDebut, dateFin, dateFinIscription, isFini, isPlein, nomsEquipesParticipantes);
        popupTournoi.setVisible(true);
    }

    public void afficherPopupTournoi(String nomTournoi) {
        int idTournoi = repository.findByNom(nomTournoi).getId();
        afficherPopupTournoi(idTournoi);
    }


    public int getNbParticipants(int idTournoi) {
        return this.getEquipesInscrites(idTournoi).size();
    }


    public void enregistrerNouveauTournoi(String nomTounoi, Portee porteeTournoi, LocalDate dateFinInscription, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, int idJeu, int idGerant) {
        if (dateFinInscription == null ||dateDebutTournoi == null || dateFinTournoi ==  null) {
            throw new IllegalArgumentException("une date est nulle :" + dateFinInscription + dateDebutTournoi + dateFinTournoi);
        }
        Jeu jeuDuTournoiACreer = JeuRepository.getInstance().findById(idJeu);
        if (jeuDuTournoiACreer == null) {
            throw new RuntimeException("le jeu n'existe pas");
        }
        Gerant gerantCreateurDuTournoi = GerantRepository.findById(idGerant);
        if (gerantCreateurDuTournoi == null) {
            throw new RuntimeException("le gérant n'existe pas");
        }
        if (TournoiRepository.getInstance().findByNom(nomTounoi) != null) {
            throw new IllegalArgumentException("le tournoi existe déja");
        }
        Tournoi tournoiAEnregistrer = new Tournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, jeuDuTournoiACreer, gerantCreateurDuTournoi);
        repository.enregistrerNouveauTournoi(tournoiAEnregistrer);
    }

    public EtatTournoi getEtatTournoi(Tournoi tournoi) {
        if(getNbParticipants(tournoi.getId()) < 16) {
            if(estPhaseInsciptionPassee(tournoi)) {
                return EtatTournoi.MORT; // puisqu'il ne seras jamais pleins
            }
            return EtatTournoi.INSCRIPTIONS;
        }

        if (!estTournoiCommence(tournoi)) {
            return EtatTournoi.COMPLET;
        }

        return getPhase(tournoi);

    }

    private EtatTournoi getPhase(Tournoi tournoi) {
        List<Poule> lp = repository.getPoulesClassiques(tournoi);
        if (lp == null) {
            throw new RuntimeException("tournoi non généré");
        }
        for (Poule p : lp) {
            if(PouleService.getInstance().getResultat(p) == null)
                return EtatTournoi.PHASE_POULES;
        }
        if (PouleService.getInstance().getResultat(repository.getPouleFinale(tournoi))== null) {
            return EtatTournoi.PHASE_FINALES;
        }

        return  EtatTournoi.FINI;
    }

    private boolean estTournoiCommence(Tournoi tournoi) {
        return tournoi.getDateDebutTournoi().isBefore(LocalDate.now());
    }

    private boolean estPhaseInsciptionPassee(Tournoi tournoi) {
        return tournoi.getDateFinInscriptions().isBefore(LocalDate.now());
    }

    public String[] getNomsTournois() {
        List<String> nomsTournois = repository.getTournois().stream().map(tournoi -> tournoi.getNom()).collect(Collectors.toList());
        nomsTournois.add(0, "Tous");
        return nomsTournois.toArray(new String[nomsTournois.size()]);
    }
}
