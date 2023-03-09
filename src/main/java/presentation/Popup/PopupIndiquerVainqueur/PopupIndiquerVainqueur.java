package presentation.Popup.PopupIndiquerVainqueur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.invoke.StringConcatFactory;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentation.style.btnStyle.BtnStyle;
import presentation.style.panelDegrade.PanelDegrade;

public class PopupIndiquerVainqueur extends JDialog {

    private String nomEquipeVainqueur;
    private int idRencontre;
    private String nomEquipe1;
    private String nomEquipe2;
    private JPanel panelEquipe1;
    private JPanel panelEquipe2;

    private final PanelDegrade contentPanel = new PanelDegrade(new Color[] {new Color(163, 218, 255), BtnStyle.COLOR_BASE_BLEU});

    public String getNomEquipeVainqueur() {
        return this.nomEquipeVainqueur;
    }

    public void setNomEquipeVainqueur(String nomEquipeVainqueur) {
        this.nomEquipeVainqueur = nomEquipeVainqueur;
    }

    public String getNomEquipe1() {
        return this.nomEquipe1;
    }

    public String getNomEquipe2() {
        return this.nomEquipe2;
    }

    public int getIdRencontre() {
        return this.idRencontre;
    }
    /**
     * Create the dialog.
     */
    public PopupIndiquerVainqueur(String nomEquipe1, String nomEquipe2, int idRencontre) {
        this.idRencontre = idRencontre;
        this.nomEquipe1 = nomEquipe1;
        this.nomEquipe2 = nomEquipe2;
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

    public String getNomVainqueur() {
        return nomEquipeVainqueur;
    }


    public JPanel getPanelEquipe1() {
        return panelEquipe1;
    }

    public JPanel getPanelEquipe2() {
        return panelEquipe2;
    }
}