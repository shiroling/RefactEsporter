package modele.test;

import application.donneesPersistantes.Portee;
import application.services.TournoiService;
import modele.dataRepresentation.Tournoi;
import modele.repositories.TournoiRepository;

import java.time.LocalDate;

public class testCreationTournoi {

    public static void main(String[] args) {
        LocalDate dateFinInscription = LocalDate.of(2025, 10, 10);
        LocalDate debutTournoi = LocalDate.of(2025, 10, 11);
        LocalDate finTournoi = LocalDate.of(2025, 10, 12);
        System.out.println(debutTournoi +" "  + finTournoi + " "  +dateFinInscription);

        TournoiService service = TournoiService.getInstance();
        TournoiRepository repo = TournoiRepository.getInstance();
        service.enregistrerNouveauTournoi("TournoiTestInsertion", Portee.INTERNATIONAL, dateFinInscription, debutTournoi, finTournoi, 2, 1 );
        Tournoi tournoiTest = repo.findByNom("TournoiTestInsertion");
        System.out.println(tournoiTest);
        System.out.println(service.getEquipesInscrites(tournoiTest.getId()));
        System.out.println(service.getEtatTournoi(tournoiTest));

        service.inscrireEquipe(6, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        service.inscrireEquipe(11, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(7 , tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(8 , tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(9 , tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(10, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(12, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(13, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(14, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(15, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(16, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(17, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(18, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(19, tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(2 , tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));
        service.inscrireEquipe(5 , tournoiTest.getId());
        System.out.println(service.getEtatTournoi(tournoiTest));
        System.out.println(service.getNbParticipants(tournoiTest.getId()));

    }
}
