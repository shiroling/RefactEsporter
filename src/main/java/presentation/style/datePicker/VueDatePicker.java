package presentation.style.datePicker;

import application.donneesPersistantes.Annees;
import application.donneesPersistantes.Jours;
import application.donneesPersistantes.Mois;
import application.testeurs.date.PreDate;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class VueDatePicker extends JPanel {

    private final JComboBox<String> comboJour;
    private final JComboBox<String> comboMois;
    private final JComboBox<String> comboAnnee;
    public final int MAX_ANNEE;
    public final int MIN_ANNEE;

    public VueDatePicker(boolean datesPassees) {
        ControleurDatePicker controleur = new ControleurDatePicker(this);
        FlowLayout flowLayout = (FlowLayout) this.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        comboJour = new JComboBox<String>();
        comboJour.setName("comboJour");
        comboJour.setModel(new DefaultComboBoxModel<>(Jours.getJours(31)));
        comboJour.addItemListener(controleur);
        this.add(comboJour);

        comboMois = new JComboBox<String>();
        comboMois.setName("comboMois");
        comboMois.setModel(new DefaultComboBoxModel<>(Mois.toStrings()));
        comboMois.addItemListener(controleur);
        this.add(comboMois);

        comboAnnee = new JComboBox<String>();
        comboAnnee.setName("comboAnnee");
        if (datesPassees) {
            MAX_ANNEE = (Calendar.getInstance()).get(Calendar.YEAR);
            MIN_ANNEE = MAX_ANNEE - 80;
            comboAnnee.setModel(new DefaultComboBoxModel<>(Annees.getAnneePasses(80)));
        } else {
            MIN_ANNEE = (Calendar.getInstance()).get(Calendar.YEAR);
            MAX_ANNEE = MIN_ANNEE + 5;
            comboAnnee.setModel(new DefaultComboBoxModel<>(Annees.getAnneeFutures(5)));
        }
        comboAnnee.addItemListener(controleur);
        this.add(comboAnnee);
    }

    private int getJour() {
        return Integer.parseInt((String) this.comboJour.getSelectedItem());
    }
    public int getMois() {
        return Mois.stringToInt((String) this.comboMois.getSelectedItem());
    }

    private int getAnnee() {
        return Integer.parseInt((String) this.comboAnnee.getSelectedItem());
    }


    public PreDate getDate() {
        return new PreDate(getAnnee(), getMois(), getJour());
    }

    public void setOnWarning(JComboBox<String> source) {
        if (source.getForeground() != new Color(255, 0, 0)) {
            source.setForeground(new Color(255, 0, 0));
        }
    }

    public void setOnDefault(JComboBox<String> source) {
        if (source.getForeground() != new Color(0, 0, 0)) {
            source.setForeground(new Color(0, 0, 0));
        }
    }
    public JComboBox<String> getComboJour() {
        return this.comboJour;
    }


    public static void main(String[] args) {
        JFrame frame =  new JFrame();
        frame.add(new VueDatePicker(true));
        frame.setVisible(true);
    }

}
