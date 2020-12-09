package u2; //valfritt

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*OBS: javac -encoding utf-8 on windows 10
1. Skriv ett program som tar in två filnamn som argument. 
Den första filen skall vara en befintlig textfil medan den andra filen inte får finnas. 
2. Programmet skall ta bort alla svenska vokaler från den befintliga textfilen 
och skriva allt annat till filen given som argument två. 
3. Programmet skall även placera en liten "header" högst upp i den nya filen 
med information om vad som gjorts. Den skall innehålla absolut sökväg till filen 
som konverterats, datum och tid när detta skedde samt antalet tecken som tagits bort. 
4. Programmet skall anta att infilen har teckenkodning UTF-8. 
5. Programmet skall hantera eventuella untantag på ett bra sätt.
Exempel på infil: 
    Hejsan 
    hoppsan 
    alla! 
Exempel på utfil: 
    File: C:\Users\Bosse\Documents\greeting.txt 
    Date: 2020-10-30 12:23:01 
    Removed: 6 
    Hjsn 
    hppsn 
    ll! 
*/

public class App {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage u2/App [from-file] [to-file]");
            System.exit(-1);
        }
        try {
            Path source = checkSource(args[0]);
            Path target = checkTarget(args[1]);
            convert(source, target);
        } catch (InvalidPathException ex) {
            System.err.println("The path is invalid: " + ex.getMessage());
            System.exit(-1);
        } 
        catch (RuntimeException ex) {
            System.err.println("Unexpected error: " + ex.getMessage());
            System.exit(-1);
        }
    }

    private static Path checkSource(String file) {
        Path inFile = Path.of(file);
            if (!Files.isReadable(inFile)) {
                System.err.printf("The file %s is not readable.%n", inFile);
                System.exit(-1);
            }
        return inFile;
    }

    private static Path checkTarget(String file) {
        Path outFile =  Path.of(file).toAbsolutePath().normalize(); 
        if (Files.exists(outFile)) {
            System.err.printf("The file %s already exists.%n", outFile);
            System.exit(-1);
        }
        return outFile;
    }

    /*Exempel på infil: 
        Hejsan 
        hoppsan 
        alla! 
    Exempel på utfil: 
        File: C:\Users\Bosse\Documents\greeting.txt 
        Date: 2020-10-30 12:23:01 
        Removed: 6 
        Hjsn 
        hppsn 
        ll! */
    
    private static void convert(Path input, Path file) {
        String[] header = new String[3];
        header[0] = "File: " + input.toString() + "\n";
        LocalDateTime now = LocalDateTime.now();
        var dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        header[1] = "Date: " + now.format(dateFormat) + "\n";
        StringBuilder vowelsRemoved = new StringBuilder();
        try{
            header[2] = "Removed: " + stripSwedishVowels(input, vowelsRemoved) + "\n";
        } catch (IOException ex) {
            System.err.println("Problems reading file " + input);
            System.exit(-1);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE_NEW)) {
            for(String line: header){
                writer.write(line);
            }
            writer.write(vowelsRemoved.toString());
        } catch (IOException ex) {
            System.err.println("Problems writing to file " + file);
            System.exit(-1);
        }
    }

    //OBS: javac -encoding utf-8 on windows 10
    private static int stripSwedishVowels(Path inFile, StringBuilder output) throws IOException{
        int totalRemoved = 0;
        List<String> outputLines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(inFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String noVowels = line.replaceAll("[aouåeiyäöAOUÅEIYÄÖ]", "");
                outputLines.add(noVowels);
                totalRemoved += line.length() - noVowels.length();
            }
        }
        for(String outputLine : outputLines){
            output.append(outputLine);
            output.append("\n");
        }
        return totalRemoved;
    }

}
