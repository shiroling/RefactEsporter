package Application.Validateurs.Date;

public class TesteurMois extends TesteurPreDate {
    private static final int MAX_MOIS = 12;
    private static final int MIN_MOIS = 1;
    @Override
    public boolean test(PreDate subject) {
        if( subject.mois() > MAX_MOIS && subject.mois() < MIN_MOIS ) {
            return false;
        }
        if (hasNext()) {
            return next.test(subject);
        }else {
            return true;

        }

    }
}
