package presentation.Popup.PopupTournoi;

import application.donneesPersistantes.ConnexionCourante;
import application.donneesPersistantes.UtilisateurCourant;
import modele.Ecurie;
import presentation.PopupInscrireEquipe.FormInscrireEquipe.PopupInscrireEquipe;
import presentation.connexion.VueConnexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPopupTournoi implements ActionListener {

    private PopupTournoi vue;

    public ControleurPopupTournoi(PopupTournoi vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch (btn.getName()) {
            case "inscription":
                if (UtilisateurCourant.getInstance().getEtatConnexion() != ConnexionCourante.MANAGER) {
                    VueConnexion fenetreConnnexion = new VueConnexion();
                }
                if (UtilisateurCourant.getInstance().getEtatConnexion() == ConnexionCourante.MANAGER) {
                    PopupInscrireEquipe dialog = new PopupInscrireEquipe(new Ecurie(UtilisateurCourant.getInstance().getIdLog()));
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                }
                break;
            case "voirRencontres" :

                break;
        }
    }

}