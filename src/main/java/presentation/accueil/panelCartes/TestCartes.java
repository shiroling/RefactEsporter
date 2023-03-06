package presentation.accueil.panelCartes;

import presentation.accueil.panelCartes.vuesCartes.CarteEquipe;
import presentation.accueil.panelCartes.vuesCartes.CarteRencontre;

import javax.swing.*;
import java.awt.*;

public class TestCartes extends JFrame {
    public TestCartes(){
        this.setMinimumSize(new Dimension(1000,500));
        this.setTitle("REMA");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Pour l'app directement en full screen décommenter cette ligne
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CarteEquipe());
    }

    public static void main(String[] args) {
        TestCartes test = new TestCartes();
        test.setVisible(true);

    }
}
