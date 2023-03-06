package application.filtres;

import nouveauModele.dataRepresentation.Rencontre;

import java.util.List;

@FunctionalInterface
public interface Filtre<TypeAFiltrer> {
    List<TypeAFiltrer> filtrer(List<TypeAFiltrer> listeRencontre);
}
