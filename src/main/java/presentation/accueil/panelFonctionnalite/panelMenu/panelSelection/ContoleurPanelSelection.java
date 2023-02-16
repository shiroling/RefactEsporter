package presentation.accueil.panelFonctionnalite.panelMenu.panelSelection;

import application.acceuil.GrilleCartes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ContoleurPanelSelection implements MouseListener{

    private PanelSelection vue;
    private Selection select;

    public ContoleurPanelSelection(PanelSelection vue, Selection selection) {
        super();
        this.vue = vue;
        this.select = selection;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GrilleCartes.updateTo(select);
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
