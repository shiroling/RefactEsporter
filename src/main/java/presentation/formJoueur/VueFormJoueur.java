package presentation.formJoueur;

//import application.testeurs.PreJoueur;
import nouveauModele.dataRepresentation.Joueur;
import presentation.style.datePicker.VueDatePicker;

import javax.swing.*;
import java.awt.*;

import static presentation.style.ElementCommun.getDefaultColor;
import static presentation.style.ElementCommun.getWarningColor;

public class VueFormJoueur extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private final JLabel labelTitre;
    private final JTextField textFieldNom;
    private final JTextField textFieldPrenom;
    private final JTextField textFieldPseudo;
    private final JLabel lblNom;
    private final JLabel lblPseudo;
    private final JLabel lblPrenom;
    private final VueDatePicker datePickerNaissance;

    public VueFormJoueur(Joueur j) {
        ControleurFormJoueur controleur = new ControleurFormJoueur(this);

        setTitle("Nouveau joueur");
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        labelTitre = new JLabel();
        labelTitre.setText("Nouvelle equipe !");
        contentPanel.add(labelTitre);


        JPanel panelNom = new JPanel();
        contentPanel.add(panelNom);
        lblNom = new JLabel("Nom : ");
        panelNom.add(lblNom);
        textFieldNom = new JTextField();
        panelNom.add(textFieldNom);

        JPanel panelPrenom = new JPanel();
        contentPanel.add(panelPrenom);
        lblPrenom = new JLabel("Prenom : ");
        panelPrenom.add(lblPrenom);
        textFieldPrenom = new JTextField();
        panelPrenom.add(textFieldPrenom);

        JPanel panelPseudo = new JPanel();
        contentPanel.add(panelPseudo);
        lblPseudo = new JLabel("Pseudo : ");
        panelPseudo.add(lblPseudo);
        textFieldPseudo = new JTextField();
        panelPseudo.add(textFieldPseudo);

        datePickerNaissance = new VueDatePicker(true);
        contentPanel.add(datePickerNaissance);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Créer");
        okButton.setName("Creer");
        okButton.addActionListener(controleur);
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Annuler");
        cancelButton.setName("Annuler");
        cancelButton.addActionListener(controleur);
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    public void setOnWarningNom() {
        this.lblNom.setText("Nom /!\\ vide /!\\" );
        this.lblNom.setForeground(getWarningColor());
    }

    public void setOnWarningPrenom() {
        this.lblPrenom.setText("Prenom /!\\ vide /!\\" );
        this.lblPrenom.setForeground(getWarningColor());
    }

    public void setOnWarningPseudo() {
        this.lblPseudo.setText("Pseudo /!\\ vide /!\\" );
        this.lblPseudo.setForeground(getWarningColor());
    }

    public void setOnDefaultNom() {
        this.lblNom.setText("Nom : " );
        this.lblNom.setForeground(getDefaultColor());
    }

    public void setOnDefaultPrenom() {
        this.lblPrenom.setText("Prenom : " );
        this.lblPrenom.setForeground(getDefaultColor());
    }

    public void setOnDefaultPseudo() {
        this.lblPseudo.setText("Pseudo : " );
        this.lblPseudo.setForeground(getDefaultColor());
    }
    public static void main(String[] args) {
        try {
            Joueur j = null;
            VueFormJoueur dialog = new VueFormJoueur(j);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
            System.out.println(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    public PreJoueur getPreJoueur() {
        PreJoueur pj = new PreJoueur();
        pj.setNom(this.textFieldNom.getText());
        pj.setPrenom(textFieldPrenom.getText());
        pj.setPseudo(textFieldPseudo.getText());
        pj.setDateDeNaissance(datePickerNaissance.getLocalDate());
        return pj;
    }

     */
}
