package application.donneesPersistantes;

import modele.BDEntity;
import modele.BDSelect;

import java.util.LinkedList;
import java.util.List;

public class ModeleGlobal {
    private static ModeleGlobal instance;
    private List<? extends BDEntity> listeGrilleCourante;

    private ModeleGlobal() {
        this.listeGrilleCourante = BDSelect.getListeTournois();
    }

    public static ModeleGlobal getInstance() {
        if (instance == null) {
            instance = new ModeleGlobal();
        }
        return instance;
    }

    public List<? extends BDEntity> getListeCourante() {
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
/*
    public List<? extends BDEntity> getListeCouranteFiltree(Filtre filtre) {
        List<BDEntity> listeFiltre = new LinkedList<>();
        for (BDEntity b : this.listeGrilleCourante) {
            listeFiltre.add(b);
        }
        filtre.filtrer(this.listeGrilleCourante);
        return listeFiltre;
    }

 */
}
