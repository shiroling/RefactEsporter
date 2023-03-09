package presentation.accueil.panelCartes;

import javassist.LoaderClassPath;
import presentation.accueil.panelCartes.vuesCartes.*;

import java.time.LocalDate;

public class UsineCarte {
    private static UsineCarte instance;
    private CarteEcurie carteEcurie;
    private CarteEquipe carteEquipe;
    private CarteJeu carteJeu;
    private CarteRencontre carteRencontre;
    private CarteTournoi carteTournoi;

    private UsineCarte() {
        this.carteEcurie = new CarteEcurie();
        this.carteEquipe = new CarteEquipe();
        this.carteJeu = new CarteJeu();
        this.carteRencontre = new CarteRencontre();
        this.carteTournoi = new CarteTournoi();
    }

    public static UsineCarte getInstance() {
        if(instance ==  null) {
            instance = new UsineCarte();
        }
        return instance;
    }

    public CarteEcurie getCarteEcurie(int idEcurie, String nomEcurie, int pointsEcurie) {
        CarteEcurie clone = (CarteEcurie) carteEcurie.clone();
        clone.setId(idEcurie);
        clone.setNomEcurie(nomEcurie);
        clone.setPoint(pointsEcurie);
        return clone;
    }

    public CarteEquipe getCarteEquipe(int idEquipe, int nbPoints, String nomEquipe) {
        CarteEquipe clone = (CarteEquipe) carteEquipe.clone();
        clone.setId(idEquipe);
        clone.setNombrePoint(nbPoints);
        clone.setNomEquipe(nomEquipe);
        return clone;
    }

    public CarteJeu getCarteJeu(int idJeu, String nomJeu, String nomLogo) {
        CarteJeu clone = (CarteJeu) carteJeu.clone();
        clone.setId(idJeu);
        clone.setNomJeu(nomJeu);
        clone.setLblLogoJeu(nomLogo);
        return clone;
    }

    public CarteRencontre getCarteRencontre(int idRencontre, int estFinale, String nomTournoi, LocalDate dateRencontre, String nomEquipe1, String nomEquipe2, int indexVaincueur) {
        CarteRencontre clone = (CarteRencontre) carteRencontre.clone();
        clone.setId(idRencontre);
        clone.setNomTournoi(estFinale, nomTournoi);
        clone.setDateRencontre(dateRencontre);
        clone.setNomEquipes(nomEquipe1, nomEquipe2, indexVaincueur);
        return clone;
    }

    public CarteTournoi getCarteTournoi(int idTournoi, String nomTournoi, LocalDate dateDebut, LocalDate dateFin) {
        CarteTournoi clone = (CarteTournoi) carteTournoi.clone();
        clone.setId(idTournoi);
        clone.setNomTournoi(nomTournoi);
        clone.setPanelDate(dateDebut, dateFin);
        return clone;
    }
}
