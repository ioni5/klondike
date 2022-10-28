package io.github.ioni5;

public class Waste extends CardStack {

    private static final int MAX_NUM_CARDS = 24;

    public Waste() {
        super("Descarte", MAX_NUM_CARDS);
    }

    @Override
    public void showContent() {
        int first = size - 3;
        if (first < 0) {
            first = 0;
        }
        for (int i = first; i < size; i++) {
            cards[i].show();
        }
    }

    public boolean isValidToAdd() {
        return !this.isFull();
    }

    @Override
    public boolean isValidToAdd(Card card) {
        return true;
    }

}
