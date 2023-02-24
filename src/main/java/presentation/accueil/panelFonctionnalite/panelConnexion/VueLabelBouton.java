package presentation.accueil.panelFonctionnalite.panelConnexion;

import presentation.style.btnStyle.BtnStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class VueLabelBouton extends JPanel {
    private final JLabel label;
    private final BtnStyle bouton;
    public VueLabelBouton(String texteLabel, String texteBouton, String nomBouton, ActionListener controleur) {
        this.setLayout(new GridLayout(1, 2, 0, 0));
        label = new JLabel(texteLabel);
        label.setVisible(true);
        this.add(label);

        bouton = new BtnStyle(BtnStyle.COLOR_BASE_BLEU, BtnStyle.COLOR_OVER_BLEU, BtnStyle.COLOR_CLIC_BLEU, 30);
        bouton.setVisible(true);
        bouton.setText(texteBouton);
        bouton.setForeground(new Color(255, 255, 255));
        bouton.setName(nomBouton);
        bouton.addActionListener(controleur);
        this.add(bouton);
    }

    public void setTexts(String texteLabel, String texteBouton) {
        this.label.setText(texteLabel);
        this.bouton.setText(texteBouton);
    }
    /*
    @Override
    public void setVisible(boolean aFlag) {
        this.setVisible(aFlag);
    }*/
}