package presentation.accueil.panelFonctionnalite.panelConnexion;

import application.FonctionsUtilisateurs;
import application.donneesPersistantes.ConnexionCourante;
import application.donneesPersistantes.UtilisateurCourant;

import presentation.style.btnStyle.BtnStyle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPanelConnexion implements ActionListener {
    private final VuePanelConnexion vue;

    public ControleurPanelConnexion(VuePanelConnexion vue) {
        this.vue = vue;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object o = actionEvent.getSource();
        if (!(o instanceof BtnStyle)) {
            throw new RuntimeException("Unexpected actionEvent source");
        }
        switch (((BtnStyle) o).getName()) {
            case "btnFonctionUtilisateur" :
                fonctionUtilisateur();
                break;
            case "btnSwitchConnexion" :
                updateUI(UtilisateurCourant.getInstance().switchConnexion());
                break;
        }
    }

    private void fonctionUtilisateur() {
        UtilisateurCourant bob = UtilisateurCourant.getInstance();
        FonctionsUtilisateurs.launch();
    }

    private void updateUI(ConnexionCourante connexionCourante) {
        switch (connexionCourante) {
            case ANNONYME :
                vue.setFoncionVisible(false);
                vue.setConnexionCourante("Deconnecté", "Se connecter");
                break;
            case ARBITRE:
                vue.setFoncionVisible(false);
                vue.setConnexionCourante("Arbitre", "Se déconencter");
                break;
            case GESTIONNAIRE:
                vue.setFonctionUtilisateur("créer tournoi", "btnCreerTournoi");
                vue.setFoncionVisible(true);
                vue.setConnexionCourante("Gestionnaire", "Se déconencter");
                break;
            case MANAGER:
                vue.setFonctionUtilisateur("A changer, ", "jsp quelle fonction");
                vue.setFoncionVisible(true);
                vue.setConnexionCourante("Manager", "Se déconencter");
                break;
        }
    }
}
