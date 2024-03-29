package presentation.accueil.panelCartes.vuesCartes;

import presentation.accueil.panelCartes.controleursCarte.ControleurCarteEquipe;
import presentation.accueil.panelCartes.controleursCarte.ControleurCarteJeu;
import presentation.style.ElementCommun;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class CarteJeu extends Carte{
    private JLabel lblNomJeu;
    private JLabel lblLogoJeu;

    public CarteJeu(int idJeu, String nomJeu, String logo) {
        super(idJeu);
        this.addMouseListener(new ControleurCarteJeu(this));
        setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panelNomJeu = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelNomJeu.getLayout();
        panelNomJeu.setBackground(new Color(0,0,0,0));
        flowLayout.setVgap(30);
        add(panelNomJeu);

        lblNomJeu = new JLabel("NomJeu");
        lblNomJeu.setFont(ElementCommun.getFontPrincipal());
        panelNomJeu.add(lblNomJeu);

        JPanel panelLogoJeu = new JPanel();
        panelLogoJeu.setBackground(new Color(0,0,0,0));
        add(panelLogoJeu);

        // Récupération de l'image à partir du classpath
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("logosJeux/icon.png");
        System.out.println(inputStream);
        // Chargement de l'image en utilisant la classe ImageIO
        BufferedImage image = null;
        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Affichage de l'image dans un JLabel
        lblLogoJeu = new JLabel(new ImageIcon(image));
        panelLogoJeu.add(lblLogoJeu);


        this.setName("CarteJeu");
        this.setBorder(new LineBorder(new Color(0, 0, 0)));

        setLblLogoJeu(logo);
        setNomJeu(nomJeu);

    }

    public void setNomJeu(String nom){
        lblNomJeu.setText(nom);
    }
    public void setLblLogoJeu(String path){
        // Récupération de l'image à partir du classpath
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("logosJeux/"+path);

        // Chargement de l'image en utilisant la classe ImageIO
        BufferedImage image = null;
        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Affichage de l'image dans un JLabel

        lblLogoJeu.setIcon(new ImageIcon(image));
    }

}
