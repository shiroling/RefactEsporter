package presentation.accueil.panelCartes.controleursCarte;

import application.services.RencontreService;
import presentation.accueil.panelCartes.vuesCartes.Carte;

public class ControleurCarteRencontre extends ControleurCarte{
    public ControleurCarteRencontre(Carte vue) {
        super(vue);
    }

    @Override
    public void onClick() {
        RencontreService.getInstance().afficherPopupRencontre(getVue().getId());
    }
}
