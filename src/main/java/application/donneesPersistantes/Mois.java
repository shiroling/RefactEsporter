package application.donneesPersistantes;

import javax.swing.*;
import java.util.Calendar;

public enum Mois {
    JANVIER("Janvier", 0), FEVRIER("Février", 1), MARS("Mars", 2), AVRIL("Avril", 3), MAI("Mai", 4), JUIN("Juin", 5), JUILLET("Juillet", 6), AOUT("Août", 7), SEPTMBRE("Septembre", 8), OCTOBRE("Octobre", 9), NOVEMBRE("Novembre", 10), DECEMBRE("Décembre", 11);

    private final String denomination;
    private final int moisChiffre;

    Mois(String denomination, int moisChiffre) {
        this.denomination = denomination;
        this.moisChiffre = moisChiffre;
    }

    public int getMoisChiffre() {
        return this.moisChiffre;
    }

    public String getDenomination() {
        return this.denomination;
    }

    public static Mois stringToMois(String str) {
        return switch (str) {
            case "Janvier" -> Mois.JANVIER;
            case "Février" -> Mois.FEVRIER;
            case "Mars" -> Mois.MARS;
            case "Avril" -> Mois.AVRIL;
            case "Mai" -> Mois.MAI;
            case "Juin" -> Mois.JUIN;
            case "Juillet" -> Mois.JUILLET;
            case "Août" -> Mois.AOUT;
            case "Septembre" -> Mois.SEPTMBRE;
            case "Octobre" -> Mois.OCTOBRE;
            case "Novembre" -> Mois.NOVEMBRE;
            case "Décembre" -> Mois.DECEMBRE;
            default -> null;
        };
    }

    public static int stringToInt(String str) {
        return switch (str) {
            case "Janvier" -> 1;
            case "Février" -> 2;
            case "Mars" -> 3;
            case "Avril" -> 4;
            case "Mai" -> 5;
            case "Juin" -> 6;
            case "Juillet" -> 7;
            case "Août" -> 8;
            case "Septembre" -> 9;
            case "Octobre" -> 10;
            case "Novembre" -> 11;
            case "Décembre" -> 12;
            default -> -1;
        };
    }

    public static String[] toStrings() {
        String[] mois = new String[Mois.values().length];
        for (int i = 0; i < Mois.values().length ; i++) {
            mois[i] = Mois.values()[i].getDenomination();
        }
        return mois;
    }
}
