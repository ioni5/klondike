package io.github.ioni5;

public abstract class CardStack {

    protected Card[] cards;

    protected int size;

    private int numCards;

    private String title;

    public CardStack(String title, int numCards) {
        this.numCards = numCards;
        this.title = title;
        cards = new Card[numCards];
    }
    
    protected Card pop() {
        Card card = cards[size - 1];
        cards[size - 1] = null;
        size--;
        return card;
    }

    protected boolean isEmpty() {
        return size == 0;
    }

    protected Card top() {
        assert !this.isEmpty();
        return cards[size - 1];
    }

    protected boolean isFull() {
        return size == numCards;
    }

    public void add(Card card) {
        assert card != null;
        assert !this.isFull();
        cards[size] = card;
        size++;
    }

    public void show() {
        Console console = new Console();
        console.write("\n" + title + ": ");
        if (this.isEmpty()) {
            console.write("<Vacío>");
        } else {
            this.showContent();
        }
    }
    
    public abstract boolean isValidToAdd(Card card);

    protected abstract void showContent();

}
