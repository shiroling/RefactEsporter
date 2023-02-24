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
    private PanelSelection currentSelection;

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

    public void setCurrentSelection(PanelSelection currentSelection) {
        this.currentSelection = currentSelection;
        this.currentSelection.setPannelLineON();
    }

    public void setSelected(Selection seclection) {
        this.currentSelection.setPannelLineOFF();
        switch (seclection) {
            case ECURIE -> setCurrentSelection(this.selectEcurie);
            case EQUIPE -> setCurrentSelection(this.selectEquipe);
            case RENCONTRE -> setCurrentSelection(this.selectRencontre);
            case JEU -> setCurrentSelection(this.selectJeu);
            case TOURNOI -> setCurrentSelection(this.selectTournoi);
        }
    }

    public void setCurrentSelectionEquipes() {
    }

    public void setCurrentSelectionJeux() {
    }

    public void setCurrentSelectionEcurie() {
    }

    public void setCurrentSelectionRencontres() {
    }

    public void setCurrentSelectionTournois() {
    }
}
