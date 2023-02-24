package presentation.accueil.panelFonctionnalite.panelFiltres;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControleurPanelFiltres implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        // TODO
    }
    private final VuePanelFiltres vue;


    public ControleurPanelFiltres(VuePanelFiltres vue) {
        this.vue = vue;
    }


}
