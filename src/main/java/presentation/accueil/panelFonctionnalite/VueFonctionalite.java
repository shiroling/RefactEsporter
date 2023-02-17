package presentation.accueil.panelFonctionnalite;

import presentation.accueil.panelFonctionnalite.panelConnexion.VuePanelConnexion;
import presentation.accueil.panelFonctionnalite.panelFiltres.VuePanelFiltres;
import presentation.accueil.panelFonctionnalite.panelMenu.VueMenu;

import javax.swing.*;
import java.awt.*;

public class VueFonctionalite extends JPanel {

    public VueFonctionalite(){
        this.setLayout(new BorderLayout(0, 0));
        this.add(new VueMenu(),BorderLayout.NORTH);
        this.add(new VuePanelFiltres(),BorderLayout.CENTER);
        this.add(new VuePanelConnexion(),BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(300,15));
    }
}
