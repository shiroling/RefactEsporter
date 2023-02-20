package presentation.accueil.panelFonctionnalite.panelFiltres;

import javax.swing.*;
import java.awt.*;

public class VuePanelFiltres extends JPanel {
    public VuePanelFiltres(){

    }
    /*
    public void setFiltreTournois(){
        ControleurPanelFiltres itemListner = new ControleurPanelFiltres(this);
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
            comboFiltreAvencementTournoi.addItemListener(itemListner);
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
            comboFiltreInscriptionTournoi.addItemListener(itemListner);
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
            comboFiltreMultiTournoi.addItemListener(itemListner);
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
            comboFiltreJeuTournoi.addItemListener(itemListner);
            panelCombo.add(comboFiltreJeuTournoi);
        }
        {
            JPanel panelComboPortee = new JPanel();
            ths.add(panelComboPortee);
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


    public void setPanelFiltresRencontres() {
        this.getLblTitreFiltre().setVisible(true);
        this.removeAll();
        this.setLayout(new GridLayout(6, 1, 0, 0));

        ControleurPanelFiltres itemListner = new ControleurPanelFiltres(this);
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

            JComboBox<String> comboFiltreAvencementRencontre = new JComboBox<String>();
            comboFiltreAvencementRencontre.setFont(new Font("Tahoma", Font.PLAIN, 15));
            comboFiltreAvencementRencontre.setPreferredSize(new Dimension(140, 30));
            comboFiltreAvencementRencontre
                    .setModel(new DefaultComboBoxModel<String>(new String[] { "Tous", "A Venir", "Finis" }));
            comboFiltreAvencementRencontre.addItemListener(itemListner);
            panelCombo.add(comboFiltreAvencementRencontre);
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
        }
        {
            JPanel panelComboTournoi = new JPanel();
            this.add(panelComboTournoi);
            panelComboTournoi.setLayout(new GridLayout(0, 2, 0, 0));

            JLabel lblComboTournoi = new JLabel("Tournoi");
            lblComboTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
            JPanel panelComboLbl = new JPanel();
            FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
            flowLayout2.setAlignment(FlowLayout.LEFT);
            panelComboTournoi.add(panelComboLbl);
            panelComboLbl.add(lblComboTournoi);

            JPanel panelCombo = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
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
        }
        {
            JPanel panelComboEquipe = new JPanel();
            this.add(panelComboEquipe);
            panelComboEquipe.setLayout(new GridLayout(0, 2, 0, 0));

            JLabel lblComboEquipe = new JLabel("Equipe");
            lblComboEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
            JPanel panelComboLbl = new JPanel();
            FlowLayout flowLayout2 = (FlowLayout) panelComboLbl.getLayout();
            flowLayout2.setAlignment(FlowLayout.LEFT);
            panelComboEquipe.add(panelComboLbl);
            panelComboLbl.add(lblComboEquipe);

            JPanel panelCombo = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelCombo.getLayout();
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
        }
        this.updateUI();
    }

    public void setPanelFiltresEquipes() {
        this.vue.getLblTitreFiltre().setVisible(true);
        this.removeAll();
        this.setLayout(new GridLayout(6, 1, 0, 0));

        ControleurPanelFiltres itemListner = new ControleurPanelFiltres(this, ControleurPanelFiltres.Etat.EQUIPE);
        {
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
            comboFiltreEcuriesEquipe.addItemListener(itemListner);
            panelCombo.add(comboFiltreEcuriesEquipe);
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
            comboFiltreJeuEquipe.addItemListener(itemListner);
            panelCombo.add(comboFiltreJeuEquipe);
			
			/*
			JPanel panelCheckBoxClassement = new JPanel();
			this.add(panelCheckBoxClassement);
			panelCheckBoxClassement.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblCheckBox = new JLabel("Classement");
			lblCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
			panelCheckBoxClassement.add(lblCheckBox);
			
			ControleurStateChangeCheckBoxClassement ctrlChackBox = new ControleurStateChangeCheckBoxClassement(vue);
			
			JCheckBox trierClassement = new JCheckBox();
			trierClassement.addChangeListener(ctrlChackBox);
			panelCheckBoxClassement.add(trierClassement);


        }
        this.updateUI();
     */

/*
    }
    public void setPanelVide() {
        this.getLblTitreFiltre().setVisible(false);;
        this.removeAll();
    }
*/
}
