package Presentation.FormCreerTournoi;

import Application.Application;
import Application.Portee;
import Application.Validateurs.Date.PreDate;
import Application.Validateurs.Date.TesteurDate;
import NouveauModele.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControleurFormCreerTournoi implements ActionListener {
    private final VueFormCreerTournoi vue;
    private final List<Jeu> jeux;

    public ControleurFormCreerTournoi(VueFormCreerTournoi vue) {
        this.vue = vue;
        this.jeux = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        switch (btn.getName()) {
            case "btnAjouterJeu" -> { //Ajoute un jeu au Tournoi
                this.jeux.add(Jeu.getJeuFromName(Objects.requireNonNull(this.vue.getComboJeux().getSelectedItem()).toString()));// Stockage du jeu selectionné
                this.vue.getPanelJeuxAjoutes().setLayout(new GridLayout(this.jeux.size(), 1, 0, 0));
                JLabel lblNomJeu = new JLabel(this.vue.getComboJeux().getSelectedItem().toString()); // Créer le label concernant le jeu selectionné dans le combo
                this.vue.getPanelJeuxAjoutes().add(lblNomJeu);              // Ajout du label dans le pannel
                this.vue.getPanelJeuxAjoutes().updateUI();                  // Maj du panel
                this.vue.getComboJeux().removeItem(this.vue.getComboJeux().getSelectedItem()); // Enleve le jeu du combo apres l'avoir ajouté
                if (this.vue.getComboJeux().getItemCount() == 0) {          // Si il n'y a plus de jeu rendre invisible le bouton et le combo
                    this.vue.getComboJeux().setVisible(false);
                    this.vue.getBtnAjouterJeux().setVisible(false);
                }
            }
            case "btnInserer" -> { //Insère un Tournoi
                boolean estFormulaireValide = true;
                boolean testNom = testerNom();
                /*
                //Si le champs Nom est vide, alors mettre le label du champs en rouge + l'initulé vide.
                if (this.vue.getTextFieldNom().getText().compareTo("") == 0 && !(this.vue.getLabelNom().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelNom().setText(this.vue.getLabelNom().getText() + "      *vide*");
                    this.vue.getLabelNom().setForeground(new Color(255, 0, 0));
                } else if (!(this.vue.getTextFieldNom().getText().compareTo("") == 0)) {
                    this.vue.getLabelNom().setText("Nom ");
                    this.vue.getLabelNom().setForeground(new Color(51, 51, 51));
                }
                 */


                boolean testJeux = testerJeux();
                /*
                //Si le champs Jeux est vide, alors mettre le label du champs en rouge + l'initulé vide.
                if (this.jeux.size() == 0 && !(this.vue.getLabelJeuxAjoutes().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelJeuxAjoutes().setText(this.vue.getLabelJeuxAjoutes().getText() + "      *vide*");
                    this.vue.getLabelJeuxAjoutes().setForeground(new Color(255, 0, 0));
                } else if (this.jeux.size() != 0) {
                    this.vue.getLabelJeuxAjoutes().setText("Jeux Ajoutés :");
                    this.vue.getLabelJeuxAjoutes().setForeground(new Color(51, 51, 51));
                }
                */


                boolean testDateDebut =testerDateDebutTournoi();
                /* la fonction juste au dessus substitu la premiére, je te laisse regarder :)
                PreDate dateDebutTournois = vue.getPreDateDebutTournois();
                //Si la date n'est pas valide, alors mettre le libellé en rouge
                if (dateDebutTournois.estDateValide() && !dateDebutTournois.estPassee()) {
                    this.vue.getLabelDateDebutTournoi().setText("Date Début Tournoi");
                    this.vue.getLabelDateDebutTournoi().setForeground(new Color(51, 51, 51));
                } else if (!(this.vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelDateDebutTournoi().setText(this.vue.getLabelDateDebutTournoi().getText() + "*");
                    this.vue.getLabelDateDebutTournoi().setForeground(new Color(255, 0, 0));
                }
                */

                boolean testDatefin = testerDateFinTournoi();
                /* la fonction juste au dessus substitu la premiére, je te laisse regarder :)
                PreDate dateFinTournois = new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeFinTournoi()), Mois.stringToMois(this.vue.getSelectedValueComboMoiFinTournoi()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourFinTournoi()));
                //Si la date n'est pas valide, alors mettre le libellé en rouge
                if (dateFinTournois.estDateValide() && !dateFinTournois.estPassee()) {
                    this.vue.getLabelDateFinTournoi().setText("Date Fin Tournoi");
                    this.vue.getLabelDateFinTournoi().setForeground(new Color(51, 51, 51));
                } else if (!(this.vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelDateFinTournoi().setText(this.vue.getLabelDateFinTournoi().getText() + "*");
                    this.vue.getLabelDateFinTournoi().setForeground(new Color(255, 0, 0));
                }
                 */

                boolean testDateFinInsc =testerDateFinInscription();
                /* la fonction juste au dessus substitu la premiére, je te laisse regarder :)
                PreDate dateFinInscription = new PreDate(Integer.parseInt(this.vue.getSelectedValueComboAnneeFinInscription()), Mois.stringToMois(this.vue.getSelectedValueComboMoiFinInscription()).getMoisChiffre(), Integer.parseInt(this.vue.getSelectedValueComboJourFinInscription()));
                //Si la date n'est pas valide, alors mettre le libellé en rouge
                if (dateFinInscription.estDateValide() && !dateFinInscription.estPassee()) {
                    this.vue.getLabelDateFinInscription().setText("Date Fin Inscription");
                    this.vue.getLabelDateFinInscription().setForeground(new Color(51, 51, 51));
                } else if (!(this.vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0)))) {
                    this.vue.getLabelDateFinInscription().setText(this.vue.getLabelDateFinInscription().getText() + "*");
                    this.vue.getLabelDateFinInscription().setForeground(new Color(255, 0, 0));
                }
                 */

                boolean testChrono = testerChronologieDates();
                /* la fonction substitue les deux suivantes
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
                */

                //Si le formulaire est valide alors inserer le tournoi.
                //
                //  FAUT PAS QUE CE SOIT ICI !
                //  la vue deverait retourner les infos mais pas les insérer
                if (testNom && testJeux && testDateDebut && testDatefin && testDateFinInsc && testChrono) {
                    //Verifie si le tournoi est multigaming ou non.
                    if (this.jeux.size() == 1) {
                        Application.insererTournoi(this.vue.getTextFieldNom().getText(), Portee.stringToPortee(this.vue.getComboPortee().getSelectedItem().toString()), vue.getPreDateFinInscriptions().toDate(), vue.getPreDateDebutTournois().toDate(), vue.getPreDateFinTournoi().toDate(), this.jeux.get(0), this.vue.getIdGerant());
                    } else {
                        Application.insererTournoisMultigaming(this.vue.getTextFieldNom().getText(), Portee.stringToPortee(this.vue.getComboPortee().getSelectedItem().toString()), vue.getPreDateFinInscriptions().toDate(), vue.getPreDateDebutTournois().toDate(), vue.getPreDateFinTournoi().toDate(), this.jeux, this.vue.getIdGerant());
                    }
                    this.vue.dispose();
                }
            }
            case "btnCancel" -> //Ferme le formulaire de création de tournoi
                    this.vue.dispose();
            default -> throw new IllegalStateException("Unexpected value: " + btn.getName());
        }
    }

    public boolean testerDateDebutTournoi() {
        if (!TesteurDate.test(vue.getPreDateDebutTournois())) {
            this.vue.setLabelOnDefault(vue.getLabelDateDebutTournoi(), "Date Début Tournoi");
            return true;
        }
        if (!this.isLabelDateDebutTournoiOnWarning()) {
            this.vue.setLabelOnWarning(vue.getLabelDateDebutTournoi(), "Date Début Tournoi");
        }
        return false;
    }

    public boolean testerDateFinTournoi() {
        if (!TesteurDate.test( vue.getPreDateFinTournoi())) {
            this.vue.setLabelOnDefault(vue.getLabelDateFinTournoi(), "Date Fin Tournoi");
            return true;
        }
        if (!this.isLabelDateFinTournoiOnWarning()) {
            this.vue.setLabelOnWarning(vue.getLabelDateFinTournoi(), "Date Fin Tournoi");
        }
        return false;
    }

    public boolean testerDateFinInscription() {
        if (!TesteurDate.test(vue.getPreDateFinInscriptions())) {
            this.vue.setLabelOnDefault(vue.getLabelDateFinInscription(), "Date fin inscription");
            return true;
        }
        if (!this.isLabelDateFinInscriptionOnWarning()) {
            this.vue.setLabelOnWarning(vue.getLabelDateFinInscription(), "Date fin inscription");
        }
        return false;
    }

    public boolean testerChronologieDates() {
        // dans le cas ou la date de fin est avant le début, on passe le label en rouge
        PreDate dateDebutTournois = vue.getPreDateDebutTournois();
        if (vue.getPreDateFinTournoi().toDate().before(dateDebutTournois.toDate())) {
            if(!isLabelDateDebutTournoiOnWarning())
                this.vue.setLabelOnWarning(vue.getLabelDateDebutTournoi(), "Date debut tournoi");
            if(!isLabelDateFinTournoiOnWarning())
                this.vue.setLabelOnWarning(vue.getLabelDateFinTournoi(), "Date Fin Tournoi");
            return false;
        }
        // dans le cas ou la date de debut est avant la fin des inscriptions, on passe le label en rouge
        if (dateDebutTournois.toDate().before((vue.getPreDateFinInscriptions().toDate()))) {
            if(!isLabelDateDebutTournoiOnWarning())
                this.vue.setLabelOnWarning(vue.getLabelDateDebutTournoi(), "Date debut tournoi");
            if(!isLabelDateFinInscriptionOnWarning())
                this.vue.setLabelOnWarning(vue.getLabelDateFinInscription(), "Date fin inscription");
            return false;
        }
        return true;
    }
    public boolean isLabelDateDebutTournoiOnWarning() {
        return vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0));
    }
    public boolean isLabelDateFinTournoiOnWarning() {
        return vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0));
    }
    public boolean isLabelDateFinInscriptionOnWarning() {
        return vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0));
    }

    public boolean isLabelJeuxOnWarning() {
        return this.vue.getLabelJeuxAjoutes().getForeground().equals(new Color(255, 0, 0));
    }

    public  boolean isLabelNomOnWarning() {
        return this.vue.getLabelNom().getForeground().equals(new Color(255, 0, 0));
    }

    public boolean testerJeux() {
        //Si le champs Jeux est vide, alors mettre le label du champs en rouge + l'initulé vide.
        if (this.jeux.isEmpty() && !isLabelJeuxOnWarning()) {
            vue.setLabelOnWarning(vue.getLabelJeuxAjoutes(), "Jeux Ajoutés :");
            return false;
        }
        vue.setLabelOnDefault(vue.getLabelJeuxAjoutes(), "Jeux Ajoutés :");
        return true;
    }

    public boolean testerNom() {
        //Si le champs Nom est vide, alors mettre le label du champs en rouge + l'initulé vide.
        if (isEmptyNom() && !isLabelNomOnWarning()) {
            vue.setLabelOnWarning(vue.getLabelNom(), "Nom :");
            return false;
        }
        vue.setLabelOnDefault(vue.getLabelNom(), "Nom :");
        return true;
    }

    public boolean isEmptyNom() {
        return this.vue.getTextFieldNom().getText().compareTo("") == 0;
    }
}
