package Presentation.Connexion;

import Application.Application;
import Application.Modele.User;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurConnexion implements ActionListener {
    private VueConnexion connexionVue;

    public ControleurConnexion(VueConnexion connexionVue) {
        super();
        this.connexionVue = connexionVue;
    }

    protected void procedureConnexionEchouee() {
        LineBorder border = new LineBorder(Color.RED);
        this.connexionVue.getTextFieldUsername().setBorder(border);
        this.connexionVue.getTextFieldPassword().setBorder(border);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String username = this.connexionVue.getTextFieldUsername().getText();
        String password = String.valueOf(this.connexionVue.getTextFieldPassword().getPassword());
        User user = new User(username, password);

        if(user.existe()) {
            Application.setUser(user);
            Application.cacherBtnConnexionAccueil();
            this.connexionVue.dispose();
        } else {
            procedureConnexionEchouee();
        }
    }
}
