package io.github.ioni5;

import java.util.Random;

public class Deck extends CardStack {
    
    private static final int NUM_SUITS = 4;

    private static final int NUM_NUMBERS = 13;

    public Deck() {
        super("Baraja", NUM_NUMBERS * NUM_SUITS);
        for (int i = 0; i < NUM_SUITS; i++) {
            for (int j = 0; j < NUM_NUMBERS; j++) {
                this.add(new Card(j, i));
            }
        }
        this.shuffle();
    }

    private void shuffle() {
        Random rnd = new Random();
        int first;
        int second;
        for (int i = 0; i < 1000; i++) {
            first = rnd.nextInt(NUM_NUMBERS * NUM_SUITS);
            second = rnd.nextInt(NUM_NUMBERS * NUM_SUITS);
            this.exchange(first, second);
        }
    }

    private void exchange(int first, int second) {
        Card card = cards[first];
        cards[first] = cards[second];
        cards[second] = card;
    }

    @Override
    public void add(Card card) {
        assert card.isFaceDown();
        super.add(card);
    }

    @Override
    public void showContent() {
        this.top().show();
    }

    public boolean isValidToAdd() {
        return this.isEmpty();
    }

    @Override
    public boolean isValidToAdd(Card card) {
        return true;
    }

}
