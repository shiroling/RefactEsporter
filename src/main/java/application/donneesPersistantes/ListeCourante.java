package application.donneesPersistantes;

import application.filtres.Filtre;
import nouveauModele.repositories.*;

import java.util.List;

public class ListeCourante {

    private static ListeCourante instance;
    private List<?> listeCourante;

    private ListeCourante() {
        this.listeCourante = TournoiRepository.getInstance().getTournois();
    }

    public static ListeCourante getInstance() {
        if (instance == null) {
            instance = new ListeCourante();
        }
        return instance;
    }

    public List<?> getListeCourante() {
        return listeCourante;
    }

    public void updateListeCourante(Selection s) {
        switch (s)  {
            case ECURIE -> this.listeCourante = EcurieRepository.getInstance().getEcuries();
            case EQUIPE -> this.listeCourante = EquipeRepository.getInstance().getEquipes();
            case JEU -> this.listeCourante = JeuRepository.getInstance().getJeux();
            case RENCONTRE -> this.listeCourante = RencontreRepository.getInstance().getRencontres();
            case TOURNOI -> this.listeCourante = TournoiRepository.getInstance().getTournois();
        }
    }

    public List<?> getListeCouranteFiltree(Filtre filtre) {
        List<?> listeFiltre = filtre.filtrer(this.listeCourante);
        return listeFiltre;
    }
}

