package Presentation.Style.BtnStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class BtnStyle extends JButton {

    private Color couleurDeBase;
    private Color couleurOver;
    private Color couleurClick;
    private int radius;

    public static final Color COLOR_BASE_BLEU = new Color(0, 153, 255);

    public static final Color COLOR_OVER_BLEU = new Color(51, 102, 255);

    public static final Color COLOR_CLIC_BLEU = new Color(26, 83, 255);

    public BtnStyle(Color couleurDeBase, Color couleurOver, Color couleurClick, int radius) {
        super();
        this.couleurDeBase = couleurDeBase;
        this.couleurOver = couleurOver;
        this.couleurClick = couleurClick;
        this.radius = radius;
        setOpaque(false);
        setContentAreaFilled(false);
        setBackground(couleurDeBase);
        setBorderPainted(false);
        setFocusable(false);
        ControleurBtnStyle hover = new ControleurBtnStyle(this);
        addMouseListener(hover);
    }

    public Color getCouleurDeBase() {
        return couleurDeBase;
    }

    public Color getCouleurOver() {
        return couleurOver;
    }

    public Color getCouleurClick() {
        return couleurClick;
    }

    public int getRadius() {
        return radius;
    }

    public void setCouleurDeBase(Color couleurDeBase) {
        this.couleurDeBase = couleurDeBase;
    }


    public void setCouleurOver(Color couleurOver) {
        this.couleurOver = couleurOver;
    }

    public void setCouleurClick(Color couleurClick) {
        this.couleurClick = couleurClick;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundHautGauche());
        area.intersect(new Area(createRoundHautDroit()));
        area.intersect(new Area(createRoundBasGauche()));
        area.intersect(new Area(createRoundBasDroit()));
        g2.fill(area);

        g2.setFont(getFont());
        g2.setColor(getForeground());
        setText(getText());


        int stringWidth = g2.getFontMetrics().stringWidth(getText());
        int componentWidth = getWidth();

        // Calculez l'abscisse du texte en fonction de la largeur du bouton et de la largeur du texte
        int x = (componentWidth - stringWidth) / 2;

        // Déterminez l'ordonnée du texte en fonction de la hauteur de la police et de la hauteur du bouton
        int fontAscent = g2.getFontMetrics().getAscent();
        int componentHeight = getHeight();
        int y = (componentHeight - fontAscent) / 2 + fontAscent;

        // Dessinez le texte
        g2.drawString(getText(), x, y);
        g2.dispose();
        super.paintComponent(g);
    }

    private Shape createRoundHautGauche() {
        int roundX = Math.min(getWidth(), this.radius);
        int roundY = Math.min(getHeight(), this.radius);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, getWidth(), getHeight() - roundY / 2)));
        return area;
    }

    private Shape createRoundHautDroit() {
        int roundX = Math.min(getWidth(), this.radius);
        int roundY = Math.min(getHeight(), this.radius);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, getWidth(), getHeight() - roundY / 2)));
        return area;
    }

    private Shape createRoundBasGauche() {
        int roundX = Math.min(getWidth(), this.radius);
        int roundY = Math.min(getHeight(), this.radius);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, 0 , getWidth(), getHeight() - roundY / 2)));
        return area;
    }

    private Shape createRoundBasDroit() {
        int roundX = Math.min(getWidth(), this.radius);
        int roundY = Math.min(getHeight(), this.radius);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth() - roundX / 2, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight() - roundY / 2)));
        return area;
    }
}
