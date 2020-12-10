package u4;

import java.util.concurrent.ThreadLocalRandom;
import static u4.Attribute.*;

public class AttributesGenerator {

    public static int[] generateAttributes() {
        int[] attributes = new int[values().length];
        generateStrength(attributes);
        generateConstitution(attributes);
        generateDexterity(attributes);
        generateIntelligence(attributes);
        generateWisdom(attributes);
        generateCharisma(attributes);
        return attributes;
    }

    private static int generate() {
        return ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_VALUE);
    }

    private static void generateStrength(int[] attributes) {
        attributes[STR.get()] = generate();
    }

    private static void generateConstitution(int[] attributes) {
        attributes[CON.get()] = generate();
    }

    private static void generateDexterity(int[] attributes) {
        attributes[DEX.get()] = generate();
    }

    private static void generateIntelligence(int[] attributes) {
        attributes[INT.get()] = generate();
    }

    private static void generateWisdom(int[] attributes) {
        attributes[WIS.get()] = generate();
    }

    private static void generateCharisma(int[] attributes) {
        attributes[CHA.get()] = generate();
    }

}
