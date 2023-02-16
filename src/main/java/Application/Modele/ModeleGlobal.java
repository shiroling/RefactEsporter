package Application.Modele;

import Modele.BDEntity;
import Modele.BDSelect;
import Presentation.Accueil.PanelMenu.PanelSelection.Selection;

import java.util.List;

public class ModeleGlobal {
    private List<? extends BDEntity> listeGrilleCourante;
    private User utilisateurCourant;

    public ModeleGlobal() {
        this.listeGrilleCourante = BDSelect.getListeTournois();
        this.utilisateurCourant = new User("x", "x");
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
