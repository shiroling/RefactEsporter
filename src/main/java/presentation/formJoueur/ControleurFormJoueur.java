package presentation.formJoueur;

//import application.testeurs.PreJoueur;

import application.services.JoueurService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;


public class ControleurFormJoueur implements ActionListener{

    private VueFormJoueur vue;

    public ControleurFormJoueur(VueFormJoueur vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        switch (source.getName()) {
            case "Creer" :
                if(isVide(this.vue.getTextNomJoueur())) {
                    this.vue.setOnWarningNom();
                } else {
                    this.vue.setOnDefaultNom();
                }
                if(isVide(this.vue.getTextPseudoJoueur())) {
                    this.vue.setOnWarningPseudo();
                } else {
                    this.vue.setOnDefaultPrenom();
                }
                if(isVide(this.vue.getTextPrenomJoueur())) {
                    this.vue.setOnWarningPrenom();
                } else {
                    this.vue.setOnDefaultPrenom();
                }
                break;
            case "Annuler" :
                this.vue.dispose();
                break;
        }
    }

    public boolean isVide(String contenu) {
        if(contenu.equals("")) {
            return true;
        }
        for(int i = 0; i < contenu.length(); i++) {
            if (contenu.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean estDatePasse(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }
}
