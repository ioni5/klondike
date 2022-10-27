package io.github.ioni5;

public class Klondike {

    private static final int NUM_FOUNDATIONS = 4;

    private static final int NUM_TABLEAUS = 7;

    private Deck deck;

    private Waste waste;

    private Foundation[] foundations;

    private Tableau[] tableaus;

    public Klondike() {
        deck = new Deck();
        waste = new Waste();
        foundations = new Foundation[NUM_FOUNDATIONS];
        for (int i = 0; i < NUM_FOUNDATIONS; i++) {
            foundations[i] = new Foundation();
        }
        tableaus = new Tableau[NUM_TABLEAUS];
        for (int i = 0; i < NUM_TABLEAUS; i++) {
            tableaus[i] = new Tableau(i + 1, deck);
        }
    }

    public void start() {
        Console console = new Console();
        int option;
        do {
            this.show();
            Menu menu = new Menu();
            menu.show();
            option = menu.getOption();
            switch (option) {
                case 1:
                    deck.moveTo(waste);
                    break;
                case 2:
                    waste.moveTo(this.getFoundation("A"));
                    break;
                case 3:
                    waste.moveTo(this.getTableau("A"));
                    break;
                case 4:
                    this.getFoundation("De").moveTo(this.getTableau("A"));
                    break;
                case 5:
                    this.getTableau("De").moveTo(this.getFoundation("A"));
                    break;
                case 6:
                    this.getTableau("De").moveTo(this.getTableau("A"));
                    break;
                case 7:
                    waste.moveTo(deck);
                    break;
                case 8:
                    this.getTableau("De").flip();
                    break;
                case 9:
                    console.write("\nGoodbye.");
                    System.exit(0);
            }
        } while (option != 9);

    }

    private void show() {
        deck.show();
        waste.show();
        for (Foundation foundation : foundations) {
            foundation.show();
        }
        for (Tableau tableau : tableaus) {
            tableau.show();
        }
    }

    private Tableau getTableau(String message) {
        Console console = new Console();
        int columna = console.readInt("¿" + message + " qué Columna (1-" + NUM_TABLEAUS + ")?: ");
        return tableaus[columna - 1];
    }

    private Foundation getFoundation(String message) {
        Console console = new Console();
        int palo = console.readInt("¿" + message + " qué Palo (1-" + NUM_FOUNDATIONS + ")?: ");
        return foundations[palo -1];
    }
    
}
