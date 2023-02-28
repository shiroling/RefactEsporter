package nouveauModele.test;

import application.services.EquipeService;
import nouveauModele.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestEquipe {
    public static void main(String[] args) {
        Equipe equipeParId = EquipeRepository.getInstance().findById(3);
        System.out.println(equipeParId);

        Equipe equipeParNom = EquipeRepository.getInstance().findByNom("les boulbis");
        System.out.println(equipeParNom);

        List<Joueur> lj = EquipeService.getInstance().getJoueurs(3);
        for (Joueur jjj: lj) {
            System.out.println(jjj);
        }
        List<Joueur> listeJoueurAEnregistrer = new ArrayList<>();
        listeJoueurAEnregistrer.add(new Joueur("J", "JJ", "JJJ", Date.from(Instant.now())));
        listeJoueurAEnregistrer.add(new Joueur("Ja", "JJ", "JaJ", Date.from(Instant.now())));
        listeJoueurAEnregistrer.add(new Joueur("Jb", "JJ", "JbJ", Date.from(Instant.now())));
        listeJoueurAEnregistrer.add(new Joueur("Jc", "JJ", "JcJ", Date.from(Instant.now())));
        EquipeService.getInstance().enregistrerNouvelleEquipe("les boulbisouson", 1, 2, lj);
    }
}