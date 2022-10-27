package io.github.ioni5;

public class Menu {

    private static final String[] TITLES = {
        "\n1-De Baraja a Descarte.",
        "\n2-De Descarte a Palo.",
        "\n3-De Descarte a Columna.",
        "\n4-De Palo a Columna.",
        "\n5-De Columna a Palo.",
        "\n6-De Columna a Columna.",
        "\n7-De Descarte a Baraja.",
        "\n8-Voltear en Columna.",
        "\n9-Salir."
    };

    public void show() {
        Console console = new Console();
        console.write("\nMenu");
        for (String title : TITLES) {
            console.write(title);
        }
    }

    public int getOption() {
        Console console = new Console();
        int option = 0;
        boolean error = false;
        do {
            option = console.readInt("\nIngrese opcion (1-" + TITLES.length + "): ");
            error =  !new Intervale(1, TITLES.length).includes(option);

        } while (error);
        return option;
    }

}
