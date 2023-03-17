package presentation.formCreerTournoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurLblJeu implements MouseListener {

    private VueFormCreerTournoi vue;
    private ControleurFormCreerTournoi controleurFormCreerTournoi;

    public ControleurLblJeu(VueFormCreerTournoi vue, ControleurFormCreerTournoi controleurFormCreerTournoi) {
        this.vue = vue;
        this.controleurFormCreerTournoi = controleurFormCreerTournoi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lblJeuAEnlever = ((JLabel) e.getSource());
        String nomJeuxAEnlever = lblJeuAEnlever.getText();
        this.vue.getComboJeux().addItem(nomJeuxAEnlever);
        this.controleurFormCreerTournoi.enleverJeu(nomJeuxAEnlever);
        lblJeuAEnlever.getParent().remove(lblJeuAEnlever);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource();
        lbl.setForeground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource();
        lbl.setForeground(Color.BLACK);
    }
}
