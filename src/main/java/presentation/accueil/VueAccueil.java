package presentation.accueil;


import application.donneesPersistantes.ListeCourante;
import application.donneesPersistantes.ModeleGlobal;
import application.donneesPersistantes.Selection;
import presentation.accueil.panelCartes.VuePanelCarte;
import presentation.accueil.panelCartes.vuesCartes.Carte;
import presentation.accueil.panelFonctionnalite.VueFonctionalite;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VueAccueil extends JFrame {
    private final VueFonctionalite vueFonctionalite;
    private final VuePanelCarte vueCarte;
    public VueAccueil() {
        this.setMinimumSize(new Dimension(1000,500));
        this.setTitle("REMA");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.vueFonctionalite = new VueFonctionalite();
        this.vueCarte = new VuePanelCarte();
        JScrollPane scrollPaneMain = new JScrollPane();

        scrollPaneMain.setBorder(new EmptyBorder(0,0,0,0));
        scrollPaneMain.getVerticalScrollBar().setUnitIncrement(20);

        scrollPaneMain.setViewportView(vueCarte);
        this.getContentPane().add(vueFonctionalite, BorderLayout.WEST);
        this.getContentPane().add(scrollPaneMain, BorderLayout.CENTER);
    }

    public VueFonctionalite getVueFonctionalite() {
        return vueFonctionalite;
    }

    public VuePanelCarte getVueCarte() {
        return vueCarte;
    }

    public void updateToState(Selection select) {
        updateCartesGrille();
        switch (select) {
            case EQUIPE -> this.vueFonctionalite.setAffichageEquipe();
            case ECURIE -> this.vueFonctionalite.setAffichageEcurie();
            case JEU -> this.vueFonctionalite.setAffichageJeu();
            case RENCONTRE -> this.vueFonctionalite.setAffichageRencontre();
            case TOURNOI -> this.vueFonctionalite.setAffichageTournoi();
        }
    }
    public void updateCartesGrille() {
        for (Carte c: ListeCourante.getInstance().getListeEnCartes()) {
            getVueCarte().addCarte(c);
        }
    }
}