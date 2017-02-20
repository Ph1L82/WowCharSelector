package cl.philipsoft.wowcharselector.data;

/**
 * Created by phil_ on 11-02-2017.
 * Race: Raza especifica del personaje, integra estadisticas basicas.
 * Pertenecen a una faccion (Faction) específica.
 */

public class Race {
    private int baseStrength, baseAgility, baseStamina, baseIntellect, baseSpirit;
    private String raceName;

    public Race(int baseStrength, int baseAgility, int baseStamina, int baseIntellect, int baseSpirit, String raceName) {
        this.baseStrength = baseStrength;
        this.baseAgility = baseAgility;
        this.baseStamina = baseStamina;
        this.baseIntellect = baseIntellect;
        this.baseSpirit = baseSpirit;
        this.raceName = raceName;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getBaseAgility() {
        return baseAgility;
    }

    public void setBaseAgility(int baseAgility) {
        this.baseAgility = baseAgility;
    }

    public int getBaseStamina() {
        return baseStamina;
    }

    public void setBaseStamina(int baseStamina) {
        this.baseStamina = baseStamina;
    }

    public int getBaseIntellect() {
        return baseIntellect;
    }

    public void setBaseIntellect(int baseIntellect) {
        this.baseIntellect = baseIntellect;
    }

    public int getBaseSpirit() {
        return baseSpirit;
    }

    public void setBaseSpirit(int baseSpirit) {
        this.baseSpirit = baseSpirit;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
}
