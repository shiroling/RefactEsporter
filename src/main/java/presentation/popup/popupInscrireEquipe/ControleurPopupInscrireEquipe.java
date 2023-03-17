package presentation.popup.popupInscrireEquipe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import application.Application;

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
                if (this.vue.getNomEquipeSelectionee() != null) {
                    Application.getinstance().inscrireEquipeAuTournoi(vue.getNomEquipeSelectionee(), vue.getNomTournoi());
                    this.vue.dispose();
                } else {
                    this.vue.getLblAucuneEquipeSelectionee().setVisible(true);
                }
                break;
            case "Annuler":
                this.vue.dispose();
                break;
        }
    }
}