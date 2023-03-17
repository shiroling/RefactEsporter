package presentation.accueil.panelCartes;

import presentation.accueil.panelCartes.vuesCartes.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TestCartes extends JFrame {
    public static void main(String[] args) {
        TestCartes test = testRencontre();
        test.setVisible(true);
    }
    private static TestCartes testEcurie() {
        TestCartes carteEcurie = new TestCartes();
        carteEcurie.setMinimumSize(new Dimension(1000,500));
        carteEcurie.setTitle("REMA");
        carteEcurie.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        carteEcurie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarteEcurie ce =  new CarteEcurie(12,"bouboule",14);
        carteEcurie.add(ce);
        System.out.println(ce);

        return carteEcurie;
    }

    private static TestCartes testJeu() {
        TestCartes carteRencontre = new TestCartes();
        carteRencontre.setMinimumSize(new Dimension(1000,500));
        carteRencontre.setTitle("REMA");
        carteRencontre.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        carteRencontre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarteJeu cr = new CarteJeu(2,"valorant", "valorantLogo.png");
        carteRencontre.add(cr);
        return carteRencontre;
    }

    private static TestCartes testTournoi() {
        TestCartes carteTounoi = new TestCartes();
        carteTounoi.setMinimumSize(new Dimension(1000,500));
        carteTounoi.setTitle("REMA");
        carteTounoi.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        carteTounoi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarteTournoi ct = new CarteTournoi(12, "Tournoi de teubés ( LyonEsport)", LocalDate.now(), LocalDate.now().minusDays(-3));
        carteTounoi.add(ct);
        return carteTounoi;
    }



    private static TestCartes testEquipe() {
        TestCartes carteEquipe = new TestCartes();
        carteEquipe.setMinimumSize(new Dimension(1000,500));
        carteEquipe.setTitle("REMA");
        carteEquipe.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        carteEquipe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarteEquipe ce = new CarteEquipe(2,420, "drop");
        carteEquipe.add(ce);
        return carteEquipe;
    }

    private static TestCartes testRencontre() {
        TestCartes carteEquipe = new TestCartes();
        carteEquipe.setMinimumSize(new Dimension(1000,500));
        carteEquipe.setTitle("REMA");
        carteEquipe.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        carteEquipe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarteRencontre ce = new CarteRencontre(2,1, "drop", LocalDate.now(), "oui 1", "non", 1);
        carteEquipe.add(ce);
        return carteEquipe;
    }
}
