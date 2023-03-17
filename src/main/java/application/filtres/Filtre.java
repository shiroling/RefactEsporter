package application.filtres;

import java.util.List;

@FunctionalInterface
public interface Filtre<TypeAFiltrer> {
    List<TypeAFiltrer> filtrer(List<TypeAFiltrer> listeRencontre);
}
