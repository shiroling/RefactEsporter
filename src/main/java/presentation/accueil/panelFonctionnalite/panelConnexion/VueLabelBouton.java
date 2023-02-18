package presentation.accueil.panelFonctionnalite.panelConnexion;

import presentation.style.btnStyle.BtnStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class VueLabelBouton extends JPanel {
    private final JLabel label;
    private final BtnStyle bouton;
    public VueLabelBouton(String texteLabel, String texteBouton, String nomBouton, ActionListener controleur) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 0, 0));
        label = new JLabel(texteLabel);
        label.setVisible(true);
        panel.add(label);

        bouton = new BtnStyle(BtnStyle.COLOR_BASE_BLEU, BtnStyle.COLOR_OVER_BLEU, BtnStyle.COLOR_CLIC_BLEU, 30);
        bouton.setVisible(true);
        bouton.setText(texteBouton);
        bouton.setForeground(new Color(255, 255, 255));
        bouton.setName(nomBouton);
        bouton.addActionListener(controleur);
        panel.add(bouton);
    }

    public void setTexts(String texteLabel, String texteBouton, String nomBouton) {
        this.label.setText(texteLabel);
        this.bouton.setText(texteBouton);
        this.bouton.setName(nomBouton);
    }
}