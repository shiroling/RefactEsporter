package presentation.accueil.panelFonctionnalite.panelFiltres;

public class ControleurPanelFiltres {
    public enum Etat {
        TOURNOI, RENCONTRE, JEU, EQUIPE, ECURIE;
    }
    private final VuePanelFiltres vue;


    public ControleurPanelFiltres(VuePanelFiltres vue) {
        this.vue = vue;
    }


}
