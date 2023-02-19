package application.testeurs.date;

import java.sql.Date;

public record PreDate(int annee, int mois, int jour) {

    @Override
    public String toString() {
        return "PreDate{" +
                "jour=" + jour +
                ", mois=" + mois +
                ", annee=" + annee +
                '}';
    }

    public Date toDate() {
        return java.sql.Date.valueOf(String.format("%04d-%02d-%02d", annee(), mois(), jour()));
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }
}
