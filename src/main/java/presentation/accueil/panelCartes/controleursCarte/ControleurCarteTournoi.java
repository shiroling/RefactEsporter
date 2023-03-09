package presentation.accueil.panelCartes.controleursCarte;

import application.services.TournoiService;
import modele.Tournoi;
import presentation.accueil.panelCartes.vuesCartes.Carte;

public class ControleurCarteTournoi extends ControleurCarte{
    public ControleurCarteTournoi(Carte vue) {
        super(vue);
    }

    @Override
    public void onClick() {
        TournoiService.getInstance().afficherPopupTournoi(getVue().getId());
    }
}
