package presentation.PopupInscrireEquipe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import application.Application;
import presentation.PopupInscrireEquipe.PanelEquipePourInscription.PanelEquipePourInscription;

import javax.swing.JButton;



public class ControleurPopupInscrireEquipe implements ActionListener {

    private PopupInscrireEquipe vue;

    public ControleurPopupInscrireEquipe(PopupInscrireEquipe vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch (btn.getName()) {
            case "Inscrire":
                if (this.vue.getEquipeSelectionee() != null) {
                    Application.procedureInscrireEquipe(this.vue.getEquipeSelectionee(), this.vue.getTournoi());
                    this.vue.dispose();
                } else {
                    this.vue.getLblAucuneEquipeSelectionee().setVisible(true);
                }
                break;
            case "Annuler":
                Application.afficherPopupTournoi(this.vue.getTournoi());
                this.vue.dispose();
                break;
        }
    }
}