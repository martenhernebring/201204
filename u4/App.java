package u4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String name = null;
        try(Scanner scan = new Scanner(System.in)){
            System.out.println("What is the character name?");
            name = scan.nextLine();
        }
        var character = PlayerCharacter.randomCharacter(name);
        System.out.println(character);
        for(int i = 0; i < 100; i++){
            character.levelUp();
            System.out.println(character);
        }
    }
}
