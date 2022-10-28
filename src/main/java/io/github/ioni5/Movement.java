package io.github.ioni5;

public abstract class Movement {

    protected Board board;

    private String title;

    public Movement(Board board, String title) {
        this.title = title;
        this.board = board;
    }

    public abstract void execute();

    public void show(int position) {
        Console console = new Console();
        console.write("\n" + position + "-" + title);
    }

}
