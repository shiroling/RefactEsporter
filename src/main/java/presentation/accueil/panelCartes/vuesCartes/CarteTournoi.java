
package presentation.accueil.panelCartes.vuesCartes;

import presentation.accueil.panelCartes.controleursCarte.ControleurCarteEquipe;
import presentation.accueil.panelCartes.controleursCarte.ControleurCarteTournoi;
import presentation.style.ElementCommun;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarteTournoi extends Carte{
    private JPanel panelDate;
    private JPanel panelNom;
    private JLabel lblNomTournoi;
    private JLabel lblDateDebutFinTournoi;

    public CarteTournoi(int idTournoi, String nom, LocalDate dateDebutTournoi, LocalDate dateFinTournoi) {
        super(idTournoi);
        this.addMouseListener(new ControleurCarteTournoi(this));

        setLayout(new GridLayout(2, 1, 0, 0));
        panelNom = new JPanel();
        panelNom.setBackground(new Color(0,0,0,0));
        add(panelNom);
        panelNom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        lblNomTournoi = new JLabel("nomTournoi");
        lblNomTournoi.setFont(ElementCommun.getFontPrincipal());
        lblNomTournoi.setHorizontalAlignment(SwingConstants.CENTER);
        panelNom.add(lblNomTournoi);

        panelDate = new JPanel();
        panelDate.setBackground(new Color(0,0,0,0));
        add(panelDate);
        panelDate.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        lblDateDebutFinTournoi = new JLabel("date");
        lblDateDebutFinTournoi.setFont(ElementCommun.getFontPrincipal());
        panelDate.add(lblDateDebutFinTournoi);

        this.setName("CarteTournois");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

        setPanelDate(dateDebutTournoi, dateFinTournoi);
        setNomTournoi(nom);
    }


    public void setPanelDate(LocalDate dateDebut, LocalDate dateFin){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDateDebutFinTournoi.setText(dateDebut.format(formatter)+" -- "+dateFin.format(formatter));
    }

    public void setNomTournoi(String nom){
        lblNomTournoi.setText(nom);
    }

    public JPanel getPanelNomTournoi() {
        return this.panelNom;
    }

    public JPanel getPanelDateTournoi() {
        return this.panelDate;
    }

}
