package io.github.ioni5;

public class MovementWasteToDeck extends Movement {

    public MovementWasteToDeck(Board board) {
        super(board, "De Descarte a Baraja.");
    }

    public void execute() {
        Waste waste = board.getWaste();
        Deck deck = board.getDeck();
        if (waste.isEmpty() || !deck.isValidToAdd()) {
            new Console().write("\nError: movimiento inválido.");
        } else {
            do {
                Card card = waste.pop();
                card.flip();
                deck.add(card);
            } while (!waste.isEmpty());
        }
    }

}
