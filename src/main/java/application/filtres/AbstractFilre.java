package application.filtres;

import java.util.List;

public class AbstractFilre {
    Filtre next;
    public void setNext(Filtre next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public List filtrer(List listeAFiltrer) {
        if (this.hasNext()) {
            next.filtrer(listeAFiltrer);
        }
        return listeAFiltrer;
    }
}
