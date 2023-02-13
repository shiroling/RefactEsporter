package Presentation.FormCreerTournoi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class VueFormCreerTournoi extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldNom;
    private JLabel lblNom;
    private JPanel panelJeuxAjoutes;
    private JComboBox<String> comboPortee;
    private JComboBox<String> comboJourDebutTournoi;
    private JComboBox<String> comboMoiDebutTournoi;
    private JComboBox<String> comboAnneeDebutTournoi;
    private JComboBox<String> comboJourFinTournoi;
    private JComboBox<String> comboMoiFinTournoi;
    private JComboBox<String> comboAnneeFinTournoi;
    private JComboBox<String> comboJourFinInscription;
    private JComboBox<String> comboMoiFinInscription;
    private JComboBox<String> comboAnneeFinInscription;
    private JLabel lblDateDebutTournoi;
    private JLabel lblDateFinTournoi;
    private JLabel lblDateFinInscription;
    private JComboBox<String> comboJeux;
    private JButton btnAjouterJeu;
    private JLabel lblJeuxAjoutes;
    private int idGerant;


    public int getIdGerant() {
        return this.idGerant;
    }

    public JTextField getTextFieldNom() {
        return this.textFieldNom;
    }

    public JLabel getLabelNom() {
        return this.lblNom;
    }

    public JPanel getPanelJeuxAjoutes() {
        return this.panelJeuxAjoutes;
    }

    public JButton getBtnAjouterJeux() {
        return this.btnAjouterJeu;
    }

    public JLabel getLabelJeuxAjoutes() {
        return this.lblJeuxAjoutes;
    }

    public JLabel getLabelDateDebutTournoi() {
        return this.lblDateDebutTournoi;
    }

    public JLabel getLabelDateFinTournoi() {
        return this.lblDateFinTournoi;
    }

    public JLabel getLabelDateFinInscription() {
        return this.lblDateFinInscription;
    }

    public JComboBox<String> getComboJeux() {
        return this.comboJeux;
    }

    public JComboBox<String> getComboPortee() {
        return this.comboPortee;
    }

    public String getSelectedValueComboAnneeDebutTournoi() {
        return this.comboAnneeDebutTournoi.getSelectedItem().toString();
    }

    public String getSelectedValueComboAnneeFinInscription() {
        return this.comboAnneeFinInscription.getSelectedItem().toString();
    }

    public String getSelectedValueComboAnneeFinTournoi() {
        return this.comboAnneeFinTournoi.getSelectedItem().toString();
    }

    public String getSelectedValueComboJourDebutTournoi() {
        return this.comboJourDebutTournoi.getSelectedItem().toString();
    }

    public String getSelectedValueComboJourFinInscription() {
        return this.comboJourFinInscription.getSelectedItem().toString();
    }

    public String getSelectedValueComboJourFinTournoi() {
        return this.comboJourFinTournoi.getSelectedItem().toString();
    }

    public String getSelectedValueComboMoiDebutTournoi() {
        return this.comboMoiDebutTournoi.getSelectedItem().toString();
    }

    public String getSelectedValueComboMoiFinInscription() {
        return this.comboMoiFinInscription.getSelectedItem().toString();
    }

    public String getSelectedValueComboMoiFinTournoi() {
        return this.comboMoiFinTournoi.getSelectedItem().toString();
    }

    public VueFormCreerTournoi(int idGerant) {
        this.idGerant = idGerant;
        ControleurFormCreerTournoi controleur = new ControleurFormCreerTournoi(this);
        setTitle("Nouveau tournoi");
        setBounds(100, 100, 379, 438);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel PanelLbl = new JPanel();
            contentPanel.add(PanelLbl, BorderLayout.WEST);
            PanelLbl.setLayout(new GridLayout(6, 1, 0, 0));
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelLbl.add(panel);
                {
                    lblNom = new JLabel("Nom ");
                    panel.add(lblNom);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelLbl.add(panel);
                {
                    JLabel lblPortee = new JLabel("Portée");
                    panel.add(lblPortee);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelLbl.add(panel);
                {
                    lblDateDebutTournoi = new JLabel("Date Début Tournoi");
                    panel.add(lblDateDebutTournoi);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelLbl.add(panel);
                {
                    lblDateFinTournoi = new JLabel("Date Fin Tournoi");
                    panel.add(lblDateFinTournoi);
                }
            }
            {
                JPanel panel = new JPanel();
                PanelLbl.add(panel);
                {
                    lblDateFinInscription = new JLabel("Date Fin Inscription");
                    panel.add(lblDateFinInscription);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelLbl.add(panel);
                {
                    btnAjouterJeu = new JButton("Ajouter Jeu");
                    btnAjouterJeu.addActionListener(controleur);
                    btnAjouterJeu.setName("btnAjouterJeu");
                    panel.add(btnAjouterJeu);
                }
            }
        }
        {
            JPanel PanelChampsSaisie = new JPanel();
            contentPanel.add(PanelChampsSaisie, BorderLayout.CENTER);
            PanelChampsSaisie.setLayout(new GridLayout(6, 1, 0, 0));
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    textFieldNom = new JTextField();
                    textFieldNom.setText("");
                    panel.add(textFieldNom);
                    textFieldNom.setColumns(15);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboPortee = new JComboBox<String>();
                    comboPortee.setModel(new DefaultComboBoxModel<String>(new String[] {"Local", "National", "International"}));
                    panel.add(comboPortee);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJourDebutTournoi = new JComboBox<String>();
                    comboJourDebutTournoi.setName("combo");
                    comboJourDebutTournoi.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
                    panel.add(comboJourDebutTournoi);
                }
                {
                    comboMoiDebutTournoi = new JComboBox<String>();
                    comboMoiDebutTournoi.setName("combo");
                    comboMoiDebutTournoi.setModel(new DefaultComboBoxModel<String>(Mois.toStrings()));
                    panel.add(comboMoiDebutTournoi);
                }
                {
                    comboAnneeDebutTournoi = new JComboBox<String>();
                    comboAnneeDebutTournoi.setName("combo");
                    comboAnneeDebutTournoi.setModel(new DefaultComboBoxModel<String>(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
                    panel.add(comboAnneeDebutTournoi);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJourFinTournoi = new JComboBox<String>();
                    comboJourFinTournoi.setName("combo");
                    comboJourFinTournoi.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
                    panel.add(comboJourFinTournoi);
                }
                {
                    comboMoiFinTournoi = new JComboBox<String>();
                    comboMoiFinTournoi.setName("combo");
                    comboMoiFinTournoi.setModel(new DefaultComboBoxModel<String>(Mois.toStrings()));
                    panel.add(comboMoiFinTournoi);
                }
                {
                    comboAnneeFinTournoi = new JComboBox<String>();
                    comboAnneeFinTournoi.setName("combo");
                    comboAnneeFinTournoi.setModel(new DefaultComboBoxModel<String>(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
                    panel.add(comboAnneeFinTournoi);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJourFinInscription = new JComboBox<String>();
                    comboJourFinInscription.setName("combo");
                    comboJourFinInscription.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
                    panel.add(comboJourFinInscription);
                }
                {
                    comboMoiFinInscription = new JComboBox<String>();
                    comboMoiFinInscription.setName("combo");
                    comboMoiFinInscription.setModel(new DefaultComboBoxModel<String>(Mois.toStrings()));
                    panel.add(comboMoiFinInscription);
                }
                {
                    comboAnneeFinInscription = new JComboBox<String>();
                    comboAnneeFinInscription.setName("combo");
                    comboAnneeFinInscription.setModel(new DefaultComboBoxModel<String>(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
                    panel.add(comboAnneeFinInscription);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJeux = new JComboBox<String>();
                    comboJeux.setModel(new DefaultComboBoxModel<String>(model.Jeu.toStrings()));
                    panel.add(comboJeux);
                }
            }
        }
        {
            JPanel panelJeux = new JPanel();
            contentPanel.add(panelJeux, BorderLayout.SOUTH);
            panelJeux.setLayout(new BorderLayout(0, 0));
            {
                lblJeuxAjoutes = new JLabel("Jeux Ajoutés :");
                panelJeux.add(lblJeuxAjoutes, BorderLayout.NORTH);
            }
            {
                panelJeuxAjoutes = new JPanel();
                panelJeux.add(panelJeuxAjoutes, BorderLayout.CENTER);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton btnInserer = new JButton("Créer");
                btnInserer.addActionListener(c);
                btnInserer.setName("btnInserer");
                btnInserer.setActionCommand("OK");
                buttonPane.add(btnInserer);
                getRootPane().setDefaultButton(btnInserer);
            }
            {
                JButton cancelButton = new JButton("Annuler");
                cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(c);
                cancelButton.setName("btnCancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
