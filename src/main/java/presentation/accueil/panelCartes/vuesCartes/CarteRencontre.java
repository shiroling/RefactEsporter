package presentation.accueil.panelCartes.vuesCartes;

import presentation.accueil.panelCartes.controleursCarte.ControleurCarteEquipe;
import presentation.accueil.panelCartes.controleursCarte.ControleurCarteRencontre;
import presentation.style.ElementCommun;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarteRencontre extends Carte{
    private JLabel lblNomEquipe2;
    private JLabel lblNomEquipe1;
    private JLabel lblDateRencontre;
    private JLabel lblNomTournoi;
    private JPanel panelNomTournoi;
    private JLabel lblFinal;


    public CarteRencontre(int idRencontre, int estFinale, String nomTournoi, LocalDate dateRencontre, String nomEquipe1, String nomEquipe2, int indexVaincueur) {
        super(idRencontre);
        this.addMouseListener(new ControleurCarteRencontre(this));

        setBackground(new Color(255,255,255));
        setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panelNomRencontre = new JPanel();
        panelNomRencontre.setBackground(new Color(0,0,0,0));
        FlowLayout flowLayout = (FlowLayout) panelNomRencontre.getLayout();
        flowLayout.setVgap(30);
        add(panelNomRencontre);

        lblNomEquipe1 = new JLabel("nomEquipe1");
        lblNomEquipe1.setFont(ElementCommun.getFontPrincipal());
        panelNomRencontre.add(lblNomEquipe1);

        JLabel lblSeparationEquipe = new JLabel(" - ");
        lblSeparationEquipe.setFont(ElementCommun.getFontPrincipal());
        panelNomRencontre.add(lblSeparationEquipe);

        lblNomEquipe2 = new JLabel("nomEquipe2");
        lblNomEquipe2.setFont(ElementCommun.getFontPrincipal());
        panelNomRencontre.add(lblNomEquipe2);

        JPanel panelDateRencontre = new JPanel();
        panelDateRencontre.setBackground(new Color(0,0,0,0));
        FlowLayout flowLayout_1 = (FlowLayout) panelDateRencontre.getLayout();
        flowLayout_1.setVgap(20);
        add(panelDateRencontre);

        lblDateRencontre = new JLabel("dateTournoi");
        lblDateRencontre.setFont(ElementCommun.getFontPrincipal());
        panelDateRencontre.add(lblDateRencontre);

        panelNomTournoi = new JPanel();
        panelNomTournoi.setBackground(new Color(0, 0, 0, 0));
        add(panelNomTournoi);

        lblNomTournoi = new JLabel("nomTournoi");
        lblNomTournoi.setFont(ElementCommun.getFontPrincipal());
        lblFinal=new JLabel();
        panelNomTournoi.add(lblFinal);
        panelNomTournoi.add(lblNomTournoi);
        super.addHoverPannels(this);

        setNomEquipes(nomEquipe1, nomEquipe2, indexVaincueur);
        setNomTournoi(estFinale, nomTournoi);

        this.setName("CarteRencontre");
        this.setDateRencontre(dateRencontre);
        this.setBorder(new LineBorder(new Color(0, 0, 0)));
    }

    public void setNomTournoi(int finale, String nom){
        if (finale==1) {
            lblNomTournoi.setText("Finale du "+nom);
        }
        else {
            lblNomTournoi.setText("Poule de "+nom);
        }
    }

    /**
     *
     * @param nomEquipe1
     * @param nomEquipe2
     * @param vainqueur -- 1 si equipe1, 2 si equipe2, autre si pas de vainqueur(0 is good)
     */
    public void setNomEquipes(String nomEquipe1,String nomEquipe2, int vainqueur){
        lblNomEquipe1.setText(nomEquipe1);
        lblNomEquipe2.setText(nomEquipe2);
        if (vainqueur==0) {
            lblNomEquipe1.setForeground(new Color(0, 128, 0));
            lblNomEquipe2.setForeground(new Color(128, 0, 0));
        }
        if (vainqueur==1) {
            lblNomEquipe2.setForeground(new Color(0, 128, 0));
            lblNomEquipe1.setForeground(new Color(128, 0, 0));
        }
    }

    public void setDateRencontre(LocalDate date){
        lblDateRencontre.setText(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }



}
