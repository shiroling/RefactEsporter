package presentation.formCreerTournoi;

import application.donneesPersistantes.Portee;
import application.exceptions.BadUserExecption;
import application.services.TournoiService;
import modele.Jeu;
import nouveauModele.repositories.JeuRepository;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControleurFormCreerTournoi implements ActionListener {
    private final VueFormCreerTournoi vue;
    private final List<String> nomJeux;

    public ControleurFormCreerTournoi(VueFormCreerTournoi vue) {
        this.vue = vue;
        this.nomJeux = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        switch (btn.getName()) {
            case "btnAjouterJeu" -> { //Ajoute un jeu au Tournoi
                this.nomJeux.add(Objects.requireNonNull(this.vue.getComboJeux().getSelectedItem()).toString());// Stockage du jeu selectionné
                this.vue.getPanelJeuxAjoutes().setLayout(new GridLayout(this.nomJeux.size(), 1, 0, 0));
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



                //Si le formulaire est valide alors inserer le tournoi.
                //
                //  FAUT PAS QUE CE SOIT ICI !
                //  la vue deverait retourner les infos mais pas les insérer
                // ici le truc pour instérer
                estFormulaireValide= testJeux && testNom;
                if (estFormulaireValide){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                    String nom = vue.getNomTournoi();
                    Portee portee= vue.getPortee();
                    LocalDate finInsc = LocalDate.parse(vue.getSelectedValueComboJourFinInscription()+"/"+vue.getSelectedValueComboMoiFinInscription()+"/"+vue.getSelectedValueComboAnneeFinInscription(),formatter);
                    LocalDate datedebut = LocalDate.parse(vue.getSelectedValueComboJourDebutTournoi()+"/"+vue.getSelectedValueComboMoiDebutTournoi()+"/"+vue.getSelectedValueComboAnneeDebutTournoi(),formatter);
                    LocalDate datefin = LocalDate.parse(vue.getSelectedValueComboJourFinTournoi()+"/"+vue.getSelectedValueComboMoiFinTournoi()+"/"+vue.getSelectedValueComboAnneeFinTournoi(),formatter);
                    int idJeu = JeuRepository.getInstance().findByNom(vue.getLabelJeuxAjoutes().getText()).getIdJeu();
                    TournoiService.getInstance().enregistrerNouveauTournoi(nom,portee,finInsc,datedebut,datefin,idJeu, vue.getIdGerant());
                    this.vue.dispose();
                }


            }
            case "btnCancel" -> //Ferme le formulaire de création de tournoi
                    this.vue.dispose();
            default -> throw new IllegalStateException("Unexpected value: " + btn.getName());
        }
    }


    public boolean isLabelDateDebutTournoiOnDefault() {
        return !vue.getLabelDateDebutTournoi().getForeground().equals(new Color(255, 0, 0));
    }
    public boolean isLabelDateFinTournoiOnDefault() {
        return !vue.getLabelDateFinTournoi().getForeground().equals(new Color(255, 0, 0));
    }
    public boolean isLabelDateFinInscriptionOnDefault() {
        return !vue.getLabelDateFinInscription().getForeground().equals(new Color(255, 0, 0));
    }

    public boolean isLabelJeuxOnWarning() {
        return this.vue.getLabelJeuxAjoutes().getForeground().equals(new Color(255, 0, 0));
    }

    public  boolean isLabelNomOnWarning() {
        return this.vue.getLabelNom().getForeground().equals(new Color(255, 0, 0));
    }

    public boolean testerJeux() {
        //Si le champs Jeux est vide, alors mettre le label du champs en rouge + l'initulé vide.
        if (this.nomJeux.isEmpty()) {
            vue.setLabelOnWarning(vue.getLabelJeuxAjoutes(), "Jeux Ajoutés :");
            return false;
        }
        if (isLabelJeuxOnWarning()){
            vue.setLabelOnWarning(vue.getLabelJeuxAjoutes(), "Jeux Ajoutés :");
            return false;
        }
        vue.setLabelOnDefault(vue.getLabelJeuxAjoutes(), "Jeux Ajoutés :");
        return true;
    }

    public boolean testerNom() {
        //Si le champs Nom est vide, alors mettre le label du champs en rouge + l'initulé vide.
        if (isEmptyNom()) {
            vue.setLabelOnWarning(vue.getLabelNom(), "Nom :");
            return false;
        }
        if(isLabelNomOnWarning()){
            vue.setLabelOnWarning(vue.getLabelNom(), "Nom :");
            return false;
        }
        if (TournoiService.isValidNom(vue.getLabelNom().getText())){
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
