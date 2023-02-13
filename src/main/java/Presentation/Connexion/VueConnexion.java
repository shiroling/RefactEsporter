package Presentation.Connexion;

import Application.ConnexionState;
import Presentation.Style.BtnStyle.BtnStyle;
import Presentation.Style.PanelArrondi.PanelArrondi;
import Presentation.Style.PanelDegrade.PanelDegrade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VueConnexion extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldUsername;
    private JPasswordField textFieldPassword;
    private JTextField textFieldFocus2;
    private JTextField textFieldFocus1;


    public JTextField getTextFieldUsername() {
        return textFieldUsername;
    }


    public JPasswordField getTextFieldPassword() {
        return textFieldPassword;
    }


    public void setTextFieldUsername(JTextField textFieldUsername) {
        this.textFieldUsername = textFieldUsername;
    }


    public void setTextFieldPassword(JPasswordField textFieldPassword) {
        this.textFieldPassword = textFieldPassword;
    }


    /**
     * Create the dialog.
     */
    public VueConnexion(ConnexionState connexionVisee) {
        ControleurConnexion controleurConnexion = new ControleurConnexion(this);
        setType(Type.POPUP);
        setResizable(false);
        setModal(true);
        setBounds(100, 100, 325, 296);
        setTitle("Connexion");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(170,170,170));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            Color[] couleursDuDegrade = {new Color(163, 218, 255), BtnStyle.COLOR_BASE_BLEU};
            PanelDegrade panelBackGround = new PanelDegrade(couleursDuDegrade);
            FlowLayout flowLayout_1 = (FlowLayout) panelBackGround.getLayout();
            flowLayout_1.setVgap(30);
            contentPanel.add(panelBackGround);

            PanelArrondi panelContenantTitreChampsBtn = new PanelArrondi(30,30,30,30);
            panelBackGround.add(panelContenantTitreChampsBtn);
            panelContenantTitreChampsBtn.setLayout(new GridLayout(4, 1, 0, 0));
            {
                JPanel panelLblTitre = new JPanel();
                panelLblTitre.setOpaque(false);
                panelLblTitre.setBackground(new Color(0,0,0,0));
                panelContenantTitreChampsBtn.add(panelLblTitre);
                {
                    textFieldFocus1 = new JTextField();
                    textFieldFocus1.setEnabled(false);
                    textFieldFocus1.setEditable(false);
                    textFieldFocus1.setBackground(new Color(0,0,0,0));
                    textFieldFocus1.setBorder(new EmptyBorder(0,0,0,0));
                    panelLblTitre.add(textFieldFocus1);
                }
                {
                    JLabel lblTitreLogin = new JLabel("LOGIN");
                    lblTitreLogin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 23));
                    panelLblTitre.add(lblTitreLogin);
                }
                {
                    textFieldFocus2 = new JTextField();
                    textFieldFocus2.setBackground(new Color(0,0,0,0));
                    textFieldFocus2.setBorder(new EmptyBorder(0,0,0,0));
                    panelLblTitre.add(textFieldFocus2);
                }
            }
            {
                JPanel panelTxtFeildUsername = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panelTxtFeildUsername.getLayout();
                flowLayout.setHgap(30);
                panelTxtFeildUsername.setOpaque(false);
                panelTxtFeildUsername.setBackground(new Color(0,0,0,0));
                flowLayout.setVgap(10);
                panelContenantTitreChampsBtn.add(panelTxtFeildUsername);
                {
                    textFieldUsername = new JTextField();
                    textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    textFieldUsername.setText("USERNAME");
                    textFieldUsername.setForeground(Color.GRAY);
                    FocusListenerTextField focusListenerUsername = new FocusListenerTextField(textFieldUsername, textFieldUsername.getText());
                    textFieldUsername.addFocusListener(focusListenerUsername);
                    panelTxtFeildUsername.add(textFieldUsername);
                    textFieldUsername.setColumns(15);
                }
            }
            {
                JPanel panelTxtFeildPassword = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panelTxtFeildPassword.getLayout();
                panelTxtFeildPassword.setOpaque(false);
                panelTxtFeildPassword.setBackground(new Color(0,0,0,0));
                flowLayout.setVgap(10);
                panelContenantTitreChampsBtn.add(panelTxtFeildPassword);
                {
                    textFieldPassword = new JPasswordField();
                    textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    textFieldPassword.setText("PASSWORD");
                    textFieldPassword.setForeground(Color.GRAY);
                    FocusListenerTextField focusListenerPassword = new FocusListenerTextField(textFieldPassword, textFieldPassword.getText());
                    textFieldPassword.addFocusListener(focusListenerPassword);
                    panelTxtFeildPassword.add(textFieldPassword);
                    textFieldPassword.setColumns(15);
                }
            }
            {
                JPanel panelBtnConnexion = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panelBtnConnexion.getLayout();
                panelBtnConnexion.setOpaque(false);
                panelBtnConnexion.setBackground(new Color(0,0,0,0));
                flowLayout.setVgap(10);
                panelContenantTitreChampsBtn.add(panelBtnConnexion);
                {
                    BtnStyle btnSeConnecter = new BtnStyle(BtnStyle.COLOR_BASE_BLEU, BtnStyle.COLOR_OVER_BLEU, BtnStyle.COLOR_CLIC_BLEU, 30);
                    btnSeConnecter.setText("Se connecter");
                    btnSeConnecter.setForeground(Color.WHITE);
                    btnSeConnecter.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
                    btnSeConnecter.updateUI();
                    btnSeConnecter.addActionListener(controleurConnexion);
                    panelBtnConnexion.add(btnSeConnecter);

                    getRootPane().setDefaultButton(btnSeConnecter);
                }
            }
        }
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
