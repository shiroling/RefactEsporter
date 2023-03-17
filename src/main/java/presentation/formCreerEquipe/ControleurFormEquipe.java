package presentation.formCreerEquipe;

import application.services.EquipeService;
import application.services.JeuService;
import application.services.JoueurService;
import application.testeurs.JoueurRecord;
import presentation.formJoueur.VueFormJoueur;
//import application.testeurs.PreJoueur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;


public class ControleurFormEquipe implements ActionListener{

    private final LinkedList<Object> joueurs; // Temporaire
    private VueFormEquipe vue;
    private List<JoueurRecord> joueurRecords;

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
        VueFormJoueur fen = new VueFormJoueur();
        fen.setVisible(true);
    }



    private void actionJoueur(JButton source) {
    }

    private void ProcedureInsertion() {

    }

    private boolean verifiedAll() {
        return (!equipeDejaExistante(this.vue.getNomNouvelleEquipe()) /*&&*/ );
    }

    private boolean equipeDejaExistante(String nomEquipe) {
        return EquipeService.getInstance().isNomDejaPris(nomEquipe);
    }

    private boolean estJoueurValide() {
        throw new UnsupportedOperationException("unimplemented");
    }

}
