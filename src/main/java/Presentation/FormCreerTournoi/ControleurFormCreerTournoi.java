package Presentation.FormCreerTournoi;

import Application.Application;
import Application.Mois;
import Application.Portee;
import Application.PreDate;
import Model.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static Application.Application.insererTournoi;

public class ControleurFormCreerTournoi implements ActionListener {
    private VueFormCreerTournoi vue;
    private JButton btn;
    private List<Jeu> jeux;

    public ControleurFormCreerTournoi(VueFormCreerTournoi vue) {
        this.vue = vue;
        this.jeux = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        this.btn = (JButton) e.getSource();
        switch (btn.getName()) {
            case "btnAjouterJeu": //Ajoute un jeu au Tournoi
                this.jeux.add(Jeu.getJeuFromName(this.vue.getComboJeux().getSelectedItem().toString()));// Stockage du jeu selectionné
                this.vue.getPanelJeuxAjoutes().setLayout(new GridLayout(this.jeux.size(), 1, 0, 0));
                JLabel lblNomJeu = new JLabel(this.vue.getComboJeux().getSelectedItem().toString()); // Créer le label concernant le jeu selectionné dans le combo
                this.vue.getPanelJeuxAjoutes().add(lblNomJeu);        // Ajout du label dans le pannel
                this.vue.getPanelJeuxAjoutes().updateUI();        // Maj du panel
                this.vue.getComboJeux().removeItem(this.vue.getComboJeux().getSelectedItem()); // Enleve le jeu du combo apres l'avoir ajouté
                if (this.vue.getComboJeux().getItemCount() == 0) {        // Si il n'y a plus de jeu rendre invisible le bouton et le combo
                    this.vue.getComboJeux().setVisible(false);
                    this.vue.getBtnAjouterJeux().setVisible(false);
                }
                break;
            case "btnInserer": //Insère un Tournoi
                //Si le champs Nom est vide, alors mettre le label du champs en rouge + l'initulé vide.
                if (this.vue.getTextFieldNom().getText().compareTo("") == 0 && !(this.vue.getLabelNom().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelNom().setText(this.vue.getLabelNom().getText() + "      *vide*");
                    this.vue.getLabelNom().setForeground(new Color(255, 0, 0));
                } else if (!(this.vue.getTextFieldNom().getText().compareTo("") == 0)) {
                    this.vue.getLabelNom().setText("Nom ");
                    this.vue.getLabelNom().setForeground(new Color(51, 51, 51));
                }

                //Si le champs Jeux est vide, alors mettre le label du champs en rouge + l'initulé vide.
                if (this.jeux.size() == 0 && !(this.vue.getLabelJeuxAjoutes().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelJeuxAjoutes().setText(this.vue.getLabelJeuxAjoutes().getText() + "      *vide*");
                    this.vue.getLabelJeuxAjoutes().setForeground(new Color(255, 0, 0));
                } else if (this.jeux.size() != 0) {
                    this.vue.getLabelJeuxAjoutes().setText("Jeux Ajoutés :");
                    this.vue.getLabelJeuxAjoutes().setForeground(new Color(51, 51, 51));
                }


                PreDate dateDebutTournois = new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeDebutTournoi()), Mois.stringToMois(this.vue.getSelectedValueComboMoiDebutTournoi()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourDebutTournoi()));
                //Si la date n'est pas valide, alors mettre le libellé en rouge
                if (dateDebutTournois.estDateValide() && !dateDebutTournois.estPassee()) {
                    this.vue.getLabelDateDebutTournoi().setText("Date Début Tournoi");
                    this.vue.getLabelDateDebutTournoi().setForeground(new Color(51, 51, 51));
                } else if (!(this.vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelDateDebutTournoi().setText(this.vue.getLabelDateDebutTournoi().getText() + "*");
                    this.vue.getLabelDateDebutTournoi().setForeground(new Color(255, 0, 0));
                }

                PreDate dateFinTournois = new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeFinTournoi()), Mois.stringToMois(this.vue.getSelectedValueComboMoiFinTournoi()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourFinTournoi()));
                //Si la date n'est pas valide, alors mettre le libellé en rouge
                if (dateFinTournois.estDateValide() && !dateFinTournois.estPassee()) {
                    this.vue.getLabelDateFinTournoi().setText("Date Fin Tournoi");
                    this.vue.getLabelDateFinTournoi().setForeground(new Color(51, 51, 51));
                } else if (!(this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelDateFinTournoi().setText(this.vue.getLabelDateFinTournoi().getText() + "*");
                    this.vue.getLabelDateFinTournoi().setForeground(new Color(255, 0, 0));
                }

                PreDate dateFinInscription = new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeFinInscription()), Mois.stringToMois(this.vue.getSelectedValueComboMoiFinInscription()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourFinInscription()));
                //Si la date n'est pas valide, alors mettre le libellé en rouge
                if (dateFinInscription.estDateValide() && !dateFinInscription.estPassee()) {
                    this.vue.getLabelDateFinInscription().setText("Date Fin Inscription");
                    this.vue.getLabelDateFinInscription().setForeground(new Color(51, 51, 51));
                } else if (!(this.vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelDateFinInscription().setText(this.vue.getLabelDateFinInscription().getText() + "*");
                    this.vue.getLabelDateFinInscription().setForeground(new Color(255, 0, 0));
                }


                //Si la date Fin tournoi est avant la Date debut Tournoi, alors mettre les deux libélé en Rouge
                if (dateFinTournois.toDate().compareTo(dateDebutTournois.toDate()) < 0) {
                    if (!(this.vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0)))) {
                        this.vue.getLabelDateDebutTournoi().setText(this.vue.getLabelDateDebutTournoi().getText() + "*");
                        this.vue.getLabelDateDebutTournoi().setForeground(new Color(255, 0, 0));
                    }
                    if (!(this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)))) {
                        this.vue.getLabelDateFinTournoi().setText(this.vue.getLabelDateFinTournoi().getText() + "*");
                        this.vue.getLabelDateFinTournoi().setForeground(new Color(255, 0, 0));
                    }
                }

                //Si la date d'inscription est après la date de début tournoi, alors mettre le libellé en rouge
                if (dateFinInscription.toDate().compareTo(dateDebutTournois.toDate()) > 0) {
                    if (!(this.vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0)))) {
                        this.vue.getLabelDateFinInscription().setText(this.vue.getLabelDateFinInscription().getText() + "*");
                        this.vue.getLabelDateFinInscription().setForeground(new Color(255, 0, 0));
                    }
                }

                //Si le formulaire est valide alors inser le tournoi.
                if (this.estFormulaireValide()) {
                    //Verifie si le tournoi est multigaming ou non.
                    if (this.jeux.size() == 1) {
                        Application.insererTournoi(this.vue.getTextFieldNom().getText(), Portee.stringToPortee(this.vue.getComboPortee().getSelectedItem().toString()), dateFinInscription.toDate(), dateDebutTournois.toDate(), dateFinTournois.toDate(), this.jeux.get(0), this.vue.getIdGerant());
                    } else {
                        Application.insererTournoisMultigaming(this.vue.getTextFieldNom().getText(), Portee.stringToPortee(this.vue.getComboPortee().getSelectedItem().toString()), dateFinInscription.toDate(), dateDebutTournois.toDate(), dateFinTournois.toDate(), this.jeux, this.vue.getIdGerant());
                    }
                    this.vue.dispose();
                }
                break;
            case "btnCancel": //Ferme le formulaire de création de tournoi
                this.vue.dispose();
                break;
        }

    }

    private boolean estFormulaireValide() {
        return !this.vue.getLabelNom().getForeground().equals(new Color(255, 0, 0)) &&
                !this.vue.getLabelJeuxAjoutes().getForeground().equals(new Color(255, 0, 0)) &&
                !this.vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0)) &&
                !this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)) &&
                !this.vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0));
    }
}
