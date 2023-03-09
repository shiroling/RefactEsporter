package presentation.formCreerTournoi;

import application.donneesPersistantes.Mois;
import application.donneesPersistantes.Portee;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;
import java.util.List;

public class VueFormCreerTournoi extends JDialog {
    private final JTextField textFieldNom;
    private final JLabel lblNom;
    private final JPanel panelJeuxAjoutes;
    private final JComboBox<String> comboPortee;
    private final JComboBox<String> comboJourDebutTournoi;
    private final JComboBox<String> comboMoiDebutTournoi;
    private final JComboBox<String> comboAnneeDebutTournoi;
    private final JComboBox<String> comboJourFinTournoi;
    private final JComboBox<String> comboMoiFinTournoi;
    private final JComboBox<String> comboAnneeFinTournoi;
    private final JComboBox<String> comboJourFinInscription;
    private final JComboBox<String> comboMoiFinInscription;
    private final JComboBox<String> comboAnneeFinInscription;
    private final JLabel lblDateDebutTournoi;
    private final JLabel lblDateFinTournoi;
    private final JLabel lblDateFinInscription;
    private final JComboBox<String> comboJeux;
    private final JButton btnAjouterJeu;
    private final JLabel lblJeuxAjoutes;
    private List<String> nomJeuxDisponibles;
    private final int idGerant;


    public int getIdGerant() {
        return this.idGerant;
    }

    public List<String> getNomJeuxDisponibles() {
        return this.nomJeuxDisponibles;
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
        return Objects.requireNonNull(this.comboAnneeDebutTournoi.getSelectedItem()).toString();
    }

    public String getSelectedValueComboAnneeFinInscription() {
        return Objects.requireNonNull(this.comboAnneeFinInscription.getSelectedItem()).toString();
    }

    public String getSelectedValueComboAnneeFinTournoi() {
        return Objects.requireNonNull(this.comboAnneeFinTournoi.getSelectedItem()).toString();
    }

    public String getSelectedValueComboJourDebutTournoi() {
        return Objects.requireNonNull(this.comboJourDebutTournoi.getSelectedItem()).toString();
    }

    public String getSelectedValueComboJourFinInscription() {
        return Objects.requireNonNull(this.comboJourFinInscription.getSelectedItem()).toString();
    }

    public String getSelectedValueComboJourFinTournoi() {
        return Objects.requireNonNull(this.comboJourFinTournoi.getSelectedItem()).toString();
    }

    public String getSelectedValueComboMoiDebutTournoi() {
        return Objects.requireNonNull(this.comboMoiDebutTournoi.getSelectedItem()).toString();
    }

    public String getSelectedValueComboMoiFinInscription() {
        return Objects.requireNonNull(this.comboMoiFinInscription.getSelectedItem()).toString();
    }

    public String getSelectedValueComboMoiFinTournoi() {
        return Objects.requireNonNull(this.comboMoiFinTournoi.getSelectedItem()).toString();
    }

    public VueFormCreerTournoi(int idGerant, List<String> nomJeuxDisponible) {
        this.idGerant = idGerant;
        ControleurFormCreerTournoi controleur = new ControleurFormCreerTournoi(this);
        setTitle("Nouveau tournoi");
        setBounds(100, 100, 379, 438);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
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
                    comboPortee = new JComboBox<>();
                    comboPortee.setModel(new DefaultComboBoxModel<>(new String[]{"Local", "National", "International"}));
                    panel.add(comboPortee);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJourDebutTournoi = new JComboBox<>();
                    comboJourDebutTournoi.setName("combo");
                    comboJourDebutTournoi.setModel(new DefaultComboBoxModel<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
                    panel.add(comboJourDebutTournoi);
                }
                {
                    comboMoiDebutTournoi = new JComboBox<>();
                    comboMoiDebutTournoi.setName("combo");
                    comboMoiDebutTournoi.setModel(new DefaultComboBoxModel<>(Mois.toStrings()));
                    panel.add(comboMoiDebutTournoi);
                }
                {
                    comboAnneeDebutTournoi = new JComboBox<>();
                    comboAnneeDebutTournoi.setName("combo");
                    comboAnneeDebutTournoi.setModel(new DefaultComboBoxModel<>(new String[]{"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
                    panel.add(comboAnneeDebutTournoi);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJourFinTournoi = new JComboBox<>();
                    comboJourFinTournoi.setName("combo");
                    comboJourFinTournoi.setModel(new DefaultComboBoxModel<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
                    panel.add(comboJourFinTournoi);
                }
                {
                    comboMoiFinTournoi = new JComboBox<>();
                    comboMoiFinTournoi.setName("combo");
                    comboMoiFinTournoi.setModel(new DefaultComboBoxModel<>(Mois.toStrings()));
                    panel.add(comboMoiFinTournoi);
                }
                {
                    comboAnneeFinTournoi = new JComboBox<>();
                    comboAnneeFinTournoi.setName("combo");
                    comboAnneeFinTournoi.setModel(new DefaultComboBoxModel<>(new String[]{"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
                    panel.add(comboAnneeFinTournoi);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJourFinInscription = new JComboBox<>();
                    comboJourFinInscription.setName("combo");
                    comboJourFinInscription.setModel(new DefaultComboBoxModel<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
                    panel.add(comboJourFinInscription);
                }
                {
                    comboMoiFinInscription = new JComboBox<>();
                    comboMoiFinInscription.setName("combo");
                    comboMoiFinInscription.setModel(new DefaultComboBoxModel<>(Mois.toStrings()));
                    panel.add(comboMoiFinInscription);
                }
                {
                    comboAnneeFinInscription = new JComboBox<>();
                    comboAnneeFinInscription.setName("combo");
                    comboAnneeFinInscription.setModel(new DefaultComboBoxModel<>(new String[]{"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
                    panel.add(comboAnneeFinInscription);
                }
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setAlignment(FlowLayout.LEFT);
                PanelChampsSaisie.add(panel);
                {
                    comboJeux = new JComboBox<>();
                    comboJeux.setModel(new DefaultComboBoxModel<>((String[]) nomJeuxDisponible.toArray()));
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
                btnInserer.addActionListener(controleur);
                btnInserer.setName("btnInserer");
                btnInserer.setActionCommand("OK");
                buttonPane.add(btnInserer);
                getRootPane().setDefaultButton(btnInserer);
            }
            {
                JButton cancelButton = new JButton("Annuler");
                cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(controleur);
                cancelButton.setName("btnCancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    public void setLabelOnDefault(JLabel cible, String texte) {
        cible.setText(texte);
        cible.setForeground(new Color(51, 51, 51));
    }

    public void setLabelOnWarning(JLabel cible, String texte) {
        cible.setText(texte + " *");
        cible.setForeground(new Color(255, 0, 0));
    }

    protected String getNomTournoi() {
        return this.getTextFieldNom().getText();
    }

    public Portee getPortee() {
        return Portee.stringToPortee(this.getComboPortee().getSelectedItem().toString());
    }
}


