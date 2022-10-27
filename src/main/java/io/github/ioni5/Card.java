package io.github.ioni5;

public class Card {

    private static final String[] NUMBERS = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    private static final String AS = NUMBERS[0];

    private static final String KING = NUMBERS[12];

    private static final String[] SUITS = { "Corazones", "Diamantes", "Treboles", "Picas" };

    private static final Intervale REDS = new Intervale(0, 1);

    private static final Intervale BLACKS = new Intervale(2, 3);

    private int number;

    private int suit;

    private boolean isFaceDown;

    public Card(int number, int suit) {
        this.number = number;
        this.suit = suit;
        isFaceDown = true;
    }

    public void show() {
        Console console = new Console();
        if (this.isFaceDown()) {
            console.write("(?? de ??)");
        } else {
            console.write("(" +NUMBERS[number] + " de " + SUITS[suit] + ")");
        }
    }

    public void flip() {
        isFaceDown = !isFaceDown;
    }

    public boolean isAs() {
        return NUMBERS[number].equals(AS);
    }

    public boolean isKing() {
        return NUMBERS[number].equals(KING);
    }

    public boolean sameSuit(Card card) {
        return card.suit == suit;
    }

    public boolean isNextTo(Card card) {
        return number == card.number + 1;
    }

    public boolean isSameColor(Card card) {
        return BLACKS.includes(suit) && BLACKS.includes(card.suit)
            || REDS.includes(suit) && REDS.includes(card.suit);
    }

    public boolean isFaceDown() {
        return isFaceDown;
    }

}
