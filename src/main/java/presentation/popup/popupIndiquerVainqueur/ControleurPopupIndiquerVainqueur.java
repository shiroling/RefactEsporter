package presentation.popup.popupIndiquerVainqueur;
import application.services.RencontreService;
import presentation.style.btnStyle.BtnStyle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControleurPopupIndiquerVainqueur implements ActionListener {

    private PopupIndiquerVainqueur vue;

    public ControleurPopupIndiquerVainqueur(PopupIndiquerVainqueur vue) {
        super();
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BtnStyle btn = (BtnStyle) e.getSource();

        switch (btn.getName())	{
            case "btnConfirmer" :
                RencontreService.getInstance().designerVainqueur(vue.getNomEquipeVainqueur(), vue.getIdRencontre());
                this.vue.dispose();
                break;
            case "btnAnnuler" :
                this.vue.dispose();
                break;
        }
    }

}
