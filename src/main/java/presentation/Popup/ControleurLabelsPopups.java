package presentation.Popup;

import application.Application;
import application.services.JoueurService;
import modele.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Ce controleur affiche les popups quand on clic sur les labels d'un Joueur, Jeu, Ecurie, Equipe
public class ControleurLabelsPopups implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel lbl = (JLabel) e.getSource();

        switch(lbl.getName()) {
            case "Joueur":
                break;
            case "Jeu":
                break;
            case "Ecurie":
                break;
            case "Equipe":
                break;
        }
    }
}
