package Presentation.Accueil;


import Presentation.Accueil.PanelFonctionnalite.PanelConnexion.VuePanelConnexion;
import Presentation.Accueil.PanelFonctionnalite.PanelFiltres.VuePanelFiltres;
import Presentation.Accueil.PanelFonctionnalite.PanelMenu.VueMenu;

import javax.swing.*;

public class VueAccueil extends JFrame {

    public VueAccueil(VuePanelConnexion vueConnexion, VuePanelFiltres vueFiltres, VueMenu vueMenu) {

    }

    public static void main(String[] args) {
        VueAccueil acc = new VueAccueil(new VuePanelConnexion(),new VuePanelFiltres(),new VueMenu());
        acc.setVisible(true);
    }


}