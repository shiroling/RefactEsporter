package Application.Testeurs;

import Application.Modele.Portee;
import Application.Testeurs.Date.PreDate;
import Application.Testeurs.Date.TesteurDate;
import Modele.BDPredicats;
import Modele.Jeu;

import java.sql.Date;

public class TesteurTournoi {
    public static boolean isValid(String nomTounoi, PreDate dateFinInscription, PreDate dateDebutTournoi, PreDate dateFinTournoi) {
        if(!isValidNom(nomTounoi))
            throw new IllegalArgumentException("Le nom donné au tournoi est déjà pris");
        if(!areValidDates(dateFinInscription, dateDebutTournoi, dateFinTournoi))
            throw new IllegalArgumentException("Les dates données ne corélent pas");

        return true;
    }
    public static boolean areValidDates(PreDate dateFinInscription, PreDate dateDebutTournoi, PreDate dateFinTournoi) {
        return  TesteurDate.test(dateFinInscription) &&
                TesteurDate.test(dateDebutTournoi) &&
                TesteurDate.test(dateFinTournoi) &&
                dateFinInscription.toDate().before(dateDebutTournoi.toDate()) &&
                dateDebutTournoi.toDate().before(dateFinTournoi.toDate());
    }
    public static boolean isValidNom(String nomTounoi) {
        return !BDPredicats.existeNomTournoi(nomTounoi);
    }
}
