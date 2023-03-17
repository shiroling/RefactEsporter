package application.donneesPersistantes;

import application.filtres.Filtre;
import nouveauModele.dataRepresentation.*;
import nouveauModele.repositories.*;
import presentation.accueil.panelCartes.controleursCarte.ControleurCarte;
import presentation.accueil.panelCartes.vuesCartes.*;

import java.util.ArrayList;
import java.util.List;

public class ListeCourante {

    private static ListeCourante instance;
    private List<?> listeCourante;
    private Selection selectionCourante;

    private ListeCourante() {
        this.listeCourante = TournoiRepository.getInstance().getTournois();
        this.selectionCourante = Selection.TOURNOI;
    }

    public static ListeCourante getInstance() {
        if (instance == null) {
            instance = new ListeCourante();
        }
        return instance;
    }

    public List<?> getListeCourante() {
        return listeCourante;
    }
    public Selection getSelectionCourante() {
        return selectionCourante;
    }

    public void updateListeCourante(Selection s) {
        selectionCourante = s;
        switch (s)  {
            case ECURIE -> this.listeCourante = EcurieRepository.getInstance().getEcuries();
            case EQUIPE -> this.listeCourante = EquipeRepository.getInstance().getEquipes();
            case JEU -> this.listeCourante = JeuRepository.getInstance().getJeux();
            case RENCONTRE -> this.listeCourante = RencontreRepository.getInstance().getRencontres();
            case TOURNOI -> this.listeCourante = TournoiRepository.getInstance().getTournois();
        }
    }

    public List<?> getListeCouranteFiltree(Filtre filtre) {
        List<?> listeFiltre = filtre.filtrer(this.listeCourante);
        return listeFiltre;
    }

    public List<Carte> getListeEnCartes() {
        List<Carte> lc = new ArrayList<>();
        switch (selectionCourante) {
            case ECURIE -> {
                for (Ecurie e : (List<Ecurie>) listeCourante) {
                    lc.add(new CarteEcurie(e.getIdEcurie(), e.getNomEcurie(), EcurieRepository.getInstance().getPoints(e)));
                }
                return lc;
            }
            case EQUIPE -> {
                for (Equipe e : (List<Equipe>) listeCourante) {
                    lc.add(new CarteEquipe(e.getIdEquipe(), EquipeRepository.getInstance().getPoints(e), e.getNomEquipe()));
                }
                return lc;
            }
            case JEU -> {
                for (Jeu j : (List<Jeu>) listeCourante) {
                    lc.add(new CarteJeu(j.getIdJeu(), j.getNomJeu(), j.getLogo()));
                }
                return lc;
            }
            case RENCONTRE -> {
                RencontreRepository rp = RencontreRepository.getInstance();
                for (Rencontre r : (List<Rencontre>) listeCourante) {
                    List<Equipe> equipes = rp.getEquipes(r);
                    lc.add(new CarteRencontre(r.getIdRencontre(), r.getPoule().getFinale(), r.getPoule().getTournoi().getNom(), r.getDateRencontre(), equipes.get(0).getNomEquipe(), equipes.get(1).getNomEquipe(), equipes.indexOf(rp.getGagnant(r))));
                }
                return lc;
            }
            case TOURNOI -> {
                for (Tournoi t : (List<Tournoi>) listeCourante) {
                    lc.add(new CarteTournoi(t.getId(), t.getNom(), t.getDateDebutTournoi(), t.getDateFinTournoi()));
                }
                return lc;
            }
            default -> throw new RuntimeException("Unexpected value on switch statement");
        }

    }
}

