package presentation.Popup.PopupEquipe;


import presentation.Popup.ControleurLabelsPopups;
import presentation.Popup.TypeLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class PopupEquipe extends JDialog {

    private final JPanel contentPanel = new JPanel();


    /**
     * Create the dialog.
     */
    public PopupEquipe(String nomEquipe, int nbPoints, List<String> pseudosJoueurs) {
        setTitle("Equipe : "+ nomEquipe);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panelHead = new JPanel();
        contentPanel.add(panelHead, BorderLayout.NORTH);
        panelHead.setLayout(new GridLayout(2, 2, 0, 0));

        JPanel panelNom = new JPanel();
        panelHead.add(panelNom);

        JLabel lblNom = new JLabel(nomEquipe);
        panelNom.add(lblNom);

        JPanel panelPoints = new JPanel();
        panelHead.add(panelPoints);

        JLabel lblPoints = new JLabel("Nombre de points :"+ nbPoints);
        panelPoints.add(lblPoints);

        JPanel panelCorp = new JPanel();
        contentPanel.add(panelCorp, BorderLayout.CENTER);
        panelCorp.setLayout(new GridLayout(0, 1, 0, 0));

        JScrollPane scrollPaneJoueurs = new JScrollPane();
        panelCorp.add(scrollPaneJoueurs);

        JPanel panelJoueurs = new JPanel();
        scrollPaneJoueurs.setViewportView(panelJoueurs);
        panelJoueurs.setLayout(new GridLayout(5, 0, 0, 0));

        ControleurLabelsPopups controleurLblPseudo = new ControleurLabelsPopups(TypeLabel.JOUEUR);
        for (String pseudo : pseudosJoueurs) {
            JLabel lblJoueur = new JLabel(pseudo);
            lblJoueur.setName("Joueur");
            lblJoueur.addMouseListener(controleurLblPseudo);
            panelJoueurs.add(lblJoueur);
        }
    }

}