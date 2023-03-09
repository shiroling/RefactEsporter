package presentation.accueil.panelCartes.controleursCarte;

import application.services.EcurieService;
import presentation.accueil.panelCartes.vuesCartes.Carte;

public class ControleurCarteEcurie extends ControleurCarte{
    public ControleurCarteEcurie(Carte vue) {
        super(vue);
    }

    @Override
    public void onClick() {
        EcurieService.getInstance().afficherPopupEcurie(getVue().getId());
    }
}
