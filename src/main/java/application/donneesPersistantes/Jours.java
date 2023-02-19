package application.donneesPersistantes;

import javax.swing.*;
import java.util.Calendar;

public class Jours {
    public static String[] getJours(int nbJours) {
        String[] jours = new String[nbJours];
        for (int i = 0; i < nbJours; i++) {
            jours[i] = String.format("%02d", i + 1);
        }
        return jours;
    }


}
