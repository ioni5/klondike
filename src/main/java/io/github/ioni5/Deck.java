package io.github.ioni5;

import java.util.Random;

public class Deck {
    
    private static final int NUM_SUITS = 4;

    private static final int NUM_NUMBERS = 13;

    private Card[] cards;

    private int size;

    public Deck() {
        cards = new Card[NUM_NUMBERS * NUM_SUITS];
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

    public void add(Card card) {
        assert card != null;
        assert !this.isFull();
        assert card.isFaceDown();
        cards[size] = card;
        size++;
    }

    private boolean isFull() {
        return size == NUM_NUMBERS * NUM_SUITS;
    }

    public void show() {
        Console console = new Console();
        console.write("\nBaraja: ");
        if (this.isEmpty()) {
            console.write("<Vacío>");
        } else {
            this.top().show();
        }
    }

    private Card top() {
        assert !this.isEmpty();
        return cards[size - 1];
    }

    public void moveTo(Waste waste) {
        assert waste != null;
        if (this.isEmpty() || !waste.isValidToAdd()) {
            new Console().write("\nError: Movimiento inválido.");
        } else {
            int count = 0;
            Card card;
            do {
                card = this.pop();
                card.flip();
                waste.add(card);
                count++;
            } while (!this.isEmpty() && count < 3);
        }
        
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public Card pop() {
        assert !this.isEmpty();
        Card card = cards[size - 1];
        cards[size - 1] = null;
        size--;
        return card;
    }

    public boolean isValidToAdd() {
        return this.isEmpty();
    }

}
