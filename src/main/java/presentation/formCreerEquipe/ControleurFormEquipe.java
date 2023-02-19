package presentation.formCreerEquipe;

import modele.Joueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ControleurFormEquipe implements ActionListener{

    private VueFormEquipe vue;
    private List<Joueur> joueurs;

    public ControleurFormEquipe(VueFormEquipe vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        switch (source.getName()) {
            case "actionJoueur" :
                
                actionJoueur(source.);
            case "CreerEquipe" :
                if (verifiedAll()) {
                    ProcedureInsertion();
                }
                break;
            case "Annuler" :
                this.vue.dispose();
                break;
        }
    }

    private void actionJoueur(JButton source) {
    }

    private void ProcedureInsertion() {
        return;
    }

    private boolean verifiedAll() {
        return false;
    }


}
