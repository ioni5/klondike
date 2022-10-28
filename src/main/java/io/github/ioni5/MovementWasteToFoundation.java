package io.github.ioni5;

public class MovementWasteToFoundation extends MovementOriginToTarget {

    public MovementWasteToFoundation(Board board) {
        super(board, "De Descarte a Palo.");
    }
    
    @Override
    public void execute() {
        origin = board.getWaste();
        target = board.getFoundation("A");
        super.execute();
    }

}
