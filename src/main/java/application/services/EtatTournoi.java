package application.services;

public enum EtatTournoi {
    // tournoi phase incription
    INSCRIPTIONS,

    // tournoi complet <-> poules générées
    COMPLET,

    // tournoi en cours
    PHASE_POULES,
    PHASE_FINALES,

    // tournoi fini
    FINI,

    // tournoi ne commenceras jamais
    MORT
}
