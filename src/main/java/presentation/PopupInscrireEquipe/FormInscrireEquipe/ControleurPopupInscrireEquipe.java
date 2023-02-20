package presentation.PopupInscrireEquipe.FormInscrireEquipe;

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
                if (this.vue.getEquipeSelectionee() != null) {
                    this.vue.getTournoi().inscrireEquipe(this.vue.getEquipeSelectionee());
                    //FenMessage dialog = new FenMessage("L'equipe '" + this.vue.getEquipeSelectionee().getNom() + "' à été inscrite au tournoi '" + this.vue.getTournoi().getNom() + "'.");
                    //dialog.setVisible(true);
                    Application.actualiserPopupTournoi();
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