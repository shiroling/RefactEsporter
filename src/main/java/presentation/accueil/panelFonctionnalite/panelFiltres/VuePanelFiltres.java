package presentation.accueil.panelFonctionnalite.panelFiltres;

import application.donneesPersistantes.Portee;
import application.donneesPersistantes.Selection;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class VuePanelFiltres extends JPanel {
    ControleurPanelFiltres contoleur;
    public VuePanelFiltres(){
        contoleur = new ControleurPanelFiltres(this);
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        VuePanelFiltres pan = new VuePanelFiltres();
        //pan.setFiltreTournois();
        f.add(pan);
        f.setVisible(true);
        pan.getSelectedValues();
    }

    public void getSelectedValues() {
        for (Component c : this.getComponents()) {
            System.out.println((((VueComboFiltre) c).getSelectedValue()));
        }
    }
    public void setToFiltres(List<VueComboFiltre> listeFiltres) {
        this.removeAll();
        this.setLayout(new GridLayout(listeFiltres.size(), 1, 0, 0));
        for (VueComboFiltre filtre: listeFiltres) {
            filtre.addItemListener(contoleur);
            this.add(filtre);
        }
        this.updateUI();
        this.setVisible(true);
    }
    public void setFiltreTournois(String[] nomJeux) {
        List<VueComboFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new VueComboFiltre("Avancement", new String[]{"Tous", "En Cours", "A Venir", "Finis"}));
        listeFiltres.add(new VueComboFiltre("Inscription", new String[]{"Tous", "En Cours", "Finis"}));
        listeFiltres.add(new VueComboFiltre("Multigaming", new String[]{"Tous", "Multigaming", "Jeu unique"}));
        listeFiltres.add(new VueComboFiltre("Jeu", nomJeux));
        listeFiltres.add(new VueComboFiltre("Portée", Portee.toStrings()));
        setToFiltres(listeFiltres);
    }

    public void setFiltreRencontres(String[] nomTournois,String[] nomEquipes, String[] nomJeux) {
        List<VueComboFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new VueComboFiltre("Avancement", new String[]{"Tous", "A Venir", "Finis"}));
        listeFiltres.add(new VueComboFiltre("Jeu", nomJeux));
        listeFiltres.add(new VueComboFiltre("Tournoi", nomTournois));
        listeFiltres.add(new VueComboFiltre("Equipe", nomEquipes));
        setToFiltres(listeFiltres);
    }
    public void setPanelFiltresEquipes(String[] nomEcuries, String[] nomJeux) {
        List<VueComboFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new VueComboFiltre("Ecuries", nomEcuries));
        listeFiltres.add(new VueComboFiltre("Jeu", nomJeux));
        setToFiltres(listeFiltres);
    }
    public void setPanelVide() {
        this.removeAll();
    }
}
