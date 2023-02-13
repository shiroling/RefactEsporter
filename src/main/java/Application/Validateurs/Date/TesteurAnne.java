package Application.Validateurs.Date;

public class TesteurAnne extends TesteurPreDate{
    public static final int MAX_ANNEE = 2999;
    public static final int MIN_ANNEE = 1900;
    @Override
    public boolean test(PreDate subject) {
        if( subject.annee() > MAX_ANNEE && subject.annee() < MIN_ANNEE ) {
            return false;
        }
        if (hasNext()) {
            return next.test(subject);
        }else {
            return true;

        }

    }
}
