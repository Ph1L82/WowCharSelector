package cl.philipsoft.wowcharselector.data;

/**
 * Created by phil_ on 19-02-2017.
 */

public class CharacterMaker extends Character {

    private Faction alliance = new Faction("Alliance");
    private Faction horde = new Faction("Horde");

    Race human = new Race(20, 20, 20, 20, 20, "Humano");
    Race dwarf = new Race(25, 16, 21, 19, 19, "Enano");
    Race nightElf = new Race(16, 24, 20, 20, 20, "Elfo Nocturno");
    Race gnome = new Race(15, 22, 20, 20, 22, "Gnomo");
    Race draenei = new Race(21, 17, 20, 20, 22, "Draenei");
    Race worgen = new Race(23, 22, 20, 16, 19, "Huargo");
    Race orc = new Race(23, 17, 21, 17, 22, "Orco");
    Race undead = new Race(19, 18, 20, 18, 25, "No-Muerto");
    Race tauren = new Race(25, 16, 21, 16, 22, "Tauren");
    Race troll = new Race(21, 22, 20, 16, 21, "Troll");
    Race bloodElf = new Race(17, 22, 20, 23, 18, "Elfo Nocturno");
    Race goblin = new Race(17, 22, 20, 23, 18, "Goblin");

    Class priest = new Class(0, 0, 0, 2, 3, "Sacerdote");
    Class rogue = new Class(1, 3, 1, 0, 0, "Pícaro");
    Class warrior = new Class(3, 0, 2, 0, 0, "Guerrero");
    Class mage = new Class(0, 0, 0, 3, 2, "Mago");
    Class druid = new Class(1, 0, 0, 2, 2, "Druida");
    Class hunter = new Class(0, 3, 1, 0, 1, "Cazador");
    Class warlock = new Class(0, 0, 1, 2, 2, "Brujo");
    Class shaman = new Class(1, 0, 1, 1, 2, "Chamán");
    Class paladin = new Class(2, 0, 2, 0, 1, "Paladín");
    Class deadKnight = new Class(88, 53, 79, 9, 22, "Dead Knight");

    private Faction makeCharFaction(String factionName) {
        Faction faction = new Faction(factionName);
        return faction;
    }

    public Race makeCharRace(String race) {
        switch (race) {
            case "Human":
                Race human = new Race(20, 20, 20, 20, 20, "Humano");
                return human;
            case "Dwarf":
                Race dwarf = new Race(25, 16, 21, 19, 19, "Enano");
                return dwarf;
            case "NightElf":
                Race nightElf = new Race(16, 24, 20, 20, 20, "Elfo Nocturno");
                return nightElf;
            case "Gnome":
                Race gnome = new Race(15, 22, 20, 20, 22, "Gnomo");
                return gnome;
            case "Draenei":
                Race draenei = new Race(21, 17, 20, 20, 22, "Draenei");
                return draenei;
            case "Worgen":
                Race worgen = new Race(23, 22, 20, 16, 19, "Huargo");
                return worgen;
            case "Orc":
                Race orc = new Race(23, 17, 21, 17, 22, "Orco");
                return orc;
            case "Undead":
                Race undead = new Race(19, 18, 20, 18, 25, "No-Muerto");
                return undead;
            case "Tauren":
                Race tauren = new Race(25, 16, 21, 16, 22, "Tauren");
                return tauren;
            case "Troll":
                Race troll = new Race(21, 22, 20, 16, 21, "Troll");
                return troll;
            case "BloodElf":
                Race bloodElf = new Race(17, 22, 20, 23, 18, "Elfo Nocturno");
                return bloodElf;
            case "Goblin":
                Race goblin = new Race(17, 22, 20, 23, 18, "Goblin");
                return goblin;
            default:
                throw new IllegalArgumentException("Raza no válida: " + race);
        }
    }

    public Class makeCharClass(String charClass){
        switch (charClass){
            case "Priest":
                Class priest = new Class(0, 0, 0, 2, 3, "Sacerdote");
                return priest;
            case "Rogue":
                Class rogue = new Class(1, 3, 1, 0, 0, "Pícaro");
                return rogue;
            case "Warrior":
                Class warrior = new Class(3, 0, 2, 0, 0, "Guerrero");
                return warrior;
            case "Mage":
                Class mage = new Class(0, 0, 0, 3, 2, "Mago");
                return mage;
            case "Druid":
                Class druid = new Class(1, 0, 0, 2, 2, "Druida");
                return druid;
            case "Hunter":
                Class hunter = new Class(0, 3, 1, 0, 1, "Cazador");
                return hunter;
            case "Warlock":
                Class warlock = new Class(0, 0, 1, 2, 2, "Brujo");
                return warlock;
            case "Shaman":
                Class shaman = new Class(1, 0, 1, 1, 2, "Chamán");
                return shaman;
            case "Paladin":
                Class paladin = new Class(2, 0, 2, 0, 1, "Paladín");
                return paladin;
            case "DeadKnight":
                Class deadKnight = new Class(88, 53, 79, 9, 22, "Dead Knight");
                return deadKnight;
            default:
                throw new IllegalArgumentException("Clase no válida: " + charClass);
        }
    }

    public CharacterMaker(Faction characterFaction, Race characterRace, Class characterClass, String characterName) {
        super(characterFaction, characterRace, characterClass, characterName);
    }

    public CharacterMaker(String characterName) {
        super(characterName);
    }


    public Character setCharacterBaseStats(Character character) {
        Race charRace = character.getCharacterRace();
        Class charClass = character.getCharacterClass();
        character.setStrength(charRace.getBaseStrength() + charClass.getBonusStrength());
        character.setAgility(charRace.getBaseAgility() + charClass.getBonusAgility());
        character.setStamina(charRace.getBaseStamina() + charClass.getBonusStamina());
        character.setIntellect(charRace.getBaseIntellect() + charClass.getBonusIntellect());
        character.setSpirit(charRace.getBaseSpirit() + charClass.getBonusSpirit());

        return character;
    }

    public Character setCharacterLevelStats(Character character, int lvl) {
        double multiplier = lvl * 0.2;

        character = this.setCharacterBaseStats(character);

        character.setStrength((int) (character.getStrength() * multiplier));
        character.setAgility((int) (character.getAgility() * multiplier));
        character.setStamina((int) (character.getStamina() * multiplier));
        character.setIntellect((int) (character.getIntellect() * multiplier));
        character.setSpirit((int) (character.getSpirit() * multiplier));
        return character;
    }

}
