package presentation.popup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PopupJoueur extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public PopupJoueur(String prenom, String pseudo, String nom, String dateNaissance, String nomEcurie, String nomEquipe) {
        setTitle("Joueur : " + prenom + " \"" + pseudo + "\" " + nom);
        setBounds(100, 100, 614, 528);
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setVgap(30);
        getContentPane().setLayout(borderLayout);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 30));
        {
            JPanel panelEnTete = new JPanel();
            contentPanel.add(panelEnTete, BorderLayout.NORTH);

            JLabel lblNom = new JLabel(prenom + ' ' + '"' + pseudo + '"' + ' ' + nom);
            lblNom.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
            panelEnTete.add(lblNom);
        }

        JPanel panelCorp = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelCorp.getLayout();
        flowLayout.setVgap(20);
        flowLayout.setHgap(777);
        contentPanel.add(panelCorp);

        JLabel lblNaissance = new JLabel("Naissance : " + dateNaissance);
        lblNaissance.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        panelCorp.add(lblNaissance);

        JPanel panelEcurieEquipe = new JPanel();
        panelCorp.add(panelEcurieEquipe);
        panelEcurieEquipe.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panelEcurie = new JPanel();
        panelEcurieEquipe.add(panelEcurie);

        JLabel lbllblecurie = new JLabel("Ecurie : ");
        panelEcurie.add(lbllblecurie);

        JLabel lblEcurie = new JLabel(nomEcurie);
        lblEcurie.setName("Ecurie");
        lblEcurie.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        panelEcurie.add(lblEcurie);

        JPanel panelPanelEquipe = new JPanel();
        panelEcurieEquipe.add(panelPanelEquipe);

        JLabel lbllblEquipe = new JLabel("Equipe : ");
        panelPanelEquipe.add(lbllblEquipe);

        JLabel lblEquipe = new JLabel(nomEquipe);
        lblEquipe.setName("Equipe");
        lblEquipe.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        panelPanelEquipe.add(lblEquipe);
    }
}