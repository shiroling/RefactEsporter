package Presentation.Accueil.PanelFonctionnalite;

import Presentation.Accueil.PanelFonctionnalite.PanelConnexion.VuePanelConnexion;
import Presentation.Accueil.PanelFonctionnalite.PanelMenu.VueMenu;

import javax.swing.*;
import java.awt.BorderLayout;

public class VueFonctionalite extends JPanel {

    public VueFonctionalite(){
        this.setLayout(new BorderLayout(0, 0));
        this.add(new VueMenu(),BorderLayout.NORTH);
        this.add(new VuePanelFiltres(),BorderLayout.CENTER);
        this.add(new VuePanelConnexion(),BorderLayout.SOUTH);
    }
}
