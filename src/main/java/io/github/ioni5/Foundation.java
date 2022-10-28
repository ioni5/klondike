package io.github.ioni5;

public class Foundation extends CardStack {

    private static final int MAX_NUM_CARDS = 13;

    public Foundation() {
        super("Palo", MAX_NUM_CARDS);
    }

    @Override
    public void showContent() {
        for (int i = 0; i < size; i++) {
            cards[i].show();
        }
    }

    @Override
    public boolean isValidToAdd(Card card) {
        assert card != null;
        card.show();
        return this.isEmpty() && card.isAs()
            || !this.isEmpty() && !this.isFull() 
            && card.sameSuit(this.top()) && card.isNextTo(this.top());
    }

}
