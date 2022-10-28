package io.github.ioni5;

public class MovementFlipTableau extends Movement{

    public MovementFlipTableau(Board board) {
        super(board, "Voltear en Columna.");
    }

    @Override
    public void execute() {
        Tableau tableau = board.getTableau("En");
        if (!tableau.isValidToFlip()) {
            new Console().write("\nError: Movimiento inválido.");
        } else {
            tableau.top().flip();
        }
    }
    
}
