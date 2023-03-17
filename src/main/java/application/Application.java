package application;

import application.donneesPersistantes.*;
import application.filtres.RepresentationFiltre;
import application.services.EcurieService;
import application.services.EquipeService;
import application.services.JeuService;
import application.services.TournoiService;
import nouveauModele.repositories.EquipeRepository;
import nouveauModele.repositories.JeuRepository;
import nouveauModele.repositories.TournoiRepository;
import presentation.accueil.VueAccueil;
import presentation.Popup.PopupIndiquerVainqueur.PopupIndiquerVainqueur;
import modele.Equipe;
import modele.Rencontre;
import modele.Tournoi;
import presentation.connexion.VueConnexion;
import presentation.formCreerTournoi.VueFormCreerTournoi;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static Application instance;
    private VueAccueil vueAccueil;
    public static void main(String[] args) {
        //Application app = Application.getinstance();
        //app.runApp();
        VueFormCreerTournoi fen = new VueFormCreerTournoi(UtilisateurCourant.getInstance().getIdLog(), JeuService.getInstance().getNomsJeuDisponibles());
        fen.setVisible(true);
    }

    public static Application getinstance() {
        if(instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public void runApp() {
        ListeCourante.getInstance().updateListeCourante(Selection.TOURNOI);
        UtilisateurCourant.getInstance().deconnexion();
        vueAccueil =  new VueAccueil();
        vueAccueil.updateToState(Selection.TOURNOI, getFiltres(Selection.TOURNOI));
        vueAccueil.setVisible(true);
    }

    public void changerEtatAffichage(Selection select) {
        ListeCourante.getInstance().updateListeCourante(select);
        this.vueAccueil.updateToState(select, getFiltres(select));
    }

    private List<RepresentationFiltre> getFiltres(Selection s) {
        switch (s) {
            case TOURNOI : return getFiltresTournois();
            case RENCONTRE : return getFiltresRencontres();
            case EQUIPE : return getFiltresEquipes();
            default : return null;
        }
    }

    private List<RepresentationFiltre> getFiltresRencontres() {
        List<RepresentationFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new RepresentationFiltre("Avancement", new String[]{"Tous", "A Venir", "Finis"}));
        listeFiltres.add(new RepresentationFiltre("Jeu", JeuService.getInstance().getNomsJeux()));
        listeFiltres.add(new RepresentationFiltre("Tournoi", TournoiService.getInstance().getNomsTournois()));
        listeFiltres.add(new RepresentationFiltre("Equipe", EquipeService.getInstance().getNomsEquipes()));
        return listeFiltres;
    }


    private List<RepresentationFiltre> getFiltresEquipes() {
        List<RepresentationFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new RepresentationFiltre("Ecurie", EcurieService.getInstance().getNomsEcuries()));
        listeFiltres.add(new RepresentationFiltre("Jeu", JeuService.getInstance().getNomsJeux()));
        return listeFiltres;
    }

    private List<RepresentationFiltre> getFiltresTournois() {
        List<RepresentationFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new RepresentationFiltre("Avancement", new String[]{"Tous", "En Cours", "A Venir", "Finis"}));
        listeFiltres.add(new RepresentationFiltre("Inscription", new String[]{"Tous", "En Cours", "Finis"}));
        listeFiltres.add(new RepresentationFiltre("Multigaming", new String[]{"Tous", "Multigaming", "Jeu unique"}));
        listeFiltres.add(new RepresentationFiltre("Jeu", JeuService.getInstance().getNomsJeux()));
        listeFiltres.add(new RepresentationFiltre("Portée", Portee.toStrings()));
        return listeFiltres;
    }

    public void afficherFenetreConnexion() {
        VueConnexion fenetreConnexion = new VueConnexion();
        fenetreConnexion.setVisible(true);
    }

    public void procedureInitierInscrireEquipeAuTournoi(String nomTournoi) throws RuntimeException{
        if(!UtilisateurCourant.getInstance().getEtatConnexion().equals(ConnexionCourante.MANAGER)) {
            throw new RuntimeException("Utilisateur non connecté en tant que manager");
        }
        int idEcurie = UtilisateurCourant.getInstance().getIdLog();
        int idTournoi = TournoiService.getInstance().getIdTournoiFromNom(nomTournoi);
        TournoiService.getInstance().afficherPopupInscrireEquipe(idTournoi, idEcurie);
    }
    public static void procedureInscrireEquipe(Equipe equipeAInscrire, Tournoi tournoi) {
        //AppTournoi.getInstance().inscrireEquipe();
        tournoi.inscrireEquipe(equipeAInscrire);
        TournoiService.getInstance().afficherPopupTournoi(tournoi.getId());
    }

    public void inscrireEquipeAuTournoi(String nomEquipeSelectionee, String nomTournoi) {
        int idTournoi = TournoiRepository.getInstance().findByNom(nomTournoi).getId();
        int idEquipe = EquipeRepository.getInstance().findByNom(nomEquipeSelectionee).getIdEquipe();
        TournoiService.getInstance().inscrireEquipe(idEquipe, idTournoi);
        TournoiService.getInstance().afficherPopupTournoi(idTournoi);
    }

    public static void afficherPopupIndiquerVainqueurRencontre(Rencontre rencontre) {
        PopupIndiquerVainqueur indiquerVainqueur = new PopupIndiquerVainqueur(rencontre.getEquipes().get(0).getNom(), rencontre.getEquipes().get(1).getNom(), rencontre.getId());
        indiquerVainqueur.setVisible(true);
    }

    // Regarder si votre truc a mettre ici ne convient pas déjà à FonctionUtilisateurs
    // si il sagit d'un validateur (priére de le mettre dans le paquer du méme nom)
    // si il sagit d'un Filtre (priére de le mettre dans le paquer du méme nom)

    // si il sagit d'un truc en rapport avec la connexion checkez dans donneesPersistantes

    // sinon
    // fourrez tout ici, je ferais le tri

}
