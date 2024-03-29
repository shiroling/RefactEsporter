package presentation.accueil.panelFonctionnalite;

import application.donneesPersistantes.Selection;
import application.filtres.RepresentationFiltre;
import presentation.accueil.panelFonctionnalite.panelConnexion.VuePanelConnexion;
import presentation.accueil.panelFonctionnalite.panelFiltres.VuePanelFiltres;
import presentation.accueil.panelFonctionnalite.panelMenu.VueMenu;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

    public void setAffichage(Selection s, List<RepresentationFiltre> filtresAAfficher) {
        this.panelFiltres.setToFiltres(filtresAAfficher);
        this.panelMenu.setSelected(s);
    }
}
