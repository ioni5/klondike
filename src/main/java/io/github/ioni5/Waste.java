package io.github.ioni5;

public class Waste {

    private static final int MAX_NUM_CARDS = 24;

    private Card[] cards;

    private int size;

    public Waste() {
        cards = new Card[MAX_NUM_CARDS];
    }

    public void show() {
        Console console = new Console();
        console.write("\nDescarte: ");
        if (this.isEmpty()) {
            console.write("<Vacío>");
        } else {
            int first = size - 3;
            if (first < 0) {
                first = 0;
            }
            for (int i = first; i < size; i++) {
                cards[i].show();
            } 
        }
    }

    private Card pop() {
        Card card = cards[size - 1];
        cards[size - 1] = null;
        size--;
        return card;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void add(Card card) {
        assert card != null;
        assert size < MAX_NUM_CARDS;
        assert !card.isFaceDown();
        cards[size] = card;
        size++;
    }

    public void moveTo(Foundation foundation) {
        assert foundation != null;
        if (this.isEmpty() || !foundation.isValidToAdd(this.top())) {
            new Console().write("\nError: movimiento inválido.");
        } else {
            foundation.add(this.pop());
        }
    }

    private Card top() {
        assert !this.isEmpty();
        return cards[size - 1];
    }

    public void moveTo(Tableau tableau) {
        assert tableau != null;
        if (this.isEmpty() || !tableau.isValidToAdd(this.top())) {
            new Console().write("\nError: movimiento inválido.");
        } else {
            tableau.add(this.pop());
        }
    }

    public void moveTo(Deck deck) {
        assert deck != null;
        if (this.isEmpty() || !deck.isValidToAdd()) {
            new Console().write("\nError: movimiento inválido.");
        } else {
            do {
                Card card = this.pop();
                card.flip();
                deck.add(card);
            } while (!this.isEmpty());
        }
        
    }

    public boolean isValidToAdd() {
        return !this.isFull();
    }

    private boolean isFull() {
        return size == MAX_NUM_CARDS;
    }

}
