package Application.Testeurs.Tournoi;

import Application.Modele.Portee;
import Application.Testeurs.Date.PreDate;
import Application.Testeurs.Date.TesteurDate;
import Modele.Jeu;

public class TesteurTournoi {
    String nomTounoi;
    Portee porteeTournoi;
    PreDate dateFinInscription;
    PreDate dateDebutTournoi;
    PreDate dateFinTournoi;
    Jeu jeu;
    int idGerant;

    public TesteurTournoi(String nomTounoi, Portee porteeTournoi, PreDate dateFinInscription, PreDate dateDebutTournoi, PreDate dateFinTournoi, Jeu jeu, int idGerant) {
        this.nomTounoi = nomTounoi;
        this.porteeTournoi = porteeTournoi;
        this.dateFinInscription = dateFinInscription;
        this.dateDebutTournoi = dateDebutTournoi;
        this.dateFinTournoi = dateFinTournoi;
        this.jeu = jeu;
        this.idGerant = idGerant;
    }

    public boolean isValid() {
        return areValidDates();
    }

    public boolean areValidDates() {
        return  TesteurDate.test(dateFinInscription) &&
                TesteurDate.test(dateDebutTournoi) &&
                TesteurDate.test(dateFinTournoi);
    }

}
