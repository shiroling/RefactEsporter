package Presentation.Accueil;

import Presentation.Accueil.PanelCartes.ControleurPanelCartes;
import Presentation.Accueil.PanelFonctionnalite.PanelConnexion.ControleurPanelConnexion;
import Presentation.Accueil.PanelFonctionnalite.PanelFiltres.ControleurPanelFiltres;
import Presentation.Accueil.PanelMenu.ControleurPanelMenu;

public class ControleurAccueil {
    private final ControleurPanelCartes ctlCartes;
    private final ControleurPanelConnexion ctlConnexion;
    private final ControleurPanelFiltres ctlFiltres;
    private final ControleurPanelMenu ctlMenu;

    public ControleurAccueil() {
        this.ctlCartes = new ControleurPanelCartes();
        this.ctlConnexion = new ControleurPanelConnexion();
        this.ctlFiltres = new ControleurPanelFiltres();
        this.ctlMenu = new ControleurPanelMenu();

    }
}
