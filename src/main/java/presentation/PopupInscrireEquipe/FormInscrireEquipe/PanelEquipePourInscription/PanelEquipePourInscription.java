package presentation.PopupInscrireEquipe.FormInscrireEquipe.PanelEquipePourInscription;

import modele.Equipe;
import presentation.PopupInscrireEquipe.FormInscrireEquipe.PopupInscrireEquipe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelEquipePourInscription extends JPanel {

    private Equipe equipe;


    public PanelEquipePourInscription(Equipe equipe, PopupInscrireEquipe vue) {
        this.equipe=equipe;

        ControleurPanelEquipePourInscription hover = new ControleurPanelEquipePourInscription(this, vue);

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(0,0,0,0));
        setPreferredSize(new Dimension(0, 40));
        addMouseListener(hover);

        JLabel lblNomEquipe = new JLabel(equipe.getNom());
        lblNomEquipe.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        add(lblNomEquipe);
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void enleverContour() {
        setBorder(new EmptyBorder(0,0,0,0));
    }

    public void setBorderBleu() {
        setBorder(new LineBorder(Color.BLUE));
    }
}
