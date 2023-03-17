package application.filtres;

import application.services.RencontreService;
import modele.dataRepresentation.Equipe;
import modele.dataRepresentation.Jeu;
import modele.dataRepresentation.Rencontre;
import modele.dataRepresentation.Tournoi;

import java.time.LocalDate;
import java.util.List;

public class FiltresRencontre extends AbstractFilre implements Filtre{
    private Filtre<Rencontre> filtre;


    @Override
    public List filtrer(List listeRencontre) {
        this.filtre.filtrer(listeRencontre);
        return super.filtrer(listeRencontre);
    }

    public void setNext(Filtre filtre) {
        super.setNext(filtre);
    }

    public FiltresRencontre(Filtre<Rencontre> filtre) {
        this.filtre = filtre;
    }

    public static FiltresRencontre getFiltreJeu(Jeu jeu) {
        return new FiltresRencontre(
                listeRencontre -> {
                    listeRencontre.removeIf(r ->r.getPoule().getTournoi().getJeu() != jeu);
                    return listeRencontre;
                }
        );
    }
    public static FiltresRencontre getFiltreRencontreFinie() {
        return new FiltresRencontre(
                listeRencontre -> {
                listeRencontre.removeIf(r ->r.getDateRencontre().isAfter(LocalDate.now()));
                return listeRencontre;
            }
        );
    }
    public static FiltresRencontre getFiltreRencontreAVenir() {
        return new FiltresRencontre(
                listeRencontre -> {
                listeRencontre.removeIf(r ->r.getDateRencontre().isBefore(LocalDate.now()));
                return listeRencontre;
            }
        );
    }

    public static FiltresRencontre getFiltreParTournoi(Tournoi tournoi) {
        return new FiltresRencontre(
                listeRencontre -> {
            listeRencontre.removeIf(r ->r.getPoule().getTournoi().getId() != tournoi.getId());
            return listeRencontre;
        }
        );
    }

    public static Filtre<Rencontre> getFiltreParEquipe(Equipe equipe) {
        return new FiltresRencontre(
                listeRencontre ->  {
            listeRencontre.removeIf(r -> !RencontreService.getInstance().getEquipesParticipantes(r.getIdRencontre()).contains(equipe));
            return listeRencontre;
        }
        );
    }
}
