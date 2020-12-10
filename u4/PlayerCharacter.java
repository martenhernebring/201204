package u4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*1. Skapa en klass PlayerCharacter som modellerar egenskaperna hos en rollkaraktär 
i rollspelet Dungeons & Dragons. 
2. En sådan karaktär har ett namn, en klass och 
sex attribut: strength, constitution, dexterity, intelligence, wisdom och charisma. 
Dessa attribut är heltal från 3 till och med 20. 
4. Klassen kan vara en av "barbarian", "bard", "cleric", "paladin" och "wizard". 
5. Ge PlayerCharacter en lämplig konstruktor, getters och en toString()-metod. 
6. Implementera en metod levelUp() som ökar tre slumpmässiga attribut, som inte redan är 20, med ett. 
7. Om färre än tre attribut är lägre än 20 skall så många attribut som möjligt ökas. Dvs. inga attribut skall någonsin gå över 20. 
8. Implementera en statisk metod som givet ett karaktärsnamn skapar en ny karaktär 
med slumpmässiga attribut och slumpmässig klass. 
9. Skapa sedan en main-metod där användaren får skriva in ett namn på sin karaktär och sedan slumpas alla andra attribut fram med hjälp av metoden ovan. 
10. Slutligen skall karaktären skrivas ut på skärmen, levla upp en gång och skrivas ut igen.*/

public class PlayerCharacter {
    private String name;
    private PlayerClass pc;
    private int[] attributes;

    public PlayerCharacter(String name, PlayerClass pc) {
        this.name = name;
        this.pc = pc;
        var creation = new AttributesGenerator(); // blir för långt med 8 params
        attributes = creation.generateAttributes();
    }

    public void levelUp() {
        List<Attribute> toBeLevelUped = new ArrayList<>(List.of(Attribute.values()));
        Collections.shuffle(toBeLevelUped);
        int count = 0;
        for (Attribute next : toBeLevelUped) {
            final int attribute = next.get();
            if (attributes[attribute] < Attribute.MAX_VALUE) {
                attributes[attribute]++;
                count++;
                if (count == 3) {
                    break;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public PlayerClass getPc() {
        return pc;
    }

    public int[] getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s the %s,", name, pc));
        builder.append(" Str:" + attributes[Attribute.STR.get()]);
        builder.append(" Con:" + attributes[Attribute.CON.get()]);
        builder.append(" Dex:" + attributes[Attribute.DEX.get()]);
        builder.append(" Int:" + attributes[Attribute.INT.get()]);
        builder.append(" Wis:" + attributes[Attribute.WIS.get()]);
        builder.append(" Cha:" + attributes[Attribute.CHA.get()]);
        builder.append(".");
        return builder.toString();
    }

    public static PlayerCharacter randomCharacter(String name) {
        PlayerClass allClasses[] = PlayerClass.values();
        int randomClass = ThreadLocalRandom.current().nextInt(allClasses.length);
        PlayerClass pc = allClasses[randomClass];
        PlayerCharacter character = new PlayerCharacter(name, pc);
        return character;
    }
}
