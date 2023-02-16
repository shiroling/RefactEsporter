package application.filtres;

import modele.Equipe;

import java.util.List;
import java.util.function.Predicate;

public class FiltreEquipe extends AbstractFiltre {

    private final Predicate<Object> predicat;

    public FiltreEquipe(Predicate<Object> p) {
        this.predicat = p;
    }

    @Override
    public void filtrer(List l) {
        if (l.get(0) instanceof Equipe) {
            l.removeIf(e -> !predicat.test((Equipe) e));
            super.filtrer(l);
        } else {
            throw new IllegalArgumentException();
        }
    }
}