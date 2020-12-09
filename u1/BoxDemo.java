package u1;
/*6. Skriv ett litet testprogram där du skapar 
en Box med konstruktorn som tar tre parametrar 
och en Box som du skapar med konstruktorn som inte tar några parametrar. 
Skriv sedan ut båda på terminalen. 
Mårtens egna lösning som gav full poäng(ganska valfritt tror jag)*/

import java.util.Arrays;

public class BoxDemo {
    public static void main(String[] args) {
        Box[] boxes = {new Box(), new Box(0.5, 2.121, 1.001)};
        Arrays.sort(boxes);
        for(Box box : boxes){
            System.out.printf("Box %s [length, width, height]%n", box);
        }
    }
}
