package u3; //Ska inte användas i detta fall om man vill ha exakt som instruktion

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

/*1. Skriv ett program som tar ett antal filnamn som argument och 
lägger till antalet tecken i filen i slutet av respektive fil. 
2. Programmet skall innehålla en metod som givet ett filnamn tar reda på filens storlek 
(i antal tecken) och skriver den på en egen rad i slutet av filen. 
3. Varje infil skall hanteras i en egen tråd så att filer läses och skrives mer eller mindre simultant. 
4. Man skall se till att om samma fil angivits två gånger på kommandoraden kommer den bara hanteras en gång. 
5. Programmet kan utgå från att alla filer endast innehåller engelsk text. 
6. Programmet skall hantera eventuella untantag på ett bra sätt. Om en fil inte finns eller råkar ut för problem skall de andra ändå slutföras. 
Exempel på körning (med endast en fil): 
java CountApp fil1.txt 
Om fil1.txt är en textfil från windows och innehåller: 
    Hejsan 
    hoppsan 
Skall resultatet vara:
    Hejsan 
    hoppsan 
    15 */

public class CountApp {
    public static void writeSizeToEnd(Path file) throws IOException {
        long size = Files.size(file);
        try(BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)){
            writer.write(String.format("%n%s %n", size));
        }
    }

    public static void main(String[] args) {
        Set <Path> files = new HashSet<>();
        for(String arg : args){
            files.add(Path.of(arg).toAbsolutePath().normalize());
        }
        files.stream().parallel().forEach(t -> {
            try {
                writeSizeToEnd(t);
            } catch (IOException ex) {
                System.err.println("Problems writing to file " + ex.getMessage());
                System.exit(-1);
            }
        });
    }
}
