package presentation.accueil;


import application.donneesPersistantes.ModeleGlobal;
import application.donneesPersistantes.Selection;
import presentation.accueil.panelCartes.VuePanelCarte;
import presentation.accueil.panelFonctionnalite.VueFonctionalite;

import javax.swing.*;
import java.awt.*;

public class VueAccueil extends JFrame {
    private final VueFonctionalite vueFonctionalite;
    private final VuePanelCarte vueCarte;
    public VueAccueil() {
        this.vueFonctionalite = new VueFonctionalite();
        this.vueCarte = new VuePanelCarte();
        this.setMinimumSize(new Dimension(1000,500));
        this.setTitle("REMA");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(vueFonctionalite, BorderLayout.WEST);
    }

    public VueFonctionalite getVueFonctionalite() {
        return vueFonctionalite;
    }

    public VuePanelCarte getVueCarte() {
        return vueCarte;
    }

    public void updateToState(Selection select) {
        this.vueCarte.setCartes(ModeleGlobal.getInstance().getListeCourante());
        switch (select) {
            case EQUIPE -> this.vueFonctionalite.setAffichageEquipe();
            case ECURIE -> this.vueFonctionalite.setAffichageEcurie();
            case JEU -> this.vueFonctionalite.setAffichageJeu();
            case RENCONTRE -> this.vueFonctionalite.setAffichageRencontre();
            case TOURNOI -> this.vueFonctionalite.setAffichageTournoi();

        }
    }
}