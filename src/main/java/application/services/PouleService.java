package application.services;

import nouveauModele.*;

import java.util.List;
import java.util.function.Predicate;

import static modele.BDPredicats.estTournoiEnCours;

public class PouleService {

    private static PouleService instance;
    private PouleRepository repository;

    private PouleService() {
        repository = PouleRepository.getInstance();
    }

    public static PouleService getInstance() {
        if(instance == null) {
            instance = new PouleService();
        }
        return instance;
    }
    public static Predicate<Poule> estPouleFinale = p -> p.getFinale()== 1;
 }
