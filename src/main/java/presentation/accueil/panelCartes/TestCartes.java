package presentation.accueil.panelCartes;

import presentation.accueil.panelCartes.vuesCartes.CarteEcurie;
import presentation.accueil.panelCartes.vuesCartes.CarteEquipe;
import presentation.accueil.panelCartes.vuesCartes.CarteRencontre;
import presentation.accueil.panelCartes.vuesCartes.CarteTournoi;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TestCartes extends JFrame {
    public TestCartes(){
        this.setMinimumSize(new Dimension(1000,500));
        this.setTitle("REMA");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UsineCarte uC = UsineCarte.getInstance();
        CarteTournoi ce = uC.getCarteTournoi(12,"bouboule", LocalDate.now(),LocalDate.now());
        add(ce);
    }

    public static void main(String[] args) {
        TestCartes test = new TestCartes();
        test.setVisible(true);

    }
}
