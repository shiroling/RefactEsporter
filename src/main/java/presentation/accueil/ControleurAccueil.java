package presentation.accueil;

import application.donneesPersistantes.ListeCourante;
import application.donneesPersistantes.ModeleGlobal;
import application.donneesPersistantes.Selection;
import application.filtres.Filtre;
import presentation.accueil.panelCartes.vuesCartes.Carte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurAccueil {
    private Selection etat;
    private VueAccueil vue;
    public ControleurAccueil(VueAccueil vue)   {
        this.vue = vue;
    }

    /**
     * La methode sert à remonter l'information des filtres de la VuePanelFiltre jusqu'à la couche Application
     * @param premierFiltre est le premier filtre d'une chaine de reponsabilite qui permet de filtrer les entitées affichées sous formes de cartes
     *                      null si aucun filtre n'est selectionné
     */


}
