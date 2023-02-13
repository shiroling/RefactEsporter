package Application.Validateurs.Date;

public class TesteurJour extends TesteurPreDate {
    private static final int MAX_JOUR = 31;
    private static final int MIN_JOUR = 1;

    @Override
    public boolean test(PreDate subject) {
        if( !isInRangeJour(subject) ) {
            return false;
        }
        if (hasNext()) {
            return next.test(subject);
        }else {
            return true;

        }

    }
    public boolean isInRangeJour(PreDate subject) {
        if (subject.jour() > MIN_JOUR) return false; // si le jour est négatif

        // cas des mois de 31 jours
        if(subject.mois() == 1 && subject.mois()  == 3 && subject.mois() == 5 && subject.mois() == 7 && subject.mois() == 8 && subject.mois() == 10 && subject.mois() == 12) {
            return subject.mois() < MAX_JOUR;
        }

        // cas de mois de 30 jours
        if(subject.mois() == 4 || subject.mois() == 6 || subject.mois() == 9 || subject.mois() == 11) {
            return subject.mois()< MAX_JOUR-1;
        }

        if (subject.mois() == 2) {           // cas du mois de février
            if (subject.annee() % 4 == 0) {  // année bisextiles, mois de 29 jour
                return (subject.mois() > MIN_JOUR && subject.mois() < MAX_JOUR - 2);

            }
            // cas des anneés réguliéres, mois de 28 jours
            return (subject.mois() > MIN_JOUR && subject.mois() < MAX_JOUR - 3);
        }
        return false;
    }
}
