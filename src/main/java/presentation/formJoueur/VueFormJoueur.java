package presentation.formJoueur;

//import application.testeurs.PreJoueur;
import presentation.style.JTextFieldLimit;
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

    public String getTextNomJoueur() {
        return this.textFieldNom.getText();
    }
    public String getTextPrenomJoueur() {
        return this.textFieldPrenom.getText();
    }
    public String getTextPseudoJoueur() {
        return this.textFieldPseudo.getText();
    }

    public VueFormJoueur() {
        ControleurFormJoueur controleur = new ControleurFormJoueur(this);
        this.setMinimumSize(new Dimension(400,400));
        this.setLayout(new FlowLayout(1,1000,1));
        setTitle("Nouveau joueur");
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        labelTitre = new JLabel();
        labelTitre.setText("Nouveau joueur");
        contentPanel.add(labelTitre);


        JPanel panelNom = new JPanel();
        panelNom.setLayout(new GridLayout(0,2,0,0));
        contentPanel.add(panelNom);
        lblNom = new JLabel("Nom : ");
        panelNom.add(lblNom);
        textFieldNom = new JTextField();
        textFieldNom.setDocument(new JTextFieldLimit(25));
        panelNom.add(textFieldNom);

        JPanel panelPrenom = new JPanel();
        contentPanel.add(panelPrenom);
        panelPrenom.setLayout(new GridLayout(0,2,0,0));
        lblPrenom = new JLabel("Prenom : ");
        panelPrenom.add(lblPrenom);
        textFieldPrenom = new JTextField();
        textFieldPrenom.setDocument(new JTextFieldLimit(25));
        panelPrenom.add(textFieldPrenom);

        JPanel panelPseudo = new JPanel();
        contentPanel.add(panelPseudo);
        panelPseudo.setLayout(new GridLayout(0,2,0,0));
        lblPseudo = new JLabel("Pseudo : ");
        panelPseudo.add(lblPseudo);
        textFieldPseudo = new JTextField();
        textFieldPseudo.setDocument(new JTextFieldLimit(40));
        panelPseudo.add(textFieldPseudo);

        JPanel panelDate = new JPanel();
        contentPanel.add(panelDate);
        datePickerNaissance = new VueDatePicker(true);
        panelDate.add(datePickerNaissance);

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
        this.lblNom.setText("Nom /!\\ vide /!\\");
        this.lblNom.setForeground(getWarningColor());
    }

    public void setOnWarningPrenom() {
        this.lblPrenom.setText("Prenom /!\\ vide /!\\");
        this.lblPrenom.setForeground(getWarningColor());
    }

    public void setOnWarningPseudo() {
        this.lblPseudo.setText("Pseudo /!\\ vide /!\\");
        this.lblPseudo.setForeground(getWarningColor());
    }

    public void setOnDefaultNom() {
        this.lblNom.setText("Nom : ");
        this.lblNom.setForeground(getDefaultColor());
    }

    public void setOnDefaultPrenom() {
        this.lblPrenom.setText("Prenom : ");
        this.lblPrenom.setForeground(getDefaultColor());
    }

    public void setOnDefaultPseudo() {
        this.lblPseudo.setText("Pseudo : ");
        this.lblPseudo.setForeground(getDefaultColor());
    }
}
