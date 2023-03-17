package modele.test;

import modele.dataRepresentation.Jeu;
import modele.repositories.JeuRepository;

public class TestJeu {
    public static void main(String[] args) {
        Jeu jeuTest = JeuRepository.getInstance().findById(1);
        System.out.println(jeuTest);
    }
}
