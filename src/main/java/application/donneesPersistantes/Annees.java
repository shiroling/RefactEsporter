package application.donneesPersistantes;

import javax.swing.*;
import java.util.Calendar;

public class Annees {
    public static String[] getAnneeFutures(int nbAnnees) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int maxYear = currentYear + nbAnnees;
        String[] annees = new String[maxYear - currentYear];
        for (int i = 0; i < annees.length; i++) {
            annees[i] = String.valueOf(currentYear + i);
        }
        return annees;
    }
    public static String[] getAnneePasses(int nbAnnees) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR)-12;
        int minYear = currentYear - nbAnnees;
        String[] annees = new String[currentYear - minYear];
        for (int i = 0; i < annees.length; i++) {
            annees[i] = String.valueOf(currentYear - i);
        }
        return annees;
    }
}
