package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

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
}