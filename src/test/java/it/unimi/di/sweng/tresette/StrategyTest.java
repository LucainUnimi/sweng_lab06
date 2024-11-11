package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Timeout(2)
public class StrategyTest {

    @Test
    void RANDOMTest() {
        Strategy strategy = Strategy.RANDOM;
        Card choosen = strategy.chooseCard(List.of(
                Card.get(Rank.ASSO, Suit.BASTONI),
                Card.get(Rank.DUE, Suit.BASTONI),
                Card.get(Rank.TRE, Suit.BASTONI),
                Card.get(Rank.QUATTRO, Suit.BASTONI)
        ), null);
        assertThat(choosen).isEqualTo(Card.get(Rank.ASSO, Suit.BASTONI));
    }

    @Test
    void HigherSameSuitTest() {
        Strategy strategy = new HigerSameSuit(Strategy.RANDOM);
        Card choosen = strategy.chooseCard(List.of(
                Card.get(Rank.ASSO, Suit.BASTONI),
                Card.get(Rank.DUE, Suit.BASTONI),
                Card.get(Rank.TRE, Suit.BASTONI),
                Card.get(Rank.QUATTRO, Suit.BASTONI)
        ), Card.get(Rank.DUE, Suit.BASTONI));
        assertThat(choosen).isEqualTo(Card.get(Rank.TRE, Suit.BASTONI));
    }
}
