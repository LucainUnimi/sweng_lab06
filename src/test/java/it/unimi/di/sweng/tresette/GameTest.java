package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Deck;
import it.unimi.di.sweng.tresette.common.Rank;
import it.unimi.di.sweng.tresette.common.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Timeout(2)
public class GameTest {


    @Test
    void playTurnTest() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        when(p1.chooseAttackCard()).thenReturn(Card.get(Rank.ASSO, Suit.BASTONI));
        when(p2.chooseAnswerCard(any())).thenReturn(Card.get(Rank.DUE, Suit.BASTONI));

        Game game = new Game(p1, p2, Deck.createFullDeck());
        game.playTurn();

        verify(p2).collectCards(Card.get(Rank.ASSO, Suit.BASTONI), Card.get(Rank.DUE, Suit.BASTONI));
    }
}
