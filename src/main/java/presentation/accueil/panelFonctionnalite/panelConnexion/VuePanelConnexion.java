package presentation.accueil.panelFonctionnalite.panelConnexion;

import javax.swing.*;

public class VuePanelConnexion extends JPanel {
    private final ControleurPanelConnexion controleur = new ControleurPanelConnexion(this);
    private final VueLabelBouton fonctionUtilisateurCourant;
    private final VueLabelBouton connexionCourante;
    public VuePanelConnexion() {
        fonctionUtilisateurCourant = new VueLabelBouton("Gestionnaire : ", "créer tournoi", "btnCreerTournoi", this.controleur);
        connexionCourante =  new VueLabelBouton("Déconnecté ", "se connecter", "btnSwitchConnexion", this.controleur);
        fonctionUtilisateurCourant.setName("fonctionCourante");
        this.add(fonctionUtilisateurCourant);
        fonctionUtilisateurCourant.setName("connexionCourante");
        this.add(fonctionUtilisateurCourant);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        VuePanelConnexion acc = new VuePanelConnexion();
        frame.add(acc);
        frame.setVisible(true);
    }




}
