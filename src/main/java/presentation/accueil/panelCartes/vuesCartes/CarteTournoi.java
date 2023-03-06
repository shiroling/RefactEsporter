package presentation.accueil.panelCartes.vuesCartes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarteTournoi extends Carte{
    private JPanel panelDate;
    private JPanel panelNom;
    ////////////////////////////////////////////////////////////////
    private JLabel lblNomTournoi;
    private JLabel lblDateDebutFinTournoi;

    public CarteTournoi() {
        super();

        panelNom = new JPanel();
        panelNom.setBackground(new Color(0,0,0,0));
        add(panelNom);
        panelNom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        lblNomTournoi = new JLabel("nomTournoi");
        lblNomTournoi.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        lblNomTournoi.setHorizontalAlignment(SwingConstants.CENTER);
        panelNom.add(lblNomTournoi);

        panelDate = new JPanel();
        panelDate.setBackground(new Color(0,0,0,0));
        add(panelDate);
        panelDate.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        lblDateDebutFinTournoi = new JLabel("date");
        lblDateDebutFinTournoi.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        panelDate.add(lblDateDebutFinTournoi);


        super.addHoverPannels(this);

        this.setName("CarteTournois");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
    }


    public JPanel getPanelNomTournoi() {
        return this.panelNom;
    }

    public JPanel getPanelDateTournoi() {
        return this.panelDate;
    }

    public void setPanelDate(LocalDate dateDebut, LocalDate dateFin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDateDebutFinTournoi.setText(dateDebut.format(formatter)+" -- "+dateFin.format(formatter));
    }

    public void setNomTournoi(String nom){
        lblNomTournoi.setText(nom);
    }


    @Override
    public Carte clone() {
        return null;
    }
}
