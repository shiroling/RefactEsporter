package nouveauModele.test;

import nouveauModele.dataRepresentation.Equipe;
import nouveauModele.repositories.EquipeRepository;

public class TestEquipe {
    public static void main(String[] args) {

        Equipe equipeParId = EquipeRepository.getInstance().findById(15);
/*        System.out.println(equipeParId);

        Equipe equipeParNom = EquipeRepository.getInstance().findByNom("les boulbis");
        System.out.println(equipeParNom);

        List<Joueur> lj = EquipeService.getInstance().getJoueurs(3);
        for (Joueur jjj: lj) {
            System.out.println(jjj);
        }
        List<Joueur> listeJoueurAEnregistrer = new ArrayList<>();
        listeJoueurAEnregistrer.add(new Joueur("J", "JJ", "JJJ", LocalDate.now()));
        listeJoueurAEnregistrer.add(new Joueur("Ja", "JJ", "JaJ", LocalDate.now()));
        listeJoueurAEnregistrer.add(new Joueur("Jb", "JJ", "JbJ", LocalDate.now()));
        listeJoueurAEnregistrer.add(new Joueur("Jc", "JJ", "JcJ", LocalDate.now()));
        EquipeService.getInstance().enregistrerNouvelleEquipe("les boulbisouson", 1, 2, lj);
    }


        System.out.println(EquipeRepository.getInstance().getNbFinalesGagnes(equipeParId) * 5);
        for (Tournoi t : EquipeRepository.getInstance().getTournoisJouees(equipeParId)) {
            System.out.println(t);
        }

        System.out.println(EquipeRepository.getInstance().getPoints(equipeParId));
    */
    }
}