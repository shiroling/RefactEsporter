package Application.Filtres;

import java.util.List;

public interface Filtre {
    void setNext(Filtre handler);
    void filtrer(List<?> l);
}