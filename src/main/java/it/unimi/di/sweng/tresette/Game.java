package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import it.unimi.di.sweng.tresette.common.Deck;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;
import java.util.stream.StreamSupport;

public class Game {

  @NotNull private final Deck deck;
  @NotNull private final Player[] players = new Player[2];

  @NotNull private Player attackPlayer;

  public Game(@NotNull Player p1, @NotNull Player p2, @NotNull Deck d) {
    deck = d;
    players[0] = p1;
    players[1] = p2;
    attackPlayer = p1;
  }

  @NotNull
  public Player opponentOf(@NotNull Player player) {
    if (players[0] == player)
      return players[1];
    return players[0];
  }

  public void playTurn() {
    Card attackCard = attackPlayer.chooseAttackCard();
    Card answerCard = opponentOf(attackPlayer).chooseAnswerCard(attackCard);

    // TODO: quando avrete realizzato l'iterable di Player potrete scommentare l'asserzione seguente che controlla che il
    //       difensore abbia giocato una carta valida
    // assert attackCard.getSuit() == answerCard.getSuit() ||
    //    StreamSupport.stream(opponentOf(attackPlayer).getCards().spliterator(), false)
    //        .allMatch(card -> card.getSuit() != attackCard.getSuit()) : "Strategia difesa ha scelto una carta non valida";

    // TODO completare il metodo in modo che trovi in vincitore del turno e
    //      aggiorni opportunamente lo stato della partita

    throw new RuntimeException("NotYetImplemented");
  }

  public @NotNull String playGame() {
    //TODO gestisce l'intera partita:
    // - distribuzione delle carte iniziali
    // - l'invocazione dei turni
    // - il pescare carte dal mazzo quando necessario
    // - finiti i turni, assegna il punto dell'ultima presa e calcola vincitore
    // - ritorna una stringa in cui viene detto chi ha vinto e con che punteggio
    throw new RuntimeException("NotYetImplemented");
  }
}
