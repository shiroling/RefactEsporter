package presentation.accueil;


import presentation.accueil.panelCartes.VuePanelCarte;
import presentation.accueil.panelFonctionnalite.VueFonctionalite;

import javax.swing.*;
import java.awt.*;

public class VueAccueil extends JFrame {
    private final VueFonctionalite vueFonctionalite;
    private final VuePanelCarte vuePanelCarte;
    public VueAccueil(VueFonctionalite vueFonctionalite, VuePanelCarte vuePanelCarte) {
        this.vueFonctionalite =vueFonctionalite;
        this.vuePanelCarte = vuePanelCarte;
        this.setMinimumSize(new Dimension(1000,500));
        this.setTitle("REMA");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(vueFonctionalite, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        VueAccueil acc = new VueAccueil(new VueFonctionalite(), new VuePanelCarte());
        acc.setVisible(true);
    }

    public VueFonctionalite getVueFonctionalite() {
        return vueFonctionalite;
    }

    public VuePanelCarte getVuePanelCarte() {
        return vuePanelCarte;
    }
}