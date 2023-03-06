package presentation.accueil;

import application.donneesPersistantes.ModeleGlobal;
import application.donneesPersistantes.Selection;

public class ControleurAccueil {
    private Selection etat;
    private VueAccueil vue;
    public ControleurAccueil(VueAccueil vue) {
        this.vue = vue;
    }

    /**
     * La methode sert à remonter l'information des filtres de la VuePanelFiltre jusqu'à la couche Application
     * @param premierFiltre est le premier filtre d'une chaine de reponsabilite qui permet de filtrer les entitées affichées sous formes de cartes
     *                      null si aucun filtre n'est selectionné
     */
    /*
    public void nouveauFiltres(Filtre premierFiltre) {
        this.vue.getVueCarte().setCartes(ModeleGlobal.getInstance().getListeCouranteFiltree(premierFiltre));
    }*/

    public void changeState(Selection etat) {
        this.etat = etat;
        ModeleGlobal.getInstance().updateListeCourante(etat);
        this.vue.getVueCarte().setCartes(ModeleGlobal.getInstance().getListeCourante());
        switch (etat) {
            case ECURIE -> {
                this.vue.getVueFonctionalite().setAffichageEcurie();
                break;
            }
            case EQUIPE -> {
                this.vue.getVueFonctionalite().setAffichageEquipe();
                break;
            }
            case JEU -> {
                this.vue.getVueFonctionalite().setAffichageJeu();
                break;
            }
            case RENCONTRE -> {
                this.vue.getVueFonctionalite().setAffichageRencontre();
                break;
            }
            case TOURNOI -> {
                this.vue.getVueFonctionalite().setAffichageTournoi();
                break;
            }

        }
    }
}
