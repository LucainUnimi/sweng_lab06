package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Strategy {

    Strategy RANDOM = (c, _) -> c.iterator().next();

    // ATTENZIONE: quando attackCard è null vuol dire che è una strategia di attacco,
    // se è diversa da null è strategia di risposta
    @NotNull Card chooseCard(@NotNull Iterable<Card> cards,
                             @Nullable Card attackCard);
}
