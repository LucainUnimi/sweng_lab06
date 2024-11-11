package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class TwoStrategy implements Strategy {

    Strategy next;

    public TwoStrategy(Strategy next) {
        this.next = next;
    }

    private @Nullable Card tworankCard(@NotNull Iterable<Card> cards) {
        for (Card card : cards) {
            if (card.getRank() == Rank.DUE) {
                return card;
            }
        }
        return null;
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Iterable<Card> cards, @Nullable Card attackCard) {
        return Objects.requireNonNullElse(
                tworankCard(cards),
                next.chooseCard(cards, attackCard)
        );
    }
}
