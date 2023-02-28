package nouveauModele.test;

import application.services.EquipeService;
import application.services.TournoiService;
import nouveauModele.Equipe;
import nouveauModele.EquipeRepository;
import nouveauModele.Tournoi;
import nouveauModele.TournoiRepository;

import java.util.List;

public class TestTournoi {
    public static void main(String[] args) {
        Tournoi t = TournoiRepository.getInstance().findById(338);
        System.out.println(t);

        List<Equipe> le = TournoiService.getInstance().getEquipesInscrites(t.getId());
        for (Equipe e : le ) {
            System.out.println(e);
        }

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
    }




}
