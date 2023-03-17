package application.filtres;

import modele.dataRepresentation.Equipe;
import modele.dataRepresentation.Rencontre;
import modele.dataRepresentation.Tournoi;
import modele.repositories.EquipeRepository;
import modele.repositories.RencontreRepository;
import modele.repositories.TournoiRepository;

import java.util.List;

public class testFiltre {






    public static void main(String[] args) {
        Tournoi tournoi = TournoiRepository.getInstance().findById(262);

        List<Rencontre> lr = RencontreRepository.getInstance().getRencontres();
        for (Rencontre r : lr) {
            System.out.println(" Est dans tournoi : " + (r.getPoule().getTournoi().getId()== tournoi.getId()) + "  ---  " + r);
        }

        FiltresRencontre filtreParTournoi = FiltresRencontre.getFiltreParTournoi(tournoi);

        Equipe equipe = EquipeRepository.getInstance().findById(15);
        filtreParTournoi.setNext(FiltresRencontre.getFiltreParEquipe(equipe));

        filtreParTournoi.filtrer(lr);
        for (Rencontre r : lr) {
            System.out.println(" Est bien trié : " + (r.getPoule().getTournoi().getId()== tournoi.getId()) + "  ---  " + r);
        }


    }

}
