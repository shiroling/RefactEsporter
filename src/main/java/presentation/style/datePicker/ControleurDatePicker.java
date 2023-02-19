package presentation.style.datePicker;

import application.testeurs.date.TesteurDate;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControleurDatePicker implements ItemListener {

    private final VueDatePicker vue;

    public ControleurDatePicker(VueDatePicker vue) {
         this.vue  = vue;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        JComboBox<String> source = (JComboBox<String>) itemEvent.getSource();
        boolean isValid;


        switch (source.getName()) {
            case "comboJour" : isValid = true; break;
            case "comboMois" : {
                isValid =  TesteurDate.isValidMois(vue.getDate().getMois());
                System.out.println("Mois : " + vue.getDate() + " " + vue.getDate().getMois() +  " " + isValid);

                break;
            }
            case "comboAnnee" : {
                isValid =  TesteurDate.isValidAnnee(vue.getDate().getAnnee(), TesteurDate.MIN_ANNEE, TesteurDate.MAX_ANNEE);
                System.out.println("anne : " + vue.getDate() + " " + isValid);

                break;
            }
            default: throw new RuntimeException("Unexpected value on controleurDatePicker Switch");
        }
        if (isValid) vue.setOnDefault(source);
        else vue.setOnWarning(source);

        if(TesteurDate.isValidJour(vue.getDate())) vue.setOnDefault(vue.getComboJour());
        else vue.setOnWarning(vue.getComboJour());

        vue.updateUI();
    }
}
