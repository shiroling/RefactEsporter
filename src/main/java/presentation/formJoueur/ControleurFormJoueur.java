package presentation.formJoueur;

import application.testeurs.PreJoueur;
import application.testeurs.TesterJoueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ControleurFormJoueur implements ActionListener{

    private VueFormJoueur vue;
    private List<PreJoueur> joueurs;

    public ControleurFormJoueur(VueFormJoueur vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        switch (source.getName()) {
            case "Creer" :
                vue.getPreJoueur();
                break;
            case "Annuler" :
                this.vue.dispose();
                break;
        }
    }

}
