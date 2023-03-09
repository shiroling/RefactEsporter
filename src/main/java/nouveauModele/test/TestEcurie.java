package nouveauModele.test;

import application.services.EcurieService;
import nouveauModele.dataRepresentation.Ecurie;
import nouveauModele.repositories.EcurieRepository;
import nouveauModele.dataRepresentation.Equipe;

import java.util.List;

public class TestEcurie {

    public static void main(String[] args) {
        Ecurie e = EcurieRepository.getInstance().findById(3);
        System.out.println(e);

        Ecurie ee = EcurieRepository.getInstance().findByNom("Vitality");
        System.out.println(ee);

        List<Equipe> le = EcurieRepository.getInstance().getEquipes(e);
        for (Equipe eee: le) {
            System.out.println(eee);
        }

        System.out.println(EcurieRepository.getInstance().getPoints(ee));
    }




}
