package u4;

import java.util.concurrent.ThreadLocalRandom;
import static u4.Attribute.*;

public class AttributesGenerator {
    private int[] attributes;

    public AttributesGenerator(){
        attributes = new int[values().length];
    }

    public int[] generateAttributes() {
        generateStrength();
        generateConstitution();
        generateDexterity();
        generateIntelligence();
        generateWisdom();
        generateCharisma();
        return attributes;
    }

    private int generate() {
        return ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_VALUE);
    }

	private void generateStrength() {
        attributes[STR.get()] = generate();
	}

    private void generateConstitution() {
        attributes[CON.get()] = generate();
	}

	private void generateDexterity() {
        attributes[DEX.get()] = generate();
	}

	private void generateIntelligence() {
        attributes[INT.get()] = generate();
	}

	private void generateWisdom() {
        attributes[WIS.get()] = generate();
	}

	private void generateCharisma() {
        attributes[CHA.get()] = generate();
	}

}
