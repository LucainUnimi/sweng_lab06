package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class NoPointStrategy implements Strategy {

    Strategy next;

    public NoPointStrategy(Strategy next) {
        this.next = next;
    }

    private @Nullable Card noPointCard(@NotNull Iterable<Card> cards) {
        for (Card card : cards) {
            switch (card.getRank()) {
                case SETTE, SEI, CINQUE, QUATTRO -> {
                    return card;
                }
            }
        }
        return null;
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Iterable<Card> cards, @Nullable Card attackCard) {
        return Objects.requireNonNullElse(
                noPointCard(cards),
                next.chooseCard(cards, attackCard)
        );
    }
}
