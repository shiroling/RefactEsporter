package presentation.accueil.panelCartes.controleursCarte;

import application.services.EquipeService;
import nouveauModele.repositories.EquipeRepository;
import presentation.accueil.panelCartes.vuesCartes.Carte;

public class ControleurCarteEquipe extends ControleurCarte{
    public ControleurCarteEquipe(Carte vue) {
        super(vue);
    }

    @Override
    public void onClick() {
        EquipeService.getInstance().afficherPopupEquipe(getVue().getId());
    }
}
