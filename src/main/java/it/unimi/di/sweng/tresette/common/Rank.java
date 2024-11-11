package it.unimi.di.sweng.tresette.common;

import java.util.Map;

public enum Rank {
    ASSO,
    DUE,
    TRE,
    QUATTRO,
    CINQUE,
    SEI,
    SETTE,
    FANTE,
    CAVALLO,
    RE;

    private static final Map<Rank, Integer> TRESETTE_ORDER = Map.of(
            TRE, 1,
            DUE, 2,
            ASSO, 3,
            RE, 4,
            CAVALLO, 5,
            FANTE, 6,
            SETTE, 7,
            SEI, 8,
            CINQUE, 9,
            QUATTRO, 10
    );

    public int tresetteCompare(Rank other) {
        return TRESETTE_ORDER.get(this) - TRESETTE_ORDER.get(other);
    }
}
