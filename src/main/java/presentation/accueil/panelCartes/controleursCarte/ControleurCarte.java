package presentation.accueil.panelCartes.controleursCarte;

import presentation.accueil.panelCartes.vuesCartes.Carte;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class ControleurCarte implements MouseListener {

    private Carte vue;

    public ControleurCarte(Carte vue) {this.vue=vue;}

    public abstract void onClick();

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        onClick();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.vue.setBackground(new Color(220,220,220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.vue.setBackground(Color.WHITE);
    }

    public Carte getVue() {
        return vue;
    }
}
