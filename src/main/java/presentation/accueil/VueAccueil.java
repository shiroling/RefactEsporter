package presentation.accueil;


import Presentation.Accueil.PanelFonctionnalite.VueFonctionalite;

import javax.swing.*;
import java.awt.*;

public class VueAccueil extends JFrame {

    public VueAccueil(VueFonctionalite vueFonctionalite) {
        this.setTitle("REMA");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(vueFonctionalite, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        VueAccueil acc = new VueAccueil(new VueFonctionalite());
        acc.setVisible(true);
    }


}