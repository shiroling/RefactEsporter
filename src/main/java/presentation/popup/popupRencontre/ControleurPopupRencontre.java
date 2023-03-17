package presentation.popup.popupRencontre;

import application.services.RencontreService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurPopupRencontre implements ActionListener {

    private PopupRencontre vue;

    public ControleurPopupRencontre(PopupRencontre vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch(btn.getName()) {
            case "btnRenseignerVainqueur":
                RencontreService.getInstance().afficherIndiquerVainqueur(this.vue.getIdRencontre());
        }
    }

}