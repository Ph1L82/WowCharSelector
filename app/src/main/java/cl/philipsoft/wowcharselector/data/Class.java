package cl.philipsoft.wowcharselector.data;

/**
 * Created by phil_ on 11-02-2017.
 * Class: clase o tipo de jugador pertenece a una raza
 * no todas las clases pueden ser utilizadas por todas las razas
 */

public class Class {
    private int bonusStrength, bonusAgility, bonusStamina, bonusIntellect, bonusSpirit;
    private String className;

    public Class(int bonusStrength, int bonusAgility, int bonusStamina, int bonusIntellect, int bonusSpirit, String className) {
        this.bonusStrength = bonusStrength;
        this.bonusAgility = bonusAgility;
        this.bonusStamina = bonusStamina;
        this.bonusIntellect = bonusIntellect;
        this.bonusSpirit = bonusSpirit;
        this.className = className;
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public void setBonusStrength(int bonusStrength) {
        this.bonusStrength = bonusStrength;
    }

    public int getBonusAgility() {
        return bonusAgility;
    }

    public void setBonusAgility(int bonusAgility) {
        this.bonusAgility = bonusAgility;
    }

    public int getBonusStamina() {
        return bonusStamina;
    }

    public void setBonusStamina(int bonusStamina) {
        this.bonusStamina = bonusStamina;
    }

    public int getBonusIntellect() {
        return bonusIntellect;
    }

    public void setBonusIntellect(int bonusIntellect) {
        this.bonusIntellect = bonusIntellect;
    }

    public int getBonusSpirit() {
        return bonusSpirit;
    }

    public void setBonusSpirit(int bonusSpirit) {
        this.bonusSpirit = bonusSpirit;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
