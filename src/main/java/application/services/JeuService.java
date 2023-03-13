package application.services;

import nouveauModele.dataRepresentation.Jeu;
import nouveauModele.repositories.JeuRepository;

import java.util.ArrayList;
import java.util.List;

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
}
