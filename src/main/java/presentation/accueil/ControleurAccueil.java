package presentation.accueil;

import presentation.accueil.panelCartes.ControleurPanelCartes;
import presentation.accueil.panelFonctionnalite.panelConnexion.ControleurPanelConnexion;
import presentation.accueil.panelFonctionnalite.panelFiltres.ControleurPanelFiltres;
import presentation.accueil.panelFonctionnalite.panelMenu.ControleurPanelMenu;

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
