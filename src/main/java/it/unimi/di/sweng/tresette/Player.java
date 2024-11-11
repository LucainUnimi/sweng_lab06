package it.unimi.di.sweng.tresette;

import it.unimi.di.sweng.tresette.common.Card;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Player implements Iterable<Card> {
    // TODO rendere la classe Iterable sulle carte che ha in mano

    private @NotNull
    final String name;
    private @NotNull
    final List<Card> cards = new ArrayList<>();
    private @NotNull
    final List<Card> personalDeck = new ArrayList<>();
    private @NotNull Strategy attackStrategyChain;
    private @NotNull Strategy answerStrategyChain;
    private boolean lastTaken = false; //true per il giocatore che vince ultima mano

    public Player(@NotNull String name) {
        this.name = name;
        //TODO: assegnare strategie di default
    }

    @NotNull
    public Card chooseAttackCard() {
        throw new RuntimeException("NotYetImplemented");
    }

    @NotNull
    public Card chooseAnswerCard(@NotNull Card opponent) {
        throw new RuntimeException("NotYetImplemented");
    }

    public int getPoints() {
        int points = 0;
        for(Card card : personalDeck) {
            switch (card.getRank()) {
                case ASSO -> points += 3;
                case RE, FANTE, CAVALLO, DUE, TRE -> points += 1;
            }
        }
        return points / 3;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @Override
    @NotNull
    public String toString() {
        return getName() +
                " <" + getPoints() + ">" +
                " " + cards;
    }

    public String shout() {
        return "Ho vinto io (%s) con %d punti".formatted(name, getPoints());
    }

    public void collectCards(Card attackCard, Card answerCard) {
        personalDeck.add(attackCard);
        personalDeck.add(answerCard);
    }

    public void takeDrawnCard(@NotNull Card drawn) {
        cards.add(drawn);
    }

    public void setAttackStrategyChain(@NotNull Strategy attackStrategyChain) {
        this.attackStrategyChain = attackStrategyChain;
    }

    public void setAnswerStrategyChain(@NotNull Strategy answerStrategyChain) {
        this.answerStrategyChain = answerStrategyChain;
    }

    public void setLastTaken() {
        lastTaken = true;
    }

    @Override
    public @NotNull Iterator<Card> iterator() {
        return cards.iterator();
    }
}
