package presentation.popup.popupTournoi;

import presentation.popup.ControleurLabelsPopups;
import presentation.popup.TypeLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class PopupTournoi extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JPanel panelEquipes;
    private String nomTournoi;

    public String getNomTournoi() {
        return this.nomTournoi;
    }
    public PopupTournoi(String nomTournoi, String dateDebut, String dateFin, String dateFinInscription, boolean isFini, boolean isPlein, List<String> nomsEquipesParticipantes) {
        this.nomTournoi = nomTournoi;
        this.setTitle("Tournoi : " + nomTournoi);
        ControleurPopupTournoi controleur = new ControleurPopupTournoi(this);

        setBounds(100, 100, 450, 300);
        setTitle("Tournoi : " + nomTournoi);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panelHead = new JPanel();
        contentPanel.add(panelHead, BorderLayout.NORTH);
        panelHead.setLayout(new GridLayout(3, 1, 0, 0));

        JPanel panelNom = new JPanel();
        panelHead.add(panelNom);

        JLabel lblNom = new JLabel(nomTournoi);
        panelNom.add(lblNom);

        JPanel panelDates = new JPanel();
        panelHead.add(panelDates);

        JLabel lblDateDebut = new JLabel(dateDebut);
        panelDates.add(lblDateDebut);

        JLabel lblSeparateur = new JLabel(" - ");
        panelDates.add(lblSeparateur);

        JLabel lblDateFin = new JLabel(dateFin);
        panelDates.add(lblDateFin);

        JPanel panelCorp = new JPanel();
        contentPanel.add(panelCorp, BorderLayout.CENTER);
        panelCorp.setLayout(new GridLayout(0, 1, 0, 0));

        JScrollPane scrollPaneEquipe = new JScrollPane();
        panelCorp.add(scrollPaneEquipe);

        panelEquipes = new JPanel();
        scrollPaneEquipe.setViewportView(panelEquipes);
        panelEquipes.setLayout(new GridLayout(nomsEquipesParticipantes.size() + 1, 1, 0, 0));

        JPanel panellblEquipe = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panellblEquipe.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelEquipes.add(panellblEquipe);

        if (isFini) {
            JLabel lbllblEquipe = new JLabel("Classement des equipes:");
            panellblEquipe.add(lbllblEquipe);
        } else {
            JLabel lbllblEquipe = new JLabel("Classement temporaire des equipes:");
            panellblEquipe.add(lbllblEquipe);
        }

        JPanel panelInscription = new JPanel();
        contentPanel.add(panelInscription, BorderLayout.SOUTH);
        JLabel lblInscription = new JLabel("Date limite d'inscription : " + dateFinInscription);
        panelInscription.add(lblInscription);

        if (isPlein && !isFini) {
            JButton btnInscription = new JButton("Inscrire une équipe");
            btnInscription.addActionListener(controleur);
            btnInscription.setName("inscription");
            panelInscription.add(btnInscription);
        } else if (isFini){
            JLabel lblFini = new JLabel("Le tournoi est fini");
            panelInscription.add(lblFini);
        }else {
            JLabel lblPlein = new JLabel("Le tournoi est plein");
            panelInscription.add(lblPlein);
        }

        ControleurLabelsPopups controleurLblEquipe = new ControleurLabelsPopups(TypeLabel.EQUIPE);
        for (String nomEquipe : nomsEquipesParticipantes) {

            JPanel panelEquipe = new JPanel();
            panelEquipes.add(panelEquipe);

            JLabel lblPlace = new JLabel(nomsEquipesParticipantes.indexOf(nomEquipe)+1+"-");
            JLabel equipe = new JLabel(nomEquipe);
            equipe.setName("Equipe");
            equipe.addMouseListener(controleurLblEquipe);
            panelEquipe.add(lblPlace);
            panelEquipe.add(equipe);
            flowLayout = (FlowLayout) panelEquipe.getLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
        }
    }

}