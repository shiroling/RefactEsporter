package presentation.accueil.panelFonctionnalite.panelFiltres;

import application.donneesPersistantes.Portee;
import application.donneesPersistantes.Selection;
import modele.*;

import java.awt.event.ItemListener;
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
        String[] argsd = {"cot", "côt"};
        String[] argsv = {"meu", "meuhhh"};
        List<VueComboFiltre> lcb = new ArrayList<>();
        lcb.add(new VueComboFiltre("pouet", argsd));
        lcb.add(new VueComboFiltre("vache", argsv));
        VuePanelFiltres pan = new VuePanelFiltres();
        pan.setPanelToFiltres(lcb);
        f.add(pan);
        f.setVisible(true);
        pan.getSelectedValues();
    }

    public void getSelectedValues() {
        for (Component c :this.getComponents()) {
            System.out.println(c);
        }


    }

    public void setPanelToFiltres(List<VueComboFiltre> listeFiltres) {
        this.removeAll();
        this.setLayout(new GridLayout(listeFiltres.size(), 1, 0, 0));
        for (VueComboFiltre filtre: listeFiltres) {
            filtre.addItemListener(contoleur);
            this.add(filtre);
        }
        this.updateUI();
        this.setVisible(true);
    }

    /*
    public void setFiltreTournois(){
        {
            JPanel panelComboAvancement = new JPanel();
            this.add(panelComboAvancement);
            panelComboAvancement.setLayout(new GridLayout(0, 2, 0, 0));

            JLabel lblComboAvencement = new JLabel("Avancement");
            lblComboAvencement.setFont(new Font("Tahoma", Font.PLAIN, 15));

            JPanel panelComboLbl = new JPanel();
            FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
            flowLayout2.setAlignment(FlowLayout.LEFT);
            panelComboAvancement.add(panelComboLbl);
            panelComboLbl.add(lblComboAvencement);

            JPanel panelCombo = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            panelComboAvancement.add(panelCombo);

            JComboBox<String> comboFiltreAvencementTournoi = new JComboBox<String>();
            comboFiltreAvencementTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
            comboFiltreAvencementTournoi.setPreferredSize(new Dimension(140, 30));
            comboFiltreAvencementTournoi
                    .setModel(new DefaultComboBoxModel<String>(new String[] { "Tous", "En Cours", "A Venir", "Finis" }));
            comboFiltreAvencementTournoi.addItemListener(null);
            panelCombo.add(comboFiltreAvencementTournoi);
        }
        {
            JPanel panelComboInscription = new JPanel();
            this.add(panelComboInscription);
            panelComboInscription.setLayout(new GridLayout(0, 2, 0, 0));

            JLabel lblComboInscription = new JLabel("Inscription");
            lblComboInscription.setFont(new Font("Tahoma", Font.PLAIN, 15));
            JPanel panelComboLbl = new JPanel();
            FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
            flowLayout2.setAlignment(FlowLayout.LEFT);
            panelComboInscription.add(panelComboLbl);
            panelComboLbl.add(lblComboInscription);

            JPanel panelCombo = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            panelComboInscription.add(panelCombo);

            JComboBox<String> comboFiltreInscriptionTournoi = new JComboBox<String>();
            comboFiltreInscriptionTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
            comboFiltreInscriptionTournoi.setPreferredSize(new Dimension(140, 30));
            comboFiltreInscriptionTournoi
                    .setModel(new DefaultComboBoxModel<String>(new String[] { "Tous", "En Cours", "Finis" }));
            comboFiltreInscriptionTournoi.addItemListener(null);
            panelCombo.add(comboFiltreInscriptionTournoi);
        }
        {
            JPanel panelComboMulti = new JPanel();
            this.add(panelComboMulti);
            panelComboMulti.setLayout(new GridLayout(0, 2, 0, 0));

            JLabel lblComboMulti = new JLabel("Multigaming");
            lblComboMulti.setFont(new Font("Tahoma", Font.PLAIN, 15));
            JPanel panelComboLbl = new JPanel();
            FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
            flowLayout2.setAlignment(FlowLayout.LEFT);
            panelComboMulti.add(panelComboLbl);
            panelComboLbl.add(lblComboMulti);

            JPanel panelCombo = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            panelComboMulti.add(panelCombo);

            JComboBox<String> comboFiltreMultiTournoi = new JComboBox<String>();
            comboFiltreMultiTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
            comboFiltreMultiTournoi.setPreferredSize(new Dimension(140, 30));
            comboFiltreMultiTournoi
                    .setModel(new DefaultComboBoxModel<String>(new String[] { "Tous", "Multigaming", "Jeu unique" }));
            comboFiltreMultiTournoi.addItemListener(null);
            panelCombo.add(comboFiltreMultiTournoi);
        }
        {
            JPanel panelComboJeu = new JPanel();
            this.add(panelComboJeu);
            panelComboJeu.setLayout(new GridLayout(0, 2, 0, 0));

            JLabel lblComboJeu = new JLabel("Jeu");
            lblComboJeu.setFont(new Font("Tahoma", Font.PLAIN, 15));
            JPanel panelComboLbl = new JPanel();
            FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
            flowLayout2.setAlignment(FlowLayout.LEFT);
            panelComboJeu.add(panelComboLbl);
            panelComboLbl.add(lblComboJeu);

            JPanel panelCombo = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            panelComboJeu.add(panelCombo);

            JComboBox<String> comboFiltreJeuTournoi = new JComboBox<String>();
            comboFiltreJeuTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
            comboFiltreJeuTournoi.setPreferredSize(new Dimension(140, 30));
            List<Jeu> jeux = BDSelect.getListeJeux();
            String[] nomJeux = new String[jeux.size() + 1];
            nomJeux[0] = "Tous";
            for (int i = 0; i < jeux.size(); i++) {
                nomJeux[i + 1] = jeux.get(i).getNom();
            }
            comboFiltreJeuTournoi.setModel(new DefaultComboBoxModel<String>(nomJeux));
            comboFiltreJeuTournoi.addItemListener(null);
            panelCombo.add(comboFiltreJeuTournoi);
        }
        {
            JPanel panelComboPortee = new JPanel();
            this.add(panelComboPortee);
            panelComboPortee.setLayout(new GridLayout(0, 2, 0, 0));

            JLabel lblComboPortee = new JLabel("Portée");
            lblComboPortee.setFont(new Font("Tahoma", Font.PLAIN, 15));
            JPanel panelComboLbl = new JPanel();
            FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
            flowLayout2.setAlignment(FlowLayout.LEFT);
            panelComboPortee.add(panelComboLbl);
            panelComboLbl.add(lblComboPortee);

            JPanel panelCombo = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            panelComboPortee.add(panelCombo);

            JComboBox<String> comboFiltrePorteeTournoi = new JComboBox<String>();
            comboFiltrePorteeTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
            comboFiltrePorteeTournoi.setPreferredSize(new Dimension(140, 30));

            String[] portees = Portee.toStrings();
            String[] porteesTous = new String[portees.length + 1];
            porteesTous[0] = "Tous";
            for (int i = 0; i < portees.length; i++) {
                porteesTous[i + 1] = portees[i];
            }
            comboFiltrePorteeTournoi.setModel(new DefaultComboBoxModel<String>(porteesTous));
            comboFiltrePorteeTournoi.addItemListener(itemListner);
            panelCombo.add(comboFiltrePorteeTournoi);
        }
        this.updateUI();
    }
    */
    /*
    public void setPanelFiltresRencontres() {
        this.setVisible(true);
        this.removeAll();
        this.setLayout(new GridLayout(6, 1, 0, 0));

        ControleurPanelFiltres itemListner = new ControleurPanelFiltres();

        //panelComboAvancement

        JPanel panelComboAvancement = new JPanel();
        this.add(panelComboAvancement);
        panelComboAvancement.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblComboAvencement = new JLabel("Avancement");
        lblComboAvencement.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JPanel panelComboLbl = new JPanel();
        FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        panelComboAvancement.add(panelComboLbl);
        panelComboLbl.add(lblComboAvencement);

        JPanel panelCombo = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelComboAvancement.add(panelCombo);

        JComboBox<String> comboFiltreAvencementRencontre = new JComboBox<String>();
        comboFiltreAvencementRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboFiltreAvencementRencontre.setPreferredSize(new Dimension(140, 30));
        comboFiltreAvencementRencontre
                .setModel(new DefaultComboBoxModel<String>(new String[] { "Tous", "A Venir", "Finis" }));
        comboFiltreAvencementRencontre.addItemListener(itemListner);
        panelCombo.add(comboFiltreAvencementRencontre);

        //panelComboJeu

        JPanel panelComboJeu = new JPanel();
        this.add(panelComboJeu);
        panelComboJeu.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblComboJeu = new JLabel("Jeu");
        lblComboJeu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelComboLbl = new JPanel();
        flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        panelComboJeu.add(panelComboLbl);
        panelComboLbl.add(lblComboJeu);

        panelCombo = new JPanel();
        flowLayout = (FlowLayout) panelCombo.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelComboJeu.add(panelCombo);

        JComboBox<String> comboFiltreJeuRencontre = new JComboBox<String>();
        comboFiltreJeuRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboFiltreJeuRencontre.setPreferredSize(new Dimension(140, 30));
        List<Jeu> jeux = BDSelect.getListeJeux();
        String[] nomJeux = new String[jeux.size() + 1];
        nomJeux[0] = "Tous";
        for (int i = 0; i < jeux.size(); i++) {
            nomJeux[i + 1] = jeux.get(i).getNom();
        }
        comboFiltreJeuRencontre.setModel(new DefaultComboBoxModel<String>(nomJeux));
        comboFiltreJeuRencontre.addItemListener(itemListner);
        panelCombo.add(comboFiltreJeuRencontre);

        //panelComboTournoi

        JPanel panelComboTournoi = new JPanel();
        this.add(panelComboTournoi);
        panelComboTournoi.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblComboTournoi = new JLabel("Tournoi");
        lblComboTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelComboLbl = new JPanel();
        flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        panelComboTournoi.add(panelComboLbl);
        panelComboLbl.add(lblComboTournoi);

        panelCombo = new JPanel();
        flowLayout = (FlowLayout) panelCombo.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelComboTournoi.add(panelCombo);

        JComboBox<String> comboFiltreTournoiRencontre = new JComboBox<String>();
        comboFiltreTournoiRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboFiltreTournoiRencontre.setPreferredSize(new Dimension(140, 30));
        List<Tournoi> tournois = BDSelect.getListeTournois();
        String[] nomTournois = new String[tournois.size() + 1];
        nomTournois[0] = "Tous";
        for (int i = 0; i < tournois.size(); i++) {
            nomTournois[i + 1] = tournois.get(i).getNom();
        }
        comboFiltreTournoiRencontre.setModel(new DefaultComboBoxModel<String>(nomTournois));
        comboFiltreTournoiRencontre.addItemListener(itemListner);
        panelCombo.add(comboFiltreTournoiRencontre);


        //panelComboEquipe

        JPanel panelComboEquipe = new JPanel();
        this.add(panelComboEquipe);
        panelComboEquipe.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblComboEquipe = new JLabel("Equipe");
        lblComboEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelComboLbl = new JPanel();
        flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        panelComboEquipe.add(panelComboLbl);
        panelComboLbl.add(lblComboEquipe);

        panelCombo = new JPanel();
        flowLayout = (FlowLayout) panelCombo.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelComboEquipe.add(panelCombo);

        JComboBox<String> comboFiltreEquipeRencontre = new JComboBox<String>();
        comboFiltreEquipeRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboFiltreEquipeRencontre.setPreferredSize(new Dimension(140, 30));
        List<Equipe> equipes = BDSelect.getListeEquipes();
        String[] nomEquipes = new String[equipes.size() + 1];
        nomEquipes[0] = "Tous";
        for (int i = 0; i < equipes.size(); i++) {
            nomEquipes[i + 1] = equipes.get(i).getNom();
        }
        comboFiltreEquipeRencontre.setModel(new DefaultComboBoxModel<String>(nomEquipes));
        comboFiltreEquipeRencontre.addItemListener(itemListner);
        panelCombo.add(comboFiltreEquipeRencontre);

        this.updateUI();
    }

    */

    /*
    public void setPanelFiltresEquipes() {

        //panelComboEcuries
        JPanel panelComboEcuries = new JPanel();
        this.add(panelComboEcuries);
        panelComboEcuries.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblComboEcuries = new JLabel("Ecuries");
        lblComboEcuries.setFont(new Font("Tahoma", Font.PLAIN, 15));
        JPanel panelComboLbl = new JPanel();
        FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        panelComboEcuries.add(panelComboLbl);
        panelComboLbl.add(lblComboEcuries);

        JPanel panelCombo = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelComboEcuries.add(panelCombo);

        JComboBox<String> comboFiltreEcuriesEquipe = new JComboBox<String>();
        comboFiltreEcuriesEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboFiltreEcuriesEquipe.setPreferredSize(new Dimension(140, 30));
        List<Ecurie> ecuries = BDSelect.getListeEcurie();
        String[] nomEcuries = new String[ecuries.size() + 1];
        nomEcuries[0] = "Tous";
        for (int i = 0; i < ecuries.size(); i++) {
            nomEcuries[i + 1] = ecuries.get(i).getNom();
        }
        comboFiltreEcuriesEquipe.setModel(new DefaultComboBoxModel<String>(nomEcuries));
        comboFiltreEcuriesEquipe.addItemListener(null);
        panelCombo.add(comboFiltreEcuriesEquipe);

        //panelComboJeu

        JPanel panelComboJeu = new JPanel();
        this.add(panelComboJeu);
        panelComboJeu.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblComboJeu = new JLabel("Jeu");
        lblComboJeu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelComboLbl = new JPanel();
        flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
        flowLayout2.setAlignment(FlowLayout.LEFT);
        panelComboJeu.add(panelComboLbl);
        panelComboLbl.add(lblComboJeu);

        panelCombo = new JPanel();
        flowLayout = (FlowLayout) panelCombo.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelComboJeu.add(panelCombo);

        JComboBox<String> comboFiltreJeuEquipe = new JComboBox<String>();
        comboFiltreJeuEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboFiltreJeuEquipe.setPreferredSize(new Dimension(140, 30));
        List<Jeu> jeux = BDSelect.getListeJeux();
        String[] nomJeux = new String[jeux.size() + 1];
        nomJeux[0] = "Tous";
        for (int i = 0; i < jeux.size(); i++) {
            nomJeux[i + 1] = jeux.get(i).getNom();
        }
        comboFiltreJeuEquipe.setModel(new DefaultComboBoxModel<String>(nomJeux));
        comboFiltreJeuEquipe.addItemListener(null);
        panelCombo.add(comboFiltreJeuEquipe);



        this.updateUI();

    }*/


    public void setPanelVide() {
        this.removeAll();
    }
    public void setFiltres(Selection ecurie) {

    }
}
