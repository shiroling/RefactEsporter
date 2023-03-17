package presentation.popup;

import application.services.EcurieService;
import application.services.EquipeService;
import application.services.JoueurService;
import application.services.TournoiService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Ce controleur affiche les popups quand on clic sur les labels d'un Joueur, Jeu, Ecurie, Equipe
public class ControleurLabelsPopups implements MouseListener {

    private TypeLabel typeLabel;
    public ControleurLabelsPopups(TypeLabel typeLabel) {
        this.typeLabel = typeLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource();

        switch(typeLabel) {
            case ECURIE:
                EcurieService.getInstance().afficherPopupEcurie(lbl.getText());
                break;
            case EQUIPE:
                EquipeService.getInstance().afficherPopupEquipe(lbl.getText());
                break;
            case JOUEUR:
                JoueurService.getInstance().afficherPopupJoueur(lbl.getText());
                break;
            case TOURNOI:
                TournoiService.getInstance().afficherPopupTournoi(lbl.getText());
                break;
        }
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
        lbl.setForeground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource();
        lbl.setForeground(Color.BLACK);
    }
}
