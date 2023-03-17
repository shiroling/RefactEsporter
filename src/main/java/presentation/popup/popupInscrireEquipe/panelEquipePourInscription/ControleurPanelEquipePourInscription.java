package presentation.popup.popupInscrireEquipe.panelEquipePourInscription;

import presentation.popup.popupInscrireEquipe.PopupInscrireEquipe;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControleurPanelEquipePourInscription implements MouseListener {

    private PanelEquipePourInscription vue;
    private PopupInscrireEquipe popupContenant;

    public ControleurPanelEquipePourInscription(PanelEquipePourInscription vue, PopupInscrireEquipe popupContenant) {
        super();
        this.vue = vue;
        this.popupContenant = popupContenant;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        popupContenant.setEquipeSelectionee(this.vue.getNomEquipe());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.vue.setBackground(new Color(220,220,220));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.vue.setBackground(Color.WHITE);
    }

}