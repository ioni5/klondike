package io.github.ioni5;

public class MovementDeckToWaste extends Movement {

    public MovementDeckToWaste(Board board) {
        super(board, "De Baraja a Descarte.");
    }

    public void execute() {
        Deck deck = board.getDeck();
        Waste waste = board.getWaste();
        if (deck.isEmpty() || !waste.isValidToAdd()) {
            new Console().write("\nError: Movimiento inválido.");
        } else {
            int count = 0;
            Card card;
            do {
                card = deck.pop();
                card.flip();
                waste.add(card);
                count++;
            } while (!deck.isEmpty() && count < 3);
        }
    }
}
