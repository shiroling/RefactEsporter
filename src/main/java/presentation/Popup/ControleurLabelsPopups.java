package presentation.Popup;

import application.Application;
import application.services.EcurieService;
import application.services.EquipeService;
import application.services.JoueurService;
import application.services.TournoiService;
import modele.Joueur;
import nouveauModele.repositories.EcurieRepository;
import nouveauModele.repositories.JouerRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Type;

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
