package application.filtres;

import java.util.List;

public abstract class AbstractFiltre implements Filtre {
    protected Filtre nextHandler;

    @Override
    public void setNext(Filtre handler) {
        this.nextHandler = handler;
    }

    @Override
    public void filtrer(List l) {
        if (nextHandler != null) {
            nextHandler.filtrer(l);
        }
    }
}
