package Presentation.Connexion;

import Application.Application;
import Application.ConnexionState;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurConnexion implements ActionListener {
    private ConnexionState connexionVisee;
    private VueConnexion connexionVue;

    public ControleurConnexion(ConnexionState connexionVisee, VueConnexion connexionVue) {
        super();
        this.connexionVisee = connexionVisee;
        this.connexionVue = connexionVue;
    }

    protected void procedureConnexionEchouee() {
        LineBorder border = new LineBorder(Color.RED);
        this.connexionVue.getTextFieldUsername().setBorder(border);
        this.connexionVue.getTextFieldPassword().setBorder(border);
        Application.setConnexionState(ConnexionState.NON_CONNECTE);
        Application.afficherBtnConnexionAccueil();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        switch (connexionVisee) {
            case ARBITRE:
                if (Application.isArbitre(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
                    Application.setConnexionState(ConnexionState.ARBITRE);
                    Application.cacherBtnConnexionAccueil();
                    Application.setIdLog(Application.getIdArbitreFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
                    this.connexionVue.dispose();
                } else {
                    procedureConnexionEchouee();
                }
                break;
            case GESTIONNAIRE:
                if (Application.isGestionnaire(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
                    Application.setConnexionState(ConnexionState.GESTIONNAIRE);
                    Application.cacherBtnConnexionAccueil();
                    Application.setIdLog(Application.getIdGerantFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
                    this.connexionVue.dispose();
                } else {
                    procedureConnexionEchouee();
                }
                break;
            case MANAGER:
                if (Application.isManager(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
                    Application.setConnexionState(ConnexionState.MANAGER);
                    Application.cacherBtnConnexionAccueil();
                    Application.setIdLog(Application.getIdManagerFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
                    this.connexionVue.dispose();
                } else {
                    procedureConnexionEchouee();
                }
                break;
            case NON_CONNU:
                if (Application.isManager(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) {
                    Application.setConnexionState(ConnexionState.MANAGER);
                    Application.cacherBtnConnexionAccueil();
                    Application.setIdLog(Application.getIdManagerFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
                    this.connexionVue.dispose();
                }
                else if ((Application.isGestionnaire(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword()))) ) {
                    Application.setConnexionState(ConnexionState.GESTIONNAIRE);
                    Application.cacherBtnConnexionAccueil();
                    Application.setIdLog(Application.getIdGerantFromLogs(this.connexionVue.getTextFieldUsername().getText(), String.valueOf(this.connexionVue.getTextFieldPassword().getPassword())));
                    this.connexionVue.dispose();
                }
                else {
                    procedureConnexionEchouee();
                }
                break;
            default:
                Application.setConnexionState(ConnexionState.NON_CONNECTE);
                Application.afficherBtnConnexionAccueil();
        }
    }
}
