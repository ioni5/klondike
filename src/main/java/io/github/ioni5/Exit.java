package io.github.ioni5;

public class Exit extends Movement {

    private boolean isExecuted;

    public Exit() {
        super(null, "Salir.");
    }

    @Override
    public void execute() {
        isExecuted = true;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

}
