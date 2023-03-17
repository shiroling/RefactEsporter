package presentation.accueil.panelFonctionnalite.panelFiltres;

import application.donneesPersistantes.Portee;
import application.donneesPersistantes.Selection;
import application.filtres.RepresentationFiltre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class VuePanelFiltres extends JPanel {
    ControleurPanelFiltres contoleur;
    public VuePanelFiltres(){
        contoleur = new ControleurPanelFiltres(this);
    }

    public List<String> getSelectedValues() {
        List<String> list  = new ArrayList<>();
        for (Component c :this.getComponents()) {
            list.add((((VueComboFiltre) c).getSelectedValue()));
        }
        return list;
    }
    public void setToFiltres(List<RepresentationFiltre> listeFiltres) {
        this.removeAll();
        if (listeFiltres != null) {
            this.setLayout(new GridLayout(listeFiltres.size(), 1, 0, 0));
            VueComboFiltre c = null;
            for (RepresentationFiltre filtre: listeFiltres) {
                c = new VueComboFiltre(filtre.nomFiltre(), filtre.optionsFiltre());
                c.addItemListener(contoleur);
                this.add(c);
            }
        }
        this.updateUI();
    }
}
