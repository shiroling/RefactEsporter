package modele.test;

import application.services.RencontreService;
import modele.dataRepresentation.Equipe;
import modele.dataRepresentation.Rencontre;
import modele.repositories.RencontreRepository;

import java.util.List;

public class TestRencontre {
    public static void main(String[] args) {
        Rencontre rencontreById = RencontreService.getInstance().getRencontreFromId(300);
        System.out.println(rencontreById);

        List<Equipe> le = RencontreService.getInstance().getEquipesParticipantes(327);
        for (Equipe e: le) {
            System.out.println(e);
        }


        System.out.println("rencontre gagné par " + RencontreRepository.getInstance().getGagnant(rencontreById));

        System.out.println(RencontreRepository.getInstance().getPorteeRenconre(rencontreById));
    }


}
