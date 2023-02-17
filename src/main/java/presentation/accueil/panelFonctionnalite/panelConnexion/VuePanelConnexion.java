package presentation.accueil.panelFonctionnalite.panelConnexion;

import presentation.style.btnStyle.BtnStyle;

import javax.swing.*;
import java.awt.*;

public class VuePanelConnexion extends JPanel {
    private final ControleurPanelConnexion controleur = new ControleurPanelConnexion(this);

    public VuePanelConnexion() {
        this.setLayout(new GridLayout(3, 2, 0, 0));

        contruireLabelEtBtn("Manager : ", "créer equipe", "btnCreerEquipe");
        contruireLabelEtBtn("Gestionnaire : ", "créer tournoi", "btnCreerTournoi");
        contruireLabelEtBtn("Déconnecté ", "se connecter", "btnSwitchConnexion");
    }

    private void contruireLabelEtBtn(String texteLabel, String texteBouton, String nomBouton) {
        JLabel lbl = new JLabel(texteLabel);
        lbl.setVisible(true);
        this.add(lbl );

        BtnStyle btn = new BtnStyle(BtnStyle.COLOR_BASE_BLEU, BtnStyle.COLOR_OVER_BLEU, BtnStyle.COLOR_CLIC_BLEU, 30);
        btn.setVisible(true);
        btn.setText(texteBouton);
        btn.setForeground(new Color(255, 255, 255));
        btn.setName(nomBouton);
        btn.addActionListener(this.controleur);
        this.add(btn);
        System.out.println(btn.getName());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        VuePanelConnexion acc = new VuePanelConnexion();
        frame.add(acc);
        frame.setVisible(true);
    }


}
