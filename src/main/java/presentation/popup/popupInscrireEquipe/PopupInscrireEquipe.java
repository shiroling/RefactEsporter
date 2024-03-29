package presentation.popup.popupInscrireEquipe;

import presentation.popup.popupInscrireEquipe.panelEquipePourInscription.PanelEquipePourInscription;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class PopupInscrireEquipe extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JScrollPane scrollPane;
    private String nomEquipeSelectionee;
    private JPanel panelListEquipes;
    private JLabel lblAucuneEquipeSelectionnee;
    private String nomTournoi;

    public String getNomTournoi() {
        return this.nomTournoi;
    }
    public PopupInscrireEquipe(List<String> nomsEquipesPouvantSInscrire, String nomTournoi) {
        this.nomTournoi = nomTournoi;
        ControleurPopupInscrireEquipe controleur = new ControleurPopupInscrireEquipe(this);

        //List<Equipe> equipes = this.ecurie.getListeEquipe().stream().filter(e -> e.getJeu().getId() == tournoi.getIdJeu()).filter(e -> tournoi.isInscrite(e) == false).collect(Collectors.toList());
        setBounds(100, 100, 450, 300);
        setTitle("Inscrire Equipe");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(10, 10));
        {
            JPanel panelTitre = new JPanel();
            contentPanel.add(panelTitre, BorderLayout.NORTH);
            {
                JLabel lblTitre = new JLabel("Mes Equipes");
                panelTitre.add(lblTitre);
            }
        }
        {
            scrollPane = new JScrollPane();
            contentPanel.add(scrollPane, BorderLayout.CENTER);
        }
        {
            panelListEquipes = new JPanel();
            scrollPane.setViewportView(panelListEquipes);
            panelListEquipes.setLayout(new GridLayout(nomsEquipesPouvantSInscrire.size(), 1, 5, 5));

            if(nomsEquipesPouvantSInscrire.size() == 0) {
                JLabel lblAucuneEquipeAInscrire = new JLabel("-- Aucune equipe à inscrire --");
                lblAucuneEquipeAInscrire.setFont(new Font("Tahoma", Font.ITALIC, 11));
                panelListEquipes.add(lblAucuneEquipeAInscrire);
            }
            for(String nomEquipe : nomsEquipesPouvantSInscrire) {
                PanelEquipePourInscription panelEquipe = new PanelEquipePourInscription(nomEquipe, this);
                panelListEquipes.add(panelEquipe);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            buttonPane.setLayout(new GridLayout(1, 2, 0, 0));

            JPanel panelLblAucuneEquipeSelectionee = new JPanel();
            FlowLayout flowLayout_1 = (FlowLayout) panelLblAucuneEquipeSelectionee.getLayout();
            flowLayout_1.setVgap(10);
            flowLayout_1.setAlignment(FlowLayout.LEFT);
            buttonPane.add(panelLblAucuneEquipeSelectionee);
            {
                lblAucuneEquipeSelectionnee = new JLabel("* Aucune équipe selelectionée");
                lblAucuneEquipeSelectionnee.setForeground(Color.RED);
                lblAucuneEquipeSelectionnee.setVisible(false);
                panelLblAucuneEquipeSelectionee.add(lblAucuneEquipeSelectionnee);
            }


            JPanel panelBtn = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panelBtn.getLayout();
            flowLayout.setAlignment(FlowLayout.RIGHT);
            buttonPane.add(panelBtn);

            {
                JButton okButton = new JButton("Inscrire");
                okButton.setActionCommand("OK");
                okButton.addActionListener(controleur);
                okButton.setName("Inscrire");
                panelBtn.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Annuler");
                cancelButton.setActionCommand("Cancel");
                cancelButton.setName("Annuler");
                cancelButton.addActionListener(controleur);
                panelBtn.add(cancelButton);
            }

        }
    }

    public String getNomEquipeSelectionee() {
        return this.nomEquipeSelectionee;
    }

    public void setEquipeSelectionee(String nomEquipe) {
        for(Component p : panelListEquipes.getComponents()) {
             PanelEquipePourInscription panel = (PanelEquipePourInscription) p;
            if(panel.getNomEquipe().equals(nomEquipe)) {
                panel.setBorderBleu();
            } else {
                panel.setBorder(new EmptyBorder(0,0,0,0));
            }
        }
        this.nomEquipeSelectionee = nomEquipe;
    }


    public JLabel getLblAucuneEquipeSelectionee() {
        return this.lblAucuneEquipeSelectionnee;
    }
}

