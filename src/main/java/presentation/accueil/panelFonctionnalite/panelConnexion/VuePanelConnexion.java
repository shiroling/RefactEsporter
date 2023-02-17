package presentation.accueil.panelFonctionnalite.panelConnexion;

import presentation.style.btnStyle.BtnStyle;

import javax.swing.*;
import java.awt.*;

public class VuePanelConnexion extends JPanel {
    private final JPanel panelAdmin;
    private final ControleurPanelConnexion controleur = new ControleurPanelConnexion(this);

    public VuePanelConnexion() {
        panelAdmin = new JPanel();
        panelAdmin.setLayout(new GridLayout(3, 2, 0, 0));

        contruireLabelEtBtn("Manager : ", "créer equipe", "btnCreerEquipe");
        contruireLabelEtBtn("Gestionnaire : ", "créer tournoi", "btnCreerTournoi");
        contruireLabelEtBtn("Déconnecté ", "se connecter", "btnSwitchConnexion");
    }

    private void contruireLabelEtBtn(String texteLabel, String texteBouton, String nomBouton) {
        JLabel lblCreerEquipe = new JLabel(texteLabel);
        lblCreerEquipe.setVisible(false);
        this.panelAdmin.add(lblCreerEquipe );

        BtnStyle btnCreerEquipe = new BtnStyle(BtnStyle.COLOR_BASE_BLEU, BtnStyle.COLOR_OVER_BLEU, BtnStyle.COLOR_CLIC_BLEU, 30);
        btnCreerEquipe.setVisible(false);
        btnCreerEquipe.setText(texteBouton);
        btnCreerEquipe.setForeground(new Color(255, 255, 255));
        btnCreerEquipe.setName(nomBouton);
        btnCreerEquipe.addActionListener(this.controleur);
        this.panelAdmin.add(btnCreerEquipe);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        VuePanelConnexion acc = new VuePanelConnexion();
        frame.add(acc);
        frame.setVisible(true);
    }


}
