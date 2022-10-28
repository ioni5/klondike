package io.github.ioni5;

public abstract class MovementOriginToTarget extends Movement {

    protected CardStack origin;

    protected CardStack target;

    public MovementOriginToTarget(Board board, String title) {
        super(board, title);
    }

    @Override
    public void execute() {
        if (origin.isEmpty() || !target.isValidToAdd(origin.top())) {
            new Console().write("\nError: Movimiento inválido.");
        } else {
            target.add(origin.pop());
        }
    }
    
}
