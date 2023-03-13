package application.services;

import application.donneesPersistantes.Portee;
import application.donneesPersistantes.UtilisateurCourant;
import modele.BDPredicats;

import nouveauModele.dataRepresentation.*;
import nouveauModele.repositories.*;
import presentation.Popup.PopupInscrireEquipe.PopupInscrireEquipe;

import presentation.Popup.PopupTournoi.PopupTournoi;
import presentation.formCreerTournoi.VueFormCreerTournoi;

import java.time.LocalDate;
import java.util.HashMap;
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

    public void afficherFormCreerTournoi() {
        int idGerant = UtilisateurCourant.getInstance().getIdLog();
        List<String> nomsJeuxDisponible = JeuService.getInstance().getNomsJeuDisponibles();
        VueFormCreerTournoi fen = new VueFormCreerTournoi(idGerant, nomsJeuxDisponible);
        fen.setVisible(true);
    }

    public int getNbParticipants(int idTournoi) {
        return this.getEquipesInscrites(idTournoi).size();
    }

    public void enregistrerNouveauTournoiMultigaming(String nomTounoi, Portee porteeTournoi, LocalDate dateFinInscription, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, List<Integer> ListeDeJeux, int idGerant) {
        for (Integer idJeu: ListeDeJeux) {
            Jeu jeuJoue = JeuRepository.getInstance().findById(idJeu);
            enregistrerNouveauTournoi(nomTounoi + " - " + jeuJoue.getNomJeu(), porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, idJeu.intValue(), idGerant);
        }
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

    public void enregistrerNouveauTournoi2(String nomTounoi, Portee porteeTournoi, LocalDate dateFinInscription, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, int idJeu, int idGerant) {
        if (dateFinInscription == null || dateDebutTournoi == null || dateFinTournoi == null) {
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
            throw new IllegalArgumentException("le tournoi existe déjà");
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

    public List<Poule> getAllPoules(int idTournoi) {
        Tournoi tournoiAvecPoules = getTournoiExistant(idTournoi);

        return TournoiRepository.getInstance().getAllPoules(tournoiAvecPoules);
    }

    private static Tournoi getTournoiExistant(int idTournoi) {
        Tournoi tournoiAvecPoules = TournoiRepository.getInstance().findById(idTournoi);
        if (tournoiAvecPoules == null) {
            throw new IllegalArgumentException("Le tournoi n'existe pas");
        }
        return tournoiAvecPoules;
    }

    public Poule getPouleFinale(int idTournoi) {
        Tournoi tournoiAvecPoules = TournoiService.getTournoiExistant(idTournoi);
        return TournoiRepository.getInstance().getPouleFinale(tournoiAvecPoules);

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

    private boolean estTournoiEnCours(Tournoi tournoi) {
        return tournoi.getDateFinTournoi().isAfter(LocalDate.now());
    }

    private boolean estTournoiCommence(Tournoi tournoi) {
        return tournoi.getDateDebutTournoi().isBefore(LocalDate.now());
    }

    private boolean estPhaseInsciptionPassee(Tournoi tournoi) {
        return tournoi.getDateFinInscriptions().isBefore(LocalDate.now());
    }


    public int getClassementInPoule(Equipe equipe, Tournoi tournoi) {
        if (equipe ==  null) { throw new IllegalArgumentException("l'equipe n'existe pas ");}
        if (tournoi ==  null) { throw new IllegalArgumentException("le tournoi n'existe pas ");}
        HashMap<Equipe, Integer> mapGagnantRencontes = new HashMap<>();
        for (Equipe e : repository.getEquipesInscrites(tournoi)) {
            mapGagnantRencontes.put(e, 0);
        }
        List<Rencontre> rencontresFinales = PouleRepository.getInstance().getRencontres(TournoiService.getInstance().getPouleFinale(tournoi.getId())); // on obtient les rencontres finales
        for (Rencontre r : rencontresFinales) {
            Equipe equipeGagnante = RencontreRepository.getInstance().getGagnant(r);
            mapGagnantRencontes.put(
                    equipeGagnante,
                    mapGagnantRencontes.get(equipeGagnante) + 1
            );
        }
        int classement = 1;
        int scoreEquipeAClasser = mapGagnantRencontes.get(equipe);
        for (Equipe e : mapGagnantRencontes.keySet()) {
            System.out.println("Comparaison entre : " + e.getNomEquipe() + "=" +mapGagnantRencontes.get(e) + "et"+ equipe.getNomEquipe() + "=" +mapGagnantRencontes.get(equipe));
            if (mapGagnantRencontes.get(e) > scoreEquipeAClasser) {
                System.out.println("pouet");
                classement +=1;
            }
        }
        System.out.println("Maps de winners end : " +  mapGagnantRencontes);

        return classement;


    }
}
