package nouveauModele.test;

import application.services.EcurieService;
import nouveauModele.Ecurie;
import nouveauModele.Equipe;

import java.util.List;

public class TestEcurie {

    public static void main(String[] args) {
        Ecurie e = EcurieService.getInstance().getEcurieFromId(1);
        System.out.println(e);

        Ecurie ee = EcurieService.getInstance().getEcurieFromNom("Vitality");
        System.out.println(ee);

        List<Equipe> le = EcurieService.getInstance().getEquipes(3);
        for (Equipe eee: le) {
            System.out.println(eee);
        }
    }




}
