package io.github.ioni5;

public class Tableau extends CardStack {

    private static final int MAX_NUM_CARDS = 7;

    public Tableau(int position, Deck deck) {
        super("Columna", MAX_NUM_CARDS);
        for (int i = 0; i < position; i++) {
            this.add(deck.pop());
        }
        this.top().flip();
    }

    @Override
    public void showContent() {
        for (int i = 0; i < size; i++) {
            cards[i].show();
        }
    }

    public boolean isValidToFlip() {
        return !this.isEmpty() && this.top().isFaceDown();
    }

    @Override
    public boolean isValidToAdd(Card card) {
        assert card != null;
        return this.isEmpty() && card.isKing()
            || !this.isEmpty() && !this.isFull() 
            && !card.isSameColor(this.top()) && this.top().isNextTo(card);
    }

}
