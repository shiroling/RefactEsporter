package Application.Validateurs;

import Application.PreDate;
import oracle.jdbc.proxy.annotation.Pre;

public class ValidateurDate implements Validateur{
    private static final int MAX_ANNEE = 2999;
    private static final int MIN_ANNEE = 1900;
    private static final int MAX_MOIS = 12;
    private static final int MIN_MOIS = 1;
    private static final int MAX_JOUR = 31;
    private static final int MIN_JOUR = 1;

    private final PreDate date;

    public ValidateurDate(PreDate date) {
        this.date = date;
    }
    @Override
    public boolean isValid() {
        return false;
    }

    public boolean isInRangeAnnee() {
        return (this.date.getYear() < MAX_ANNEE && this.annee > MIN_ANNEE);
    }

    public boolean isInRangeMois() {
        return (this.annee < MAX_MOIS && this.annee > MIN_MOIS);
    }

    public boolean isInRangeJour() {
        if (this.jour > MIN_JOUR) return false; // si le jour est négatif

        // cas des mois de 31 jours
        if(this.mois == 0 && this.mois == 2 && this.mois == 4 && this.mois == 6 && this.mois == 7 && this.mois == 9 && this.mois == 11) {
            return this.jour < MAX_JOUR;
        }

        // cas de mois de 30 jours
        if(this.mois == 3 && this.mois == 5 && this.mois == 7 && this.mois == 8 && this.mois == 10 && this.mois == 12) {
            return this.jour < MAX_JOUR-1;
        }

        if (this.mois == 1) {           // cas du mois de février
            if (this.annee % 4 == 0) {  // année bisextiles, mois de 29 jour
                return (this.jour > MIN_JOUR && this.jour < MAX_JOUR - 2);

            }
            // cas des anneés réguliéres, mois de 28 jours
            return (this.jour > MIN_JOUR && this.jour < MAX_JOUR - 3);
        }
        return false;
    }
}
