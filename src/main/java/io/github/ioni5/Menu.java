package io.github.ioni5;

public class Menu {

    private Movement[] movements;

    private int size;

    private Exit exit;

    public Menu() {
        movements = new Movement[100];
        exit = new Exit();
    }

    public void add(Movement movement) {
        movements[size] = movement;
        size++;
    }

    public void close() {
        this.add(exit);
    }

    public void show() {
        Console console = new Console();
        console.write("\nMenu");
        for (int i = 0; i < size; i++) {
            movements[i].show(i + 1);
        }
    }

    public Movement getOption() {
        Console console = new Console();
        int option = -1;
        boolean error = false;
        do {
            option = console.readInt("\nIngrese opcion (1-" + size + "): ");
            error =  !new Intervale(1, size).includes(option);

        } while (error);
        return movements[option - 1];
    }

    public boolean isExit() {
        return exit.isExecuted();
    }

}
