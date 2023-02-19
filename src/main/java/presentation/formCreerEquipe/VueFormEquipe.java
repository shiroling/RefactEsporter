package presentation.formCreerEquipe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class VueFormEquipe extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private final JLabel lblJeu;
    private final JLabel labelTitre;
    private final JTextField textFieldNomEquipe;
    private final JComboBox comboJeux;
    private final List<VueJoueur> joueurs;



    public VueFormEquipe() {
        ControleurFormEquipe controleur = new ControleurFormEquipe(this);

        setTitle("Nouvelle equipe");
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        labelTitre = new JLabel();
        labelTitre.setText("Nouvelle equipe !");
        contentPanel.add(labelTitre);

        JPanel panelNom = new JPanel();
        contentPanel.add(panelNom);
        JLabel lblNomEquipe =new JLabel("Nom : ");
        panelNom.add(lblNomEquipe);
        textFieldNomEquipe = new JTextField();
        panelNom.add(textFieldNomEquipe);

        JPanel panelJeu = new JPanel();
        contentPanel.add(panelJeu);
        lblJeu =new JLabel("Jeu : ");
        panelJeu.add(lblJeu);
        comboJeux = new JComboBox<>();
        panelJeu.add(comboJeux);

        joueurs = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            VueJoueur joueur = new VueJoueur(controleur, i);
            joueurs.add(joueur);
            contentPanel.add(joueur);
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Créer");
        okButton.setName("CreerEquipe");
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




    public JTextField getTextFieldNomEquipe() {
        return textFieldNomEquipe;
    }

    public JComboBox getComboJeux() {
        return comboJeux;
    }

    public static void main(String[] args) {
        try {
            VueFormEquipe dialog = new VueFormEquipe();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
