package presentation.Popup.PopupRencontre;

import application.donneesPersistantes.ConnexionCourante;
import application.donneesPersistantes.UtilisateurCourant;
import application.Application;
import modele.Rencontre;
import presentation.connexion.VueConnexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPopupRencontre implements ActionListener {

    private PopupRencontre vue;

    public ControleurPopupRencontre(PopupRencontre vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch(btn.getName()) {
            case "btnRenseignerVainqueur":
                if (UtilisateurCourant.getInstance().getEtatConnexion() != ConnexionCourante.ARBITRE) {
                    new VueConnexion();
                }
                if (UtilisateurCourant.getInstance().getEtatConnexion() == ConnexionCourante.ARBITRE && this.vue.getRencontre().isArbitre(UtilisateurCourant.getInstance().getIdLog())) {
                    Application.afficherPopupIndiquerVainqueurRencontre(this.vue.getRencontre());
                } else if(controleurAccueil.getConnexionState() == ConnexionState.ARBITRE) {
                    FenMessage dialog = new FenMessage("Vous n'êtes pas arbitre de ce match");
                    dialog.setVisible(true);
                } else {
                    FenMessage dialog = new FenMessage("Vous n'êtes pas arbitre");
                    dialog.setVisible(true);
                }
                break;
        }

    }

}