package presentation.connexion;

import application.donneesPersistantes.UtilisateurCourant;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurConnexion implements ActionListener {
    private final VueConnexion connexionVue;

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
        if(UtilisateurCourant.tryConnect(username, password)) {
            this.connexionVue.dispose();
        } else {
            procedureConnexionEchouee();
        }
    }
}