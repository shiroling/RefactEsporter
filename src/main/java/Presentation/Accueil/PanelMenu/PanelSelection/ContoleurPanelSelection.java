package Presentation.Accueil.PanelMenu.PanelSelection;

package controleur_ihm;

import Presentation.Accueil.PanelMenu.Selection;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ContoleurPanelSelection implements MouseListener{

    private PanelSelection vue;
    private Selection select;

    public ContoleurPanelSelection(PanelSelection vue, Selection select, Accueil vueAccueil) {
        super();
        this.vue = vue;
        this.select = select;
        this.vueAccueil = vueAccueil;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ControleurAccueil ctrlAcceuil = Accueil.getControleur();

        switch(this.select) {
            case TOURNOI:
                ctrlAcceuil.setPanelFiltresTournois();
                ctrlAcceuil.updateTournois();
                vueAccueil.viderCartes();
                vueAccueil.ajouterCartesTournois(ctrlAcceuil.getTournois());
                vueAccueil.getLblTitreCartes().setText("Tournois");
                vueAccueil.ajusterGrille();
                break;
            case RENCONTRE:
                Accueil.getControleur().setPanelFiltresRencontres();
                ctrlAcceuil.updateRencontres();
                vueAccueil.viderCartes();
                vueAccueil.getLblTitreCartes().setText("Matchs");
                vueAccueil.ajouterCartesMatch(ctrlAcceuil.getRencontres());
                vueAccueil.ajusterGrille();
                break;
            case JEU:
                Accueil.getControleur().setPanelVide();
                ctrlAcceuil.updateJeux();
                vueAccueil.viderCartes();
                vueAccueil.ajouterCartesJeu(ctrlAcceuil.getJeux());
                vueAccueil.getLblTitreCartes().setText("Jeux");
                vueAccueil.ajusterGrille();
                break;
            case EQUIPE:
                Accueil.getControleur().setPanelFiltresEquipes();
                ctrlAcceuil.updateEquipes();
                vueAccueil.viderCartes();
                vueAccueil.ajouterCartesEquipe(ctrlAcceuil.getEquipes());
                vueAccueil.getLblTitreCartes().setText("Equipes");
                vueAccueil.ajusterGrille();
                break;
            case ECURIE:
                Accueil.getControleur().setPanelVide();
                ctrlAcceuil.updateEcuries();
                vueAccueil.viderCartes();
                vueAccueil.ajouterCartesEcurie(ctrlAcceuil.getEcuries());
                vueAccueil.getLblTitreCartes().setText("Ecuries");
                vueAccueil.ajusterGrille();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vue.setPannelLineOver(10);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vue.setPannelLineOver(0);
    }

}
