package modele.test;

import modele.dataRepresentation.Poule;
import modele.repositories.PouleRepository;

public class TestPoule {
    public static void main(String[] args) {

        // obtenir poule
        Poule pouleById = PouleRepository.getInstance().findById(689);
        /*
        System.out.println(pouleById);

        // est fnale
        System.out.println(PouleService.estPouleFinale.test(pouleById));

        System.out.println("rencontres : ");
        System.out.println(PouleRepository.getInstance().getRencontres(pouleById));

        System.out.println("Equipes : ");
        System.out.println(PouleRepository.getInstance().getEquipes(pouleById));

        System.out.println("resultat : ");
        System.out.println(PouleService.getInstance().getResultat(pouleById));
*/
        PouleRepository.getInstance().creerPoules(299);
    }


}
