package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Strategy {

    Strategy RANDOM = (c, a) -> {
        if (a != null) for(Card card : c) { if(card.getSuit() == a.getSuit()) return card;}
        return c.iterator().next();
    };

    // ATTENZIONE: quando attackCard è null vuol dire che è una strategia di attacco,
    // se è diversa da null è strategia di risposta
    @NotNull Card chooseCard(@NotNull Iterable<Card> cards,
                             @Nullable Card attackCard);
}
