package nouveauModele.test;

import application.services.PouleService;
import nouveauModele.Poule;
import nouveauModele.PouleRepository;

public class TestPoule {
    public static void main(String[] args) {
        // obtenir poule
        Poule pouleById = PouleRepository.getInstance().findById(692);
        System.out.println(pouleById);

        // est fnale
        System.out.println(PouleService.estPouleFinale.test(pouleById));

    }


}
