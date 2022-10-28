package io.github.ioni5;

public class Klondike {

    private Board board;

    private Menu menu;

    public Klondike() {
        board = new Board();
        menu = new Menu();
        menu.add(new MovementDeckToWaste(board));
        menu.add(new MovementWasteToDeck(board));
        menu.add(new MovementWasteToFoundation(board));
        menu.add(new MovementWasteToTableau(board));
        menu.add(new MovementTableauToFoundation(board));
        menu.add(new MovementTableauToTableau(board));
        menu.add(new MovementFoundationToTableau(board));
        menu.add(new MovementFlipTableau(board));
        menu.close();
    }

    public void start() {
        do {
            board.show();
            menu.show();
            menu.getOption().execute();
        } while (!menu.isExit());
    }
    
}
