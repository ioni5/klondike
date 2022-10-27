package io.github.ioni5;

public class Tableau {

    private static final int MAX_NUM_CARDS = 7;

    private Card[] cards;

    private int size;

    public Tableau(int position, Deck deck) {
        cards = new Card[MAX_NUM_CARDS];
        for (int i = 0; i < position; i++) {
            this.add(deck.pop());
        }
        this.top().flip();
    }

    public void show() {
        Console console = new Console();
        console.write("\nColumna : ");
        if (this.isEmpty()) {
            console.write("<Vacío>");
        } else {
            for (int i = 0; i < size; i++) {
                cards[i].show();
            }
        }
    }

    public void moveTo(Foundation foundation) {
        assert foundation != null;
        if (this.isEmpty() || !foundation.isValidToAdd(this.top())) {
            new Console().write("\nError: Movimiento inválido.");
        } else {
            foundation.add(this.pop());
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

    public void moveTo(Tableau tableau) {
        assert tableau != null;
        if (this.isEmpty() || !tableau.isValidToAdd(this.top())) {
            new Console().write("\nError: Movimiento inválido.");
        } else {
            tableau.add(this.pop());
        }
    }

    public boolean isValidToAdd(Card card) {
        assert card != null;
        return this.isEmpty() && card.isKing()
            || !this.isEmpty() && !this.isFull() 
            && !card.isSameColor(this.top()) && this.top().isNextTo(card);
    }

    private boolean isFull() {
        return size == MAX_NUM_CARDS;
    }

    private Card top() {
        return cards[size - 1];
    }

    public void add(Card card) {
        assert card != null;
        cards[size] = card;
        size++;
    }

    public void flip() {
        if (!this.isValidToFlip()) {
            new Console().write("\nError: Movimiento inválido.");
        } else {
            this.top().flip();
        }
    }

    private boolean isValidToFlip() {
        return !this.isEmpty() && this.top().isFaceDown();
    }

}
