package presentation.accueil.panelFonctionnalite.panelFiltres;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ContoleurComboFiltre implements ItemListener {
    private final VueComboFiltre vue;

    public ContoleurComboFiltre(VueComboFiltre vue) {
        this.vue = vue;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {

    }
}
