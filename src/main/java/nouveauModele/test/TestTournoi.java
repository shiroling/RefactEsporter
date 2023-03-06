package nouveauModele.test;
import application.donneesPersistantes.Portee;
import application.services.PouleService;
import application.services.TournoiService;
import nouveauModele.*;

import java.time.LocalDate;
import java.util.List;

public class TestTournoi {
    public static void main(String[] args) {
        /*
        // obtention par id
        Tournoi t = TournoiRepository.getInstance().findById(338);
        System.out.println(t);

        // obtention des equipes
        List<Equipe> le = TournoiService.getInstance().getEquipesInscrites(t.getId());
        for (Equipe e : le ) {
            System.out.println(e);
        }

        // inscription d'une equipe
        Equipe equipeAInscrire = EquipeRepository.getInstance().findById(6);
        if (TournoiService.getInstance().estInscrivableEquipeATournoi(equipeAInscrire, t)) {
            TournoiService.getInstance().inscrireEquipeATournoi(equipeAInscrire.getIdEquipe(), t.getId());
            System.out.println("bahbruh");
        } else {
            System.out.println("bruh");
        }
        le = TournoiService.getInstance().getEquipesInscrites(t.getId());
        for (Equipe e : le ) {
            System.out.println(e);
        }
        // Obtention de toutes les poules
        List<Poule> listePoulesAll = TournoiService.getInstance().getAllPoules(263);
        for (Poule p : listePoulesAll ) {
            System.out.println(p + " # " + PouleService.estPouleFinale.test(p));
        }

        List<Poule> listePoulesSimples = TournoiService.getInstance().getPoulesSimples(263);
        for (Poule p : listePoulesSimples ) {
            System.out.println(p + " ## " + PouleService.estPouleFinale.test(p));
        }

        Poule poulesFinale = TournoiService.getInstance().getPouleFinale(263);
        System.out.println(poulesFinale);

        // Enregistrement d'un tournoi
        LocalDate finTournoi = LocalDate.of(2025, 10, 12);
        LocalDate debutTournoi = LocalDate.of(2025, 10, 11);
        LocalDate dateFinInscription = LocalDate.of(2025, 10, 10);
        System.out.println(debutTournoi +" "  + finTournoi + " "  +dateFinInscription);

        TournoiService.getInstance().enregistrerNouveauTournoi("tournoi du commit seconde edition ?", Portee.INTERNATIONAL, dateFinInscription, debutTournoi, finTournoi, 2, 1 );
        System.out.println(TournoiRepository.getInstance().findByNom("tournoi du commit seconde edition ?"));
*/



    }





}
