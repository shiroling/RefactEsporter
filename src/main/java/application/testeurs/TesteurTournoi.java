package application.testeurs;

import modele.BDPredicats;

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
        return BDPredicats.estLibreNomTournoi(nomTounoi);
    }
}
