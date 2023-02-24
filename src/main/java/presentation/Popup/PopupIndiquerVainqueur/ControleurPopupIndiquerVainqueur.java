package presentation.Popup.PopupIndiquerVainqueur;
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
                try {
                    this.vue.getRencontre().designerVainceur(this.vue.getVainqueur().getId());
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                this.vue.dispose();
                break;
            case "btnAnnuler" :
                this.vue.dispose();
                break;
        }
    }

}
