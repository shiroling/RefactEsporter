package presentation.accueil.panelFonctionnalite.panelFiltres;

import application.donneesPersistantes.Portee;
import application.donneesPersistantes.Selection;
import application.filtres.RepresentationFiltre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class VuePanelFiltres extends JPanel {
    ControleurPanelFiltres contoleur;
    public VuePanelFiltres(){
        contoleur = new ControleurPanelFiltres(this);
    }
    public static void main(String[] args) {
        // Création de la liste de filtres
        List<RepresentationFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new RepresentationFiltre("Avancement", new String[]{"Tous", "En Cours", "A Venir", "Finis"}));
        listeFiltres.add(new RepresentationFiltre("Inscription", new String[]{"Tous", "En Cours", "Finis"}));
        listeFiltres.add(new RepresentationFiltre("Multigaming", new String[]{"Tous", "Multigaming", "Jeu unique"}));
        listeFiltres.add(new RepresentationFiltre("Jeu", new String[]{"Fortnite", "Valorant", "Apex Legends"}));
        listeFiltres.add(new RepresentationFiltre("Portée", new String[]{"Local", "National", "International"}));

        // Création de la vue des filtres
        VuePanelFiltres vueFiltres = new VuePanelFiltres();
        vueFiltres.setToFiltres(listeFiltres);

        // Ajout de la vue des filtres à un JFrame
        JFrame fenetre = new JFrame("Exemple d'utilisation de setToFiltres");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.add(vueFiltres);
        fenetre.pack();
        fenetre.setVisible(true);
    }

    public List<String> getSelectedValues() {
        List<String> list  = new ArrayList<>();
        for (Component c :this.getComponents()) {
            list.add((((VueComboFiltre) c).getSelectedValue()));
        }
        return list;
    }
    public void setToFiltres(List<RepresentationFiltre> listeFiltres) {
        this.removeAll();
        if (listeFiltres != null) {
            this.setLayout(new GridLayout(listeFiltres.size(), 1, 0, 0));
            VueComboFiltre c = null;
            for (RepresentationFiltre filtre: listeFiltres) {
                c = new VueComboFiltre(filtre.nomFiltre(), filtre.optionsFiltre());
                c.addItemListener(contoleur);
                this.add(c);
            }
        }
        this.updateUI();
    }
}
