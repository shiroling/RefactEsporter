package presentation.accueil.panelFonctionnalite.panelFiltres;

import javax.swing.*;

public class VuePanelFiltres extends JPanel {
    public VuePanelFiltres(){
        JPanel panelAdmin = new JPanel();
        panelFiltrePlusAdmin.add(panelAdmin, BorderLayout.SOUTH);
        panelAdmin.setLayout(new GridLayout(4, 2, 0, 0));

        lblCreerEquipe = new JLabel("Manager :");
        lblCreerEquipe.setVisible(false);
        panelAdmin.add(lblCreerEquipe);

        btnCreerEquipe = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
        btnCreerEquipe.setVisible(false);
        btnCreerEquipe.setText("Creer Equipe");
        btnCreerEquipe.setForeground(Color.WHITE);
        btnCreerEquipe.setName("btnCreerEquipe");
        btnCreerEquipe.addActionListener(controleur);
        panelAdmin.add(btnCreerEquipe);

        lblCreerTournoi = new JLabel("Gestionaire :");
        lblCreerTournoi.setVisible(false);
        panelAdmin.add(lblCreerTournoi);

        btnCreeTournois = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
        btnCreeTournois.setText("Creer Tournoi");
        btnCreeTournois.setForeground(Color.WHITE);
        btnCreeTournois.setName("btnCreerTournoi");
        btnCreeTournois.addActionListener(controleur);
        btnCreeTournois.setVisible(false);
        panelAdmin.add(btnCreeTournois);

        lblEtatConx = new JLabel("Connecte:gestionaire");
        lblEtatConx.setVisible(false);
        panelAdmin.add(lblEtatConx);

        btnDeconnexion = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
        btnDeconnexion.addActionListener(controleur);
        btnDeconnexion.setName("btnDeconnexion");
        btnDeconnexion.setText("Se déconnecter");
        btnDeconnexion.setForeground(Color.WHITE);

        btnDeconnexion.setVisible(false);
        panelAdmin.add(btnDeconnexion);

        btnSeConnecter = new BtnStyleV2(BtnStyleV2.COLOR_BASE_BLEU, BtnStyleV2.COLOR_OVER_BLEU, BtnStyleV2.COLOR_CLIC_BLEU, 30);
        panelAdmin.add(btnSeConnecter);
        btnSeConnecter.setText("Se connecter");
        btnSeConnecter.setForeground(Color.WHITE);
        btnSeConnecter.addActionListener(getControleur());
        btnSeConnecter.setName("seConnecter");
    }
}
