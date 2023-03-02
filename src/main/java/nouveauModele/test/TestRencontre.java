package nouveauModele.test;

import application.services.RencontreService;
import nouveauModele.Equipe;
import nouveauModele.Rencontre;
import nouveauModele.RencontreRepository;

import java.util.List;

public class TestRencontre {
    public static void main(String[] args) {
        Rencontre rencontreById = RencontreService.getInstance().getRencontreFromId(351);
        System.out.println(rencontreById);

        List<Equipe> le = RencontreService.getInstance().getEquipesParticipantes(327);
        for (Equipe e: le) {
            System.out.println(e);
        }


        System.out.println("rencontre gagné par " + RencontreRepository.getInstance().getGagnant(rencontreById));
    }


}
