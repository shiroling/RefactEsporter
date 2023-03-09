package presentation.Popup.PopupRencontre;

import presentation.Popup.ControleurLabelsPopups;
import presentation.Popup.TypeLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class PopupRencontre extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private int idRencontre;

    public int getIdRencontre() {
        return this.idRencontre;
    }

    /**
     *
     * @param idRencontre
     * @param nomEquipe1
     * @param nomEquipe2
     * @param nomTournoi
     * @param dateRencontre
     * @param statutRencontre 0 pour résultat non-renseigné, 1 pour Equipe1 vainqueur, 2 pour Equipe2 vainqueur
     * @param pseudosJoueursEquipe1
     * @param pseudosJoueursEquipe2
     */
    public PopupRencontre(int idRencontre, String nomEquipe1, String nomEquipe2, String nomTournoi, String dateRencontre, int statutRencontre, List<String> pseudosJoueursEquipe1, List<String> pseudosJoueursEquipe2) {
        this.idRencontre = idRencontre;
        ControleurPopupRencontre controleur = new ControleurPopupRencontre(this);

        setTitle("Match : " + nomEquipe1 + " - " + nomEquipe2);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panelHead = new JPanel();
        contentPanel.add(panelHead, BorderLayout.NORTH);
        panelHead.setLayout(new GridLayout(4, 1, 0, 0));

        JPanel panelTournoisRencontre = new JPanel();
        panelHead.add(panelTournoisRencontre);

        JLabel lblNomTournoi = new JLabel(nomTournoi);
        panelTournoisRencontre.add(lblNomTournoi);

        JPanel panelEquipes = new JPanel();
        panelHead.add(panelEquipes);

        JLabel lblEquipe1 = new JLabel(nomEquipe1);
        lblEquipe1.setName("Equipe");
        panelEquipes.add(lblEquipe1);

        JLabel lblseparateur = new JLabel(" - ");
        panelEquipes.add(lblseparateur);

        JLabel lblEquipe2 = new JLabel(nomEquipe2);
        lblEquipe2.setName("Equipe");
        panelEquipes.add(lblEquipe2);

        JPanel panelDate = new JPanel();
        panelHead.add(panelDate);

        JLabel lblDate = new JLabel(dateRencontre);
        panelDate.add(lblDate);

        JPanel panelVainqueur = new JPanel();
        panelHead.add(panelVainqueur);

        String vainqueur = null;
        switch (statutRencontre) {
            case 1:
                vainqueur = nomEquipe1;
                break;
            case 2:
                vainqueur = nomEquipe2;
                break;
        }

        if (statutRencontre != 0) {
            JLabel lblResultat = new JLabel("Vainqueur : ");
            panelVainqueur.add(lblResultat);

            JLabel lblResultatNom = new JLabel(vainqueur);
            panelVainqueur.add(lblResultatNom);
        }
        else {
            JButton btnNewButton = new JButton("Renseigner Vainqueur");
            btnNewButton.setName("btnRenseignerVainqueur");
            btnNewButton.addActionListener(controleur);
            panelVainqueur.add(btnNewButton);
        }


        JPanel panelCorp = new JPanel();
        contentPanel.add(panelCorp, BorderLayout.CENTER);
        panelCorp.setLayout(new GridLayout(0, 2, 0, 0));

        JScrollPane scrollPaneEq1 = new JScrollPane();
        panelCorp.add(scrollPaneEq1);

        JPanel panelEq1 = new JPanel();
        scrollPaneEq1.setViewportView(panelEq1);
        panelEq1.setLayout(new GridLayout(6, 1, 0, 0));

        JLabel lblNomEq1 = new JLabel(nomEquipe1+" : ");
        panelEq1.add(lblNomEq1);

        ControleurLabelsPopups controleurLblPseudo = new ControleurLabelsPopups(TypeLabel.JOUEUR);
        for(String pseudoJoueur : pseudosJoueursEquipe1) {
            JLabel lblPseudoJoeur = new JLabel(pseudoJoueur);
            lblPseudoJoeur.setName("Joueur");
            lblPseudoJoeur.addMouseListener(controleurLblPseudo);
            panelEq1.add(lblPseudoJoeur);
        }

        JScrollPane scrollPaneEq2 = new JScrollPane();
        panelCorp.add(scrollPaneEq2);

        JPanel panelEq2 = new JPanel();
        scrollPaneEq2.setViewportView(panelEq2);
        panelEq2.setLayout(new GridLayout(6, 1, 0, 0));

        JLabel lblNomEq2 = new JLabel(nomEquipe2 + " : ");
        panelEq2.add(lblNomEq2);

        for(String pseudoJoueur : pseudosJoueursEquipe2) {
            JLabel lblPseudoJoeur = new JLabel(pseudoJoueur);
            lblPseudoJoeur.setName("Joueur");
            lblPseudoJoeur.addMouseListener(controleurLblPseudo);
            panelEq2.add(lblPseudoJoeur);
        }

    }

}