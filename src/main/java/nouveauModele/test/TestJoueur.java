package nouveauModele.test;

import application.services.JoueurService;
import nouveauModele.Joueur;
import nouveauModele.JoueurRepository;

import java.time.LocalDate;

public class TestJoueur {
    public static void main(String[] args) {


        Joueur joueurById = JoueurRepository.getInstance().findById(1);
        System.out.println(joueurById);
        Joueur joueurByPseudo = JoueurRepository.getInstance().findByPseudo("HyP");
        System.out.println(joueurByPseudo);

        System.out.println(
                JoueurService.getInstance().estValideJoueur("J", "JJ", "JJJ", LocalDate.now(), 255651)
        );
    }
}