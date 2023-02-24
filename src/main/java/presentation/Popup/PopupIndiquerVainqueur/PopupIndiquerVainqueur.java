package presentation.Popup.PopupIndiquerVainqueur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.Equipe;
import modele.Rencontre;
import presentation.style.btnStyle.BtnStyle;
import presentation.style.panelDegrade.PanelDegrade;

public class PopupIndiquerVainqueur extends JDialog {

    private Equipe equipe1;
    private Equipe equipe2;
    private Rencontre rencontre;
    private Equipe equipeVainqueur;
    private JPanel panelEquipe1;
    private JPanel panelEquipe2;

    private final PanelDegrade contentPanel = new PanelDegrade(new Color[] {new Color(163, 218, 255), BtnStyle.COLOR_BASE_BLEU});

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            PopupIndiquerVainqueur dialog = new PopupIndiquerVainqueur(new Rencontre(1));
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public PopupIndiquerVainqueur(Rencontre rencontre) {
        this.rencontre = rencontre;
        this.equipe1 = rencontre.getEquipes().get(0);
        this.equipe2 = rencontre.getEquipes().get(1);

        HoverPanelEquipe hover = new HoverPanelEquipe(this);
        ControleurPopupIndiquerVainqueur controleur = new ControleurPopupIndiquerVainqueur(this);

        setBounds(100, 100, 450, 300);
        setTitle("Sélectioner Vainqueur");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
        {
            JPanel panelFlowGauche = new JPanel();
            panelFlowGauche.setBackground(new Color(0,0,0,0));
            FlowLayout flowLayout = (FlowLayout) panelFlowGauche.getLayout();
            flowLayout.setVgap(30);
            contentPanel.add(panelFlowGauche);
            {
                panelEquipe1 = new JPanel();
                panelEquipe1.setName("panelEquipe1");
                //panelEquipe1.setBorder(new LineBorder(Color.DARK_GRAY));
                panelEquipe1.addMouseListener(hover);
                panelFlowGauche.add(panelEquipe1);
                panelEquipe1.setPreferredSize(new Dimension(150, 150));
                panelEquipe1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 67));
                {
                    String nomEquipe1 = equipe1.getNom();
                    JLabel lblNomEquipe1 = new JLabel(nomEquipe1);
                    lblNomEquipe1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
                    panelEquipe1.add(lblNomEquipe1);
                }
            }
        }
        {
            JPanel panelFlowDroit = new JPanel();
            panelFlowDroit.setBackground(new Color(0,0,0,0));
            FlowLayout flowLayout = (FlowLayout) panelFlowDroit.getLayout();
            flowLayout.setVgap(30);
            contentPanel.add(panelFlowDroit);
            {
                panelEquipe2 = new JPanel();
                panelEquipe2.setName("panelEquipe2");
                //panelEquipe2.setBorder(new LineBorder(Color.DARK_GRAY));
                panelEquipe2.addMouseListener(hover);
                panelFlowDroit.add(panelEquipe2);
                panelEquipe2.setPreferredSize(new Dimension(150, 150));
                panelEquipe2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 67));
                {
                    String nomEquipe2 = equipe2.getNom();
                    JLabel lblNomEquipe1 = new JLabel(nomEquipe2);
                    lblNomEquipe1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 13));
                    panelEquipe2.add(lblNomEquipe1);
                }
            }
        }
        {
            Color[] couleursDegradeNoirAuBlanc = {Color.WHITE, Color.WHITE};
            PanelDegrade buttonPane = new PanelDegrade(couleursDegradeNoirAuBlanc);
            FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
            fl_buttonPane.setVgap(10);
            buttonPane.setLayout(fl_buttonPane);
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                BtnStyle okButton = new BtnStyle(BtnStyle.COLOR_BASE_BLEU, BtnStyle.COLOR_OVER_BLEU, BtnStyle.COLOR_CLIC_BLEU, 30);
                okButton.setName("btnConfirmer");
                okButton.setText("Confirmer");
                okButton.setForeground(Color.WHITE);
                okButton.setActionCommand("OK");
                okButton.addActionListener(controleur);
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                BtnStyle cancelButton = new BtnStyle(BtnStyle.COLOR_BASE_BLEU, BtnStyle.COLOR_OVER_BLEU, BtnStyle.COLOR_CLIC_BLEU, 30);
                cancelButton.setName("btnAnnuler");
                cancelButton.setText("Annuler");
                cancelButton.addActionListener(controleur);
                cancelButton.setForeground(Color.WHITE);
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    public Equipe getEquipe1() {
        return this.equipe1;
    }

    public Equipe getEquipe2() {
        return this.equipe2;
    }

    public void setVainqueur(Equipe equipeVainqueur) {
        this.equipeVainqueur = equipeVainqueur;
    }

    public Equipe getVainqueur() {
        return equipeVainqueur;
    }

    public Rencontre getRencontre() {
        return rencontre;
    }

    public JPanel getPanelEquipe1() {
        return panelEquipe1;
    }

    public JPanel getPanelEquipe2() {
        return panelEquipe2;
    }
}