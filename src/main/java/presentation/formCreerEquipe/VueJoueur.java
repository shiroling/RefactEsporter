package presentation.formCreerEquipe;

import presentation.formJoueur.ControleurFormJoueur;
import presentation.style.ElementCommun;

import javax.swing.*;
import java.awt.*;


public class VueJoueur extends JPanel {
    private final JLabel nomJoueur;
    private final JButton actionJoueur;
    private final int index;

    public VueJoueur(ControleurFormEquipe controleur, int index) {
        this.index = index;

        FlowLayout flowLayout = (FlowLayout) this.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);


        nomJoueur = new JLabel();
        nomJoueur.setName("nomJoueur");
        this.add(nomJoueur);

        actionJoueur =  new JButton();
        actionJoueur.setName("actionJoueur"+index);
        actionJoueur.addActionListener(controleur);
        this.add(actionJoueur);
        setVide();
    }
    public void setVide() {
        this.nomJoueur.setText("Joueur " + index + ": Vide");
        this.actionJoueur.setText("Créer");
    }
    public void setJoueur(int i, String pseudo) {
        this.nomJoueur.setText("Joueur "+ i + " : " +  pseudo);
        this.nomJoueur.setForeground(ElementCommun.getWarningColor());
        this.actionJoueur.setText("Supprimer");
    }

    public void setOnWarning() {
        this.nomJoueur.setText("/!\\ Vide /!\\");
        this.nomJoueur.setForeground(ElementCommun.getWarningColor());
    }

    public int getIndex() {
        return index;
    }
}
