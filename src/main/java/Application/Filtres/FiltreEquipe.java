package Application.Filtres;

import Modele.Equipe;

import java.util.List;
import java.util.function.Predicate;

public class FiltreEquipe extends AbstractFiltre {

    private final Predicate<Equipe> predicat;

    public FiltreEquipe(Predicate<Equipe> p) {
        this.predicat = p;
    }

    @Override
    public void filtrer(List l) {
        l.removeIf(e -> !predicat.test((Equipe) e));
        super.filtrer(l);
    }
}