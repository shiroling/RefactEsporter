package application.services;

import nouveauModele.dataRepresentation.Jeu;
import nouveauModele.repositories.JeuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JeuService {

    private static JeuService instance;
    private JeuRepository repository;
    private JeuService() {
        this.repository = JeuRepository.getInstance();
    }

    public static JeuService getInstance() {
        if (instance == null) {
            instance = new JeuService();
        }
        return instance;
    }

    public List<String> getNomsJeuDisponibles() {
        return repository.getJeux().stream().map(Jeu::getNomJeu).toList();
    }
    public String[] getNomsJeux() {
        List<String> nomsJeux = repository.getJeux().stream().map(tournoi -> tournoi.getNomJeu()).collect(Collectors.toList());
        nomsJeux.add(0, "Tous");
        return nomsJeux.toArray(new String[nomsJeux.size()]);
    }

}
