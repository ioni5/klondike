package io.github.ioni5;

public class Board {

    private static final int NUM_FOUNDATIONS = 4;

    private static final int NUM_TABLEAUS = 7;
    
    private CardStack[] cardStacks;

    public Board() {
        cardStacks = new CardStack[2 + NUM_FOUNDATIONS + NUM_TABLEAUS];
        cardStacks[0] = new Deck();
        cardStacks[1] = new Waste();
        for (int i = 0; i < NUM_FOUNDATIONS; i++) {
            cardStacks[i + 2] = new Foundation();
        }
        for (int i = 0; i < NUM_TABLEAUS; i++) {
            cardStacks[i + 2 + NUM_FOUNDATIONS] = new Tableau(i + 1, this.getDeck());
        }
    }

    public Deck getDeck() {
        return (Deck)cardStacks[0];
    }

    public Waste getWaste() {
        return (Waste)cardStacks[1];
    }

    private Foundation getFoundation(int position) {
        return (Foundation)cardStacks[1 + position];
    }

    private Tableau getTableau(int position) {
        return (Tableau)cardStacks[5 + position];
    }

    public Tableau getTableau(String message) {
        Console console = new Console();
        int position = console.readInt("¿" + message + " qué Columna (1-" + NUM_TABLEAUS + ")?: ");
        return this.getTableau(position);
    }

    public Foundation getFoundation(String message) {
        Console console = new Console();
        int position = console.readInt("¿" + message + " qué Palo (1-" + NUM_FOUNDATIONS + ")?: ");
        return this.getFoundation(position);
    }

    public void show() {
        for (CardStack cardStack : cardStacks) {
            cardStack.show();
        }
    }

}
