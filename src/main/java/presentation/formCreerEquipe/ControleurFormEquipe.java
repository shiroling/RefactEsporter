package presentation.formCreerEquipe;

import application.services.JoueurService;
import application.testeurs.PreJoueur;
import nouveauModele.dataRepresentation.Joueur;
import presentation.formJoueur.VueFormJoueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;


public class ControleurFormEquipe implements ActionListener{

    private VueFormEquipe vue;
    private List<PreJoueur> joueurs;

    public ControleurFormEquipe(VueFormEquipe vue) {
        super();
        this.vue = vue;
        this.joueurs = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            joueurs.add(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        switch (source.getName()) {
            case "actionJoueur0" :
                procedureActionJoueur(0);
                break;
            case "actionJoueur1" :
                procedureActionJoueur(1);
                break;
            case "actionJoueur2" :
                procedureActionJoueur(2);
                break;
            case "actionJoueur3" :
                procedureActionJoueur(3);
                break;
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

    private void procedureActionJoueur(int i) {
        if(this.joueurs.get(i) == null) {
            creationJoueur(i);
        } else {
            this.joueurs.remove(i);
        }
    }

    private void creationJoueur(int i) {

        throw new UnsupportedOperationException("pas codé");
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
