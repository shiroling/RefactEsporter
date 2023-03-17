package application.services;

import modele.dataRepresentation.Equipe;
import modele.dataRepresentation.Poule;
import modele.dataRepresentation.Rencontre;
import modele.repositories.PouleRepository;
import modele.repositories.RencontreRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

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
    public Equipe getResultat(Poule poule) {
        Equipe equipeTemp = null;
        Map<Equipe, Integer> winMap = new HashMap<>();
        List<Equipe> participants = PouleRepository.getInstance().getEquipes(poule);
        for (Equipe e: participants) {
            winMap.put(e, 0);
        }
        for (Rencontre r: PouleRepository.getInstance().getRencontres(poule)) {
            equipeTemp = RencontreRepository.getInstance().getGagnant(r);
            if(equipeTemp != null) {
                winMap.put(equipeTemp, winMap.get(equipeTemp)+1);
            }
        }
        EquipeService serviceEquipe = EquipeService.getInstance();
        int bestScore = -1;
        int tempScore = -1;
        for (Equipe e: participants) {
            tempScore = winMap.get(e);
            if (tempScore > bestScore) {
                bestScore = tempScore;
                equipeTemp = e;
            }

            if (tempScore == bestScore && serviceEquipe.getAgeMoyen(equipeTemp) > serviceEquipe.getAgeMoyen(e) ) {
                equipeTemp = e;
            }
        }
        return equipeTemp;
    }
}
