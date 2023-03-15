package presentation.accueil.panelFonctionnalite.panelFiltres;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControleurPanelFiltres implements ItemListener {
    VuePanelFiltres vue;
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        // TODO
        System.out.println("ici");
        vue.getSelectedValues();
    }

    public ControleurPanelFiltres(VuePanelFiltres vue) {
        this.vue = vue;
    }


}
