package presentation.accueil.panelFonctionnalite.panelFiltres;

import presentation.style.ElementCommun;

import javax.swing.*;
import java.awt.*;

import static presentation.style.ElementCommun.getFontPrincipal;

public class VueComboFiltre extends JPanel{

    private final JComboBox<String> comboBox;

    public void addItemListener(ControleurPanelFiltres controleur) {
        this.comboBox.addItemListener(controleur);
    }

    public VueComboFiltre(String nom, String[] options) {
        this.setLayout(new GridLayout(0, 2, 0, 0));
        JLabel label = new JLabel( nom+ " : ");
        label.setFont(getFontPrincipal());
        this.add(label);

        comboBox = new JComboBox<String>();
        comboBox.setFont(getFontPrincipal());
        comboBox.setPreferredSize(new Dimension(140, 30));
        comboBox.setFont(ElementCommun.getFontPrincipal());

        comboBox.setModel(new DefaultComboBoxModel<String>(options));
        this.add(comboBox);
    }

    public String getSelectedValue() {
        return (String) this.comboBox.getSelectedItem();
    }

    @Override
    public String toString() {
        return "VueComboFiltre{" +
                "comboBoxVal=" + comboBox.getSelectedItem().toString() +
                '}';
    }
}
