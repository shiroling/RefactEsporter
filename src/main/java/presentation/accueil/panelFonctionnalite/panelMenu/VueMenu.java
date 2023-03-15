package presentation.accueil.panelFonctionnalite.panelMenu;

import presentation.accueil.panelFonctionnalite.panelMenu.panelSelection.PanelSelection;
import application.donneesPersistantes.Selection;
import javax.swing.*;
import java.awt.*;

public class VueMenu extends JPanel {
    private PanelSelection selectTournoi;
    private PanelSelection selectRencontre;
    private PanelSelection selectEquipe;
    private PanelSelection selectEcurie;
    private PanelSelection selectJeu;

    public VueMenu(){
        this.setLayout(new GridLayout(0, 1, 0, 0));
        selectTournoi = new PanelSelection( Selection.TOURNOI);
        selectRencontre = new PanelSelection( Selection.RENCONTRE);
        selectEquipe = new PanelSelection( Selection.EQUIPE);
        selectEcurie = new PanelSelection( Selection.ECURIE);
        selectJeu = new PanelSelection( Selection.JEU);
        this.add(selectTournoi);
        this.add(selectRencontre);
        this.add(selectEquipe);
        this.add(selectEcurie);
        this.add(selectJeu);
    }
    public void setSelected(Selection seclection) {
        deselectAll();
        switch (seclection) {
            case ECURIE -> selectEcurie.setSelectionne();
            case EQUIPE -> selectEquipe.setSelectionne();
            case RENCONTRE -> selectRencontre.setSelectionne();
            case JEU -> selectJeu.setSelectionne();
            case TOURNOI -> selectTournoi.setSelectionne();
        }
    }

    private void deselectAll() {
        this.selectTournoi.setDeselectionne();
        this.selectJeu.setDeselectionne();
        this.selectEcurie.setDeselectionne();
        this.selectEquipe.setDeselectionne();
        this.selectRencontre.setDeselectionne();
    }
}
