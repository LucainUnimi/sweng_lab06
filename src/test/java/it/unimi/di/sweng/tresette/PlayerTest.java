package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

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
}
