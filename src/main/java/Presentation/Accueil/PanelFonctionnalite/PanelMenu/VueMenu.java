package Presentation.Accueil.PanelFonctionnalite.PanelMenu;

import Presentation.Accueil.PanelFonctionnalite.PanelMenu.PanelSelection.PanelSelection;

import javax.swing.*;
import java.awt.*;

public class VueMenu extends JPanel {

    public VueMenu(){
        this.setLayout(new GridLayout(0, 1, 0, 0));
        //this.setLayout(new GridLayout(0, 2, 20, 20));

		/*JPanel panelEspaceFoctionalite = new JPanel();
		panelEspaceFoctionalite.setPreferredSize(new Dimension(0, 20));
		this.add(panelEspaceFoctionalite, BorderLayout.NORTH);*/

        PanelSelection selectTournoi = new PanelSelection( Selection.TOURNOI);
        PanelSelection selectRencontre = new PanelSelection( Selection.RENCONTRE);
        PanelSelection selectEquipe = new PanelSelection( Selection.EQUIPE);
        PanelSelection selectEcurie = new PanelSelection( Selection.ECURIE);

        this.add(selectTournoi);
        this.add(selectRencontre);
        this.add(selectEquipe);
        this.add(selectEcurie);
        PanelSelection selectJeu = new PanelSelection( Selection.JEU);
        this.add(selectJeu);


    }

}
