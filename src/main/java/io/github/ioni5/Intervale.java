package io.github.ioni5;

public class Intervale {

    private int inferior;

    private int superior;

    public Intervale(int inferior, int superior) {
        this.inferior = inferior;
        this.superior = superior;
    }

    public boolean includes(int value) {
        return inferior <= value && value <= superior;
    }

}
