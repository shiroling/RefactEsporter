package application.donneesPersistantes;

import application.filtres.Filtre;
import nouveauModele.repositories.*;

import java.util.LinkedList;
import java.util.List;

public class NouvelleListeCourante {

    private static NouvelleListeCourante instance;
    private List<?> listeCourante;

    private NouvelleListeCourante() {
        this.listeCourante = TournoiRepository.getInstance().getTournois();
    }

    public static NouvelleListeCourante getInstance() {
        if (instance == null) {
            instance = new NouvelleListeCourante();
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

