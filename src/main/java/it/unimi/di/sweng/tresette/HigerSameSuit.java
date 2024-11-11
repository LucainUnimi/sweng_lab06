package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HigerSameSuit implements Strategy{

    private final Strategy next;

    public HigerSameSuit(Strategy next) {
        this.next = next;
    }

    private @Nullable Card higerSameSuit(@NotNull Iterable<Card> cards, @NotNull Card attackCard) {
        for (Card card : cards) {
            if (card.getSuit() == attackCard.getSuit() && card.getRank().tresetteCompare(attackCard.getRank()) < 0) {
                return card;
            }
        }
        return null;
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Iterable<Card> cards, @Nullable Card attackCard) {
        assert attackCard != null : "this strategy is design to be an answer strategy";
        return Objects.requireNonNullElse(
                higerSameSuit(cards, attackCard),
                next.chooseCard(cards, attackCard)
        );
    }
}
