package presentation.formulaires.formCreerTournoi;

import application.services.JeuService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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
        this.controleurFormCreerTournoi.enleverJeu(nomJeuxAEnlever);
        List<String> nomsJeuxDisponible = JeuService.getInstance().getNomsJeuDisponibles();
        for (String nomJeu : this.controleurFormCreerTournoi.getListNomJeu()) {
           nomsJeuxDisponible =  nomsJeuxDisponible.stream().filter(jeu -> !jeu.equals(nomJeu)).toList();
        }
        String[] lesJeux = (String[]) nomsJeuxDisponible.toArray(new String[nomsJeuxDisponible.size()]);
        this.vue.getComboJeux().setModel(new DefaultComboBoxModel<>(lesJeux));
        JPanel parent = (JPanel) lblJeuAEnlever.getParent();
        parent.remove(lblJeuAEnlever);
        parent.updateUI();
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
