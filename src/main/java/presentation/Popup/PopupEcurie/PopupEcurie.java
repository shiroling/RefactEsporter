package presentation.Popup.PopupEcurie;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import application.services.EcurieService;
import application.services.EquipeService;
import nouveauModele.Equipe;

public class PopupEcurie extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public PopupEcurie(int idEcurie) {
        String nomEcurie = EcurieService.getInstance().getEcurieFromId(idEcurie).getNomEcurie();
        String nomManagerEcurie = EcurieService.getInstance().getEcurieFromId(idEcurie).getNomManager();
        List<Equipe> listIdEquipes = EquipeService.getInstance().getListIdEquipesFromIdEcurie(idEcurie);

        setTitle("Ecurie : "+ nomEcurie);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panelEnTete = new JPanel();
        contentPanel.add(panelEnTete, BorderLayout.NORTH);
        panelEnTete.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblNom = new JLabel(nomEcurie);
        lblNom.setHorizontalAlignment(SwingConstants.CENTER);
        lblNom.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        panelEnTete.add(lblNom);

        JLabel lblNewLabel = new JLabel("Manager : "+ nomManagerEcurie);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelEnTete.add(lblNewLabel);

        JPanel panelCorp = new JPanel();
        contentPanel.add(panelCorp);

        JPanel panelListeEquipe = new JPanel();
        JLabel lblEquipe = new JLabel();
        JPanel panelEquipe = new JPanel();
        if (listIdEquipes.size() == 0) {
            panelEquipe = new JPanel();
            lblEquipe = new JLabel("Cette écurie n'a pas encore enregistré d'équipe.");
            lblEquipe.setHorizontalAlignment(SwingConstants.LEFT);
            panelEquipe.add(lblEquipe);
            panelListeEquipe.add(panelEquipe);
        } else {
            for (Equipe equipe : listIdEquipes) {
                panelEquipe = new JPanel();
                JPanel panelNomEquipe = new JPanel();
                lblEquipe = new JLabel(equipe.getNomEquipe());
                lblEquipe.setName("Equipe");
                lblEquipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
                lblEquipe.setHorizontalAlignment(SwingConstants.LEFT);
                panelNomEquipe.add(lblEquipe);
                panelEquipe.add(panelNomEquipe);
                panelListeEquipe.add(panelEquipe);
                FlowLayout flowLayout = (FlowLayout) panelEquipe.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
            }
        }
        panelCorp.setLayout(new BorderLayout(0, 0));
        panelListeEquipe.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lbltitreequipe = new JLabel("Equipes : ");
        lbltitreequipe.setHorizontalAlignment(SwingConstants.LEFT);
        panelCorp.add(lbltitreequipe, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        panelCorp.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(panelListeEquipe);


        setVisible(true);
        this.setMinimumSize(new Dimension(contentPanel.getWidth(),
                (listIdEquipes.size() + 1) * panelEquipe.getHeight() + panelEnTete.getHeight()));
    }

}