import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerCharacter {
    private String name;
    private Class dodclass;
    private Map<Attribute, Integer> attributes;

    PlayerCharacter(String name, Class dodclass) {
        this.name = name;
        this.dodclass = dodclass;

        Map<Attribute, Integer> attributes = generateAttributes(dodclass);
    }

    public String getName() {
        return name;
    }

    public Class getDodclass() {
        return dodclass;
    }

    public Map<Attribute, Integer> getAttributes() {
        return attributes;
    }

    @Override //HANN INTE KLART NÄSTAN
    public String toString() {
        StringBuilder sb = new StringBuilder();
        attributes.forEach(k, v) -> sb.append(k +" "+ v) ;
        return "PlayerCharacter [attributes=" + attributes + ", class=" + dodclass + ", name=" + name + "]";
    }

    public void levelUp() {

    }

    public static PlayerCharacter create(String name) {
        int randomclass = ThreadLocalRandom.current().nextInt(5);
        Class dodclass = null;
        switch (randomclass) {
            case 0:
                dodclass = Class.barbarian;
                break;
            case 1:
                dodclass = Class.bard;
                break;
            case 2:
                dodclass = Class.cleric;
                break;
            case 3:
                dodclass = Class.paladin;
                break;
            case 4:
                dodclass = Class.wizard;
                break;
        }
        PlayerCharacter pc = new PlayerCharacter(name, dodclass);
        return pc;
    }

    private static Map<Attribute, Integer> generateAttributes(Class dodClass) {
        Map<Attribute, Integer> attr = new LinkedHashMap<>();
        switch(dodClass){
            case barbarian: 
                attr.put(Attribute.strength, random(18));
                attr.put(Attribute.constitution, random(18));
                attr.put(Attribute.dexterity, random(14));
                attr.put(Attribute.intelligence, random(8));
                attr.put(Attribute.wisdom, random(14));
                attr.put(Attribute.charisma, random(8));
                break;
            case bard: 
                attr.put(Attribute.strength, random(14));
                attr.put(Attribute.constitution, random(8));
                attr.put(Attribute.dexterity, random(18));
                attr.put(Attribute.intelligence, random(14));
                attr.put(Attribute.wisdom, random(8));
                attr.put(Attribute.charisma, random(18));
                break;
            case cleric: 
                attr.put(Attribute.strength, random(14));
                attr.put(Attribute.constitution, random(18));
                attr.put(Attribute.dexterity, random(14));
                attr.put(Attribute.intelligence, random(8));
                attr.put(Attribute.wisdom, random(18));
                attr.put(Attribute.charisma, random(8));
                break;
            case paladin: 
                attr.put(Attribute.strength, random(18));
                attr.put(Attribute.constitution, random(14));
                attr.put(Attribute.dexterity, random(8));
                attr.put(Attribute.intelligence, random(8));
                attr.put(Attribute.wisdom, random(14));
                attr.put(Attribute.charisma, random(18));
                break;
            case wizard: 
                attr.put(Attribute.strength, random(8));
                attr.put(Attribute.constitution, random(8));
                attr.put(Attribute.dexterity, random(18));
                attr.put(Attribute.intelligence, random(18));
                attr.put(Attribute.wisdom, random(14));
                attr.put(Attribute.charisma, random(14));
                break;
        }
        return attr;
    }

    private static int random(int max) {
        return ThreadLocalRandom.current().nextInt(3, max);
    }

}

// din kod kompilerar inte (två parenteser saknas)
// lite osnyggt att random-funktionen är (halvt) del av konstruktorn
// ingen tostring
// ingen levelup
// poäng: 10 - 1 - 1 - 1 - 4 = 3p

// jag undrar vad som fick dig att krångla till generateAttributes?
// dina enum bör HA STORA BOKSTÄVER