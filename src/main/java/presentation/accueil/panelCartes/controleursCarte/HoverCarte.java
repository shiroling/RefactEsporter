package presentation.accueil.panelCartes.controleursCarte;

import presentation.accueil.panelCartes.vuesCartes.Carte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HoverCarte implements MouseListener {

    private Carte vue;

    public HoverCarte(Carte vue, JPanel Panel) {
        super();
        this.vue = vue;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.vue.setBackground(new Color(220,220,220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.vue.setBackground(Color.WHITE);
    }

}

