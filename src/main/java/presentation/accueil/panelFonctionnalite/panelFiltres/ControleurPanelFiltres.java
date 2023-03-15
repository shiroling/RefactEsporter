package presentation.accueil.panelFonctionnalite.panelFiltres;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControleurPanelFiltres implements ItemListener {
    VuePanelFiltres vue;
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        System.out.println(vue.getSelectedValues());
        //throw new UnsupportedOperationException("Unimplemented : il faut remonter l'info a ListeCourante et recharcher les cartes une fois triées part celle-ci");
    }

    public ControleurPanelFiltres(VuePanelFiltres vue) {
        this.vue = vue;
    }


}
