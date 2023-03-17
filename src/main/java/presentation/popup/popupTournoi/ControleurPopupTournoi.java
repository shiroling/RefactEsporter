package presentation.popup.popupTournoi;

import application.Application;
import application.donneesPersistantes.ConnexionCourante;
import application.donneesPersistantes.UtilisateurCourant;
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
                    Application.getinstance().procedureInitierInscrireEquipeAuTournoi(vue.getNomTournoi());
                    this.vue.dispose();
                }
                break;
            case "voirRencontres" :

                break;
        }
    }

}