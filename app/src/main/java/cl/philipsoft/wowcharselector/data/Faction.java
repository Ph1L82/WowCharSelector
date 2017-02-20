package cl.philipsoft.wowcharselector.data;

/**
 * Created by phil_ on 11-02-2017.
 * Faction : Agrupacion de razas
 */

public class Faction {
    private String name;

    public Faction() {
    }

    public Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
