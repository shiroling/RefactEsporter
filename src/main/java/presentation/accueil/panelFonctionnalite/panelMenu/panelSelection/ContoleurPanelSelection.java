package presentation.accueil.panelFonctionnalite.panelMenu.panelSelection;

import application.Application;
import application.acceuil.GrilleCartes;
import application.donneesPersistantes.Selection;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ContoleurPanelSelection implements MouseListener{

    private PanelSelection vue;
    private Selection select;
    boolean estSelectionne;

    public ContoleurPanelSelection(PanelSelection vue, Selection selection) {
        super();
        this.vue = vue;
        this.select = selection;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Application.getinstance().changerEtatAffichage(this.select);
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
        vue.setPannelLineON();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!estSelectionne) {
            vue.setPannelLineOFF();
        }
    }

}
