package presentation.accueil.panelFonctionnalite.panelConnexion;

import javax.swing.*;
import java.awt.*;

public class VuePanelConnexion extends JPanel {
    private final ControleurPanelConnexion controleur = new ControleurPanelConnexion(this);
    private final VueLabelBouton fonctionUtilisateur;
    private final VueLabelBouton connexionCourante;
    public VuePanelConnexion() {
        this.setLayout(new GridLayout(2,1));
        fonctionUtilisateur = new VueLabelBouton("Gestionnaire : ", "Créer tournoi", "btnFonctionUtilisateur", this.controleur);
        connexionCourante =  new VueLabelBouton("Déconnecté ", "Se connecter", "btnSwitchConnexion", this.controleur);
        fonctionUtilisateur.setName("fonctionCourante");
        connexionCourante.setName("connexionCourante");
        this.add(fonctionUtilisateur);
        this.add(connexionCourante);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        VuePanelConnexion acc = new VuePanelConnexion();
        frame.add(acc);
        frame.setVisible(true);
    }

    protected void setConnexionCourante(String texteLabel, String texteBouton) {
        this.connexionCourante.setTexts(texteLabel, texteBouton);
    }

    protected void setFonctionUtilisateur(String texteLabel, String texteBouton) {
        this.connexionCourante.setTexts(texteLabel, texteBouton);
    }

    protected void setFoncionVisible(boolean aFlag) {
        this.fonctionUtilisateur.setVisible(aFlag);
    }
}
