package Application.Validateurs.Date;

import java.util.Calendar;

public class TesteurDateFuture extends TesteurPreDate{

    @Override
    public boolean test(PreDate subject) {
        if( isDatePassed(subject) ) {
            return false;
        }
        if (hasNext()) {
            return next.test(subject);
        }else {
            return true;

        }

    }
    public boolean isDatePassed(PreDate subject) {
        Calendar now = Calendar.getInstance();
        Calendar date = Calendar.getInstance();
        date.set(subject.annee(), subject.mois() - 1, subject.jour());
        return date.before(now);
    }

}

