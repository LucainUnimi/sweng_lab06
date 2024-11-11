package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Timeout(2)
public class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Carlotta");
    }

    @Test
    void iterablePlayerTest() {
        for (Card card : player) {
            assertThat(card).isNotNull();
        }
    }

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    '5B,7B,2S,8B'
                    '2B,7B,2S,8B'
                    '2B,7B,2S,8B'
                    """
    )
    void takeDrawnCardsTest(String cardsString) {
        TestUtils.cardsFrom(cardsString).forEach(player::takeDrawnCard);
        assertThat(player).containsExactlyInAnyOrder(TestUtils.cardsFrom(cardsString).toArray(new Card[0]));
    }

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    '5B,7B,2S,8B',
                    '2B,7B,2S,8B',
                    '2B,7B,2S,8B',
                    """
    )
    void collectCardsTest(String cardsString, Card card) {
        try {
            List<Card> cards = TestUtils.cardsFrom(cardsString);
            for (int i = 0; i < cards.size(); i += 2) {
                player.collectCards(cards.get(i), cards.get(i + 1));
            }
            Field personalDeck = player.getClass().getDeclaredField("personalDeck");
            personalDeck.setAccessible(true);
            List<Card> personalDeckList = (List<Card>) personalDeck.get(player);
            assertThat(personalDeckList).containsExactlyInAnyOrder(cards.toArray(new Card[0]));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            'AB,4B,AS,5B', 2
            '2B,7B,2S,8B,3C,8C', 1
            '2C,6S,3C,8B', 1
            """)
    void getPointsTest(String cardsString, int point) {
        List<Card> cards = TestUtils.cardsFrom(cardsString);
        for (int i = 0; i < cards.size(); i += 2) {
            player.collectCards(
                    cards.get(i),
                    cards.get(i + 1)
            );
        }
        assertThat(player.getPoints()).isEqualTo(point);
    }

    @Test
    void chooseAttackCardTest() {
        var strategy = mock(Strategy.class);
        when(strategy.chooseCard(any(), any())).thenReturn(
                new TwoStrategy(Strategy.RANDOM).chooseCard(
                        List.of(
                                Card.get(Rank.ASSO, Suit.BASTONI),
                                Card.get(Rank.DUE, Suit.BASTONI),
                                Card.get(Rank.TRE, Suit.BASTONI),
                                Card.get(Rank.QUATTRO, Suit.BASTONI)
                        ), null
                )
        );
        player.setAttackStrategyChain(strategy);
        assertThat(player.chooseAttackCard()).isEqualTo(Card.get(Rank.DUE, Suit.BASTONI));
    }
}
