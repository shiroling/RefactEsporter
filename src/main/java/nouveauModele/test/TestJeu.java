package nouveauModele.test;

import nouveauModele.Jeu;
import nouveauModele.JeuRepository;

public class TestJeu {
    public static void main(String[] args) {
        Jeu jeuTest = JeuRepository.getInstance().findById(1);
        System.out.println(jeuTest);
    }
}
