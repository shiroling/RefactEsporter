package presentation.Popup.PopupRencontre;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import modele.Equipe;
import modele.Rencontre;

public class PopupRencontre extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Rencontre rencontre;

    /**
     * Create the dialog.
     */
    public PopupRencontre(Rencontre r, ControleurAccueil controleurAccueil) {
        this.rencontre = r;
        Equipe equipe1 = r.getEquipes().get(0);
        Equipe equipe2 = r.getEquipes().get(1);

        ControleurPopupRencontre controleur = new ControleurPopupRencontre(this, controleurAccueil);

        setTitle("Match : " + equipe1.getNom() + " - " + equipe2.getNom());
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

        JLabel lblNomTournoi = new JLabel(r.getTournoi().getNom());
        panelTournoisRencontre.add(lblNomTournoi);

        JPanel panelEquipes = new JPanel();
        panelHead.add(panelEquipes);



        JLabel lblEquipe1 = new JLabel(r.getEquipes().get(0).getNom());
        lblEquipe1.setName("Equipe");
        lblEquipe1.addMouseListener(Accueil.getMa());
        panelEquipes.add(lblEquipe1);

        JLabel lblseparateur = new JLabel(" - ");
        panelEquipes.add(lblseparateur);

        JLabel lblEquipe2 = new JLabel(r.getEquipes().get(1).getNom());
        lblEquipe2.setName("Equipe");
        lblEquipe2.addMouseListener(Accueil.getMa());
        panelEquipes.add(lblEquipe2);

        JPanel panelDate = new JPanel();
        panelHead.add(panelDate);

        JLabel lblDate = new JLabel(r.getDate().toString());
        panelDate.add(lblDate);

        JPanel panelVainqueur = new JPanel();
        panelHead.add(panelVainqueur);

        if (r.estResultatRenseigne()) {
            JLabel lblResultat = new JLabel("Vainqueur : ");
            panelVainqueur.add(lblResultat);

            JLabel lblResultatNom = new JLabel(r.getVainqueur().getNom());
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

        JLabel panelNomEq1 = new JLabel(equipe1.getNom()+" : ");
        panelEq1.add(panelNomEq1);

        JLabel panelEQ1J1 = new JLabel(equipe1.getListJoueur().get(0).getPseudo());
        panelEQ1J1.setName("Joueur");
        panelEQ1J1.addMouseListener(Accueil.getMa());
        panelEq1.add(panelEQ1J1);

        JLabel panelEQ1J2 = new JLabel(equipe1.getListJoueur().get(1).getPseudo());
        panelEQ1J2.setName("Joueur");
        panelEQ1J2.addMouseListener(Accueil.getMa());
        panelEq1.add(panelEQ1J2);

        JLabel panelEQ1J3 = new JLabel(equipe1.getListJoueur().get(2).getPseudo());
        panelEQ1J3.setName("Joueur");
        panelEQ1J3.addMouseListener(Accueil.getMa());
        panelEq1.add(panelEQ1J3);

        JLabel panelEQ1J4 = new JLabel(equipe1.getListJoueur().get(3).getPseudo());
        panelEQ1J4.setName("Joueur");
        panelEQ1J3.addMouseListener(Accueil.getMa());
        panelEq1.add(panelEQ1J4);

        JScrollPane scrollPaneEq2 = new JScrollPane();
        panelCorp.add(scrollPaneEq2);

        for (Component c : panelEq1.getComponents()) {
            JLabel panel = (JLabel)c;
            panel.setName("Joueur");
            panel.addMouseListener(Accueil.getMa());
        }

        JPanel panelEq2 = new JPanel();
        scrollPaneEq2.setViewportView(panelEq2);
        panelEq2.setLayout(new GridLayout(6, 1, 0, 0));

        JLabel panelNomEq2 = new JLabel(equipe2.getNom()+" : ");
        panelEq2.add(panelNomEq2);

        JLabel panelEQ2J1 = new JLabel(equipe2.getListJoueur().get(0).getPseudo());
        panelEQ2J1.addMouseListener(Accueil.getMa());
        panelEQ2J1.setName("Joueur");
        panelEq2.add(panelEQ2J1);

        JLabel panelEQ2J2 = new JLabel(equipe2.getListJoueur().get(1).getPseudo());
        panelEQ2J2.addMouseListener(Accueil.getMa());
        panelEQ2J2.setName("Joueur");
        panelEq2.add(panelEQ2J2);

        JLabel panelEQ2J3 = new JLabel(equipe2.getListJoueur().get(2).getPseudo());
        panelEQ2J3.addMouseListener(Accueil.getMa());
        panelEQ2J3.setName("Joueur");
        panelEq2.add(panelEQ2J3);

        JLabel panelEQ2J4 = new JLabel(equipe2.getListJoueur().get(3).getPseudo());
        panelEQ2J4.addMouseListener(Accueil.getMa());
        panelEQ2J4.setName("Joueur");
        panelEq2.add(panelEQ2J4);

    }

    public Rencontre getRencontre() {
        return this.rencontre;
    }

}