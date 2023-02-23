package presentation.accueil.panelFonctionnalite.panelFiltres;

import javax.swing.*;
import java.awt.*;

import static presentation.style.ElementCommun.getFontPrincipal;

public class VueComboFiltre extends JPanel{

    private final JComboBox<String> comboFiltreAvencementTournoi;

    public VueComboFiltre(String nom, String[] options) {
        ContoleurComboFiltre contoleur = new ContoleurComboFiltre(this);
        this.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel label = new JLabel( nom+ " : ");
        label.setFont(getFontPrincipal());
        this.add(label);

        comboFiltreAvencementTournoi = new JComboBox<String>();
        comboFiltreAvencementTournoi.setFont(getFontPrincipal());
        comboFiltreAvencementTournoi.setPreferredSize(new Dimension(140, 30));

        comboFiltreAvencementTournoi.setModel(new DefaultComboBoxModel<String>(options));
        comboFiltreAvencementTournoi.addItemListener(contoleur);
        this.add(comboFiltreAvencementTournoi);
    }

    public String getSelectedValue() {
        return (String) this.comboFiltreAvencementTournoi.getSelectedItem();
    }
}
