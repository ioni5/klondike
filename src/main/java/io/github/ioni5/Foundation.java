package io.github.ioni5;

public class Foundation {

    private static final int MAX_NUM_CARDS = 13;

    private Card[] cards;

    private int size;

    public Foundation() {
        cards = new Card[MAX_NUM_CARDS];
    }

    public void show() {
        Console console = new Console();
        console.write("\nPalo: ");
        if (this.isEmpty()) {
            console.write("<Vacío>");
        } else {
            for (int i = 0; i < size; i++) {
                cards[i].show();
            } 
        }
        
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private Card pop() {
        Card card = cards[size - 1];
        cards[size - 1] = null;
        size--;
        return card;
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
        card.show();
        return this.isEmpty() && card.isAs()
            || !this.isEmpty() && !this.isFull() 
            && card.sameSuit(this.top()) && card.isNextTo(this.top());
    }

    Card top() {
        return cards[size - 1];
    }

    private boolean isFull() {
        return size == MAX_NUM_CARDS;
    }

    public void add(Card card) {
        assert card != null;
        assert !this.isFull();
        cards[size] = card;
        size++;
    }

}
