package application.modele;

import modele.BDEntity;
import modele.BDSelect;
import presentation.accueil.panelFonctionnalite.panelMenu.panelSelection.Selection;

import java.util.List;

public class ModeleGlobal {
    private static ModeleGlobal instance;
    private List<? extends BDEntity> listeGrilleCourante;
    private User utilisateurCourant;

    private ModeleGlobal() {
        this.listeGrilleCourante = BDSelect.getListeTournois();
        this.utilisateurCourant = new User("x", "x");
    }

    public static ModeleGlobal getInstance() {
        if (instance == null) {
            instance = new ModeleGlobal();
        }
        return instance;
    }

    public List<? extends BDEntity> getListeGrilleCourante() {
        return listeGrilleCourante;
    }

    public void updateListeCourante(Selection s) {
        switch (s)  {
            case ECURIE -> this.listeGrilleCourante = BDSelect.getListeEcurie();
            case EQUIPE -> this.listeGrilleCourante = BDSelect.getListeEquipes();
            case JEU -> this.listeGrilleCourante = BDSelect.getListeJeux();
            case RENCONTRE -> this.listeGrilleCourante = BDSelect.getListeRencontres();
            case TOURNOI -> this.listeGrilleCourante = BDSelect.getListeTournois();
        }
    }

    public User getUtilisateurCourant() {
        return utilisateurCourant;
    }

    public void setUtilisateurCourant(User utilisateurCourant) {
        this.utilisateurCourant = utilisateurCourant;
    }
}
