package presentation.accueil.panelFonctionnalite;

import presentation.accueil.panelFonctionnalite.panelConnexion.VuePanelConnexion;
import presentation.accueil.panelFonctionnalite.panelFiltres.VuePanelFiltres;
import presentation.accueil.panelFonctionnalite.panelMenu.Selection;
import presentation.accueil.panelFonctionnalite.panelMenu.VueMenu;

import javax.swing.*;
import java.awt.*;

public class VueFonctionalite extends JPanel {
    private final VuePanelFiltres panelFiltres;
    private final VueMenu panelMenu;
    private final VuePanelConnexion vuePanelConnexion;
    public VueFonctionalite(){
        this.panelFiltres = new VuePanelFiltres();
        this.panelMenu = new VueMenu();
        this.vuePanelConnexion =new VuePanelConnexion();
        this.setLayout(new BorderLayout(0, 0));
        this.add(this.panelMenu,BorderLayout.NORTH);
        this.add(this.panelFiltres,BorderLayout.CENTER);
        this.add(this.vuePanelConnexion,BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(300,15));

    }

    public void setAffichageEcurie() {
        this.panelFiltres.setPanelVide();
        this.panelMenu.setSelected(Selection.ECURIE);
    }

    public void setAffichageEquipe() {
        this.panelFiltres.setPanelFiltresEquipes();
        this.panelMenu.setSelected(Selection.EQUIPE);
    }
    public void setAffichageJeu() {
        this.panelFiltres.setPanelVide();
        this.panelMenu.setSelected(Selection.JEU);
    }

    public void setAffichageRencontre() {
        this.panelFiltres.setPanelFiltresRencontres();
        this.panelMenu.setSelected(Selection.RENCONTRE);
    }

    public void setAffichageTournoi() {
        this.panelFiltres.setFiltreTournois();
        this.panelMenu.setSelected(Selection.TOURNOI);
    }
}
