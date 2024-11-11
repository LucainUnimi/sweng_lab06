package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Strategy {
    // TODO implementare almeno 2 strategie usabili per la scelta della prima carta (attacco)
    //      e almeno 2 strategie usabili per la scelta della seconda carta (risposta), strutturandole
    //      secondo il pattern CHAIN OF RESPONSIBILITY
    //      E' possibile anche fare strategie "Ciapa nò" in cui i punti giocano in maniera negativa
    //      (strategia spesso usata senza dirlo dai genitori quando giocano con i figli piccoli)

    Strategy RANDOM = (c, _) -> c.iterator().next();

    // ATTENZIONE: quando attackCard è null vuol dire che è una strategia di attacco,
    // se è diversa da null è strategia di risposta
    @NotNull Card chooseCard(@NotNull Iterable<Card> cards,
                             @Nullable Card attackCard);
}
