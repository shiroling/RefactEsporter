package presentation.accueil.panelCartes;

import presentation.accueil.panelCartes.vuesCartes.Carte;

import javax.swing.*;
import java.awt.*;

public class VuePanelCarte extends JPanel {
    private int tailleCarte;

    public void addCarte(Carte c ) {
        this.add(c);
        ajusterGrilleQuandAjout();
    }

    public VuePanelCarte() {
        setLayout(new GridLayout(12, 3, 40, 10));
    }


    /**
     * @author benli
     * ajuste la taille de la grille en fonction de la taille de la fenetre
     */

    public void ajusterGrille() {
        setVisible(true);
        int temp =getWidth();
        // si les cartes ont une largeure superieur a 300 pixel on reduit le nombre de colone pour ne pas avoir de scroll horizontaux

        if (temp < tailleCarte*2) {
            // on set la taille de la grille pour eviter d'avoir trop de colones
            // le +1 est pour de la securité au niveau de l'interface
            setLayout(new GridLayout(getComponentCount() + 1, 1, 20, 20));
        } else if (temp >= tailleCarte*2) {
            if (temp >= tailleCarte*3) {
                setLayout(new GridLayout((getComponentCount() / 3) + 1, 3, 20, 20));
            }else {
                setLayout(new GridLayout((getComponentCount() / 2) + 1, 2, 20, 20));
            }
        }


        //corriger problemes d'actualisation

        updateUI();
    }

    private void ajusterGrilleQuandAjout() {
        setLayout(new GridLayout((getComponentCount() / 4) + 1, 4, 20, 20));
        setVisible(true);
        tailleCarte=getComponent(0).getWidth();
        ajusterGrille();
    }


    /**
     * vide la gille principale
     */
    public void viderCartes() {
        tailleCarte=0;
        removeAll();
        updateUI();
    }


}
