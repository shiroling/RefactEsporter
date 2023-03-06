package presentation.style.datePicker;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.DateTimeException;
import java.time.LocalDate;

public class ControleurDatePicker implements ItemListener {

    private final VueDatePicker vue;

    public ControleurDatePicker(VueDatePicker vue) {
         this.vue  = vue;
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        JComboBox<String> source = (JComboBox<String>) itemEvent.getSource();
        boolean isValid;
        try {
            vue.getLocalDate();
        } catch (DateTimeException e) {
            vue.setOnWarning();
        }
        vue.updateUI();
    }
}
