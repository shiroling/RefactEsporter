package presentation.popup.popupInscrireEquipe.panelEquipePourInscription;

import presentation.popup.popupInscrireEquipe.PopupInscrireEquipe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PanelEquipePourInscription extends JPanel {

    private PopupInscrireEquipe parent;
    private String nomEquipe;

    public PanelEquipePourInscription(String nomEquipe, PopupInscrireEquipe parent) {
        this.nomEquipe = nomEquipe;
        ControleurPanelEquipePourInscription hover = new ControleurPanelEquipePourInscription(this, parent);

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(0,0,0,0));
        setPreferredSize(new Dimension(0, 40));
        addMouseListener(hover);

        JLabel lblNomEquipe = new JLabel(nomEquipe);
        lblNomEquipe.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        add(lblNomEquipe);
    }

    public void enleverContour() {
        setBorder(new EmptyBorder(0,0,0,0));
    }

    public void setBorderBleu() {
        setBorder(new LineBorder(Color.BLUE));
    }

    public String getNomEquipe() {
        return this.nomEquipe;
    }
}
