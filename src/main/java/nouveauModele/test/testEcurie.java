package nouveauModele.test;

import application.services.EcurieService;
import nouveauModele.Ecurie;
import oracle.jdbc.internal.XSCacheOutput;

public class testEcurie {

    public static void main(String[] args) {
        Ecurie e = EcurieService.getInstance().getEcurieFromId(1);
        System.out.println(e.getNomEcurie());
    }




}
