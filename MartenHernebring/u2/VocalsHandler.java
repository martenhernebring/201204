import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VocalsHandler {

    private Path input;
    private List<String> outputLines;

    public VocalsHandler(Path input) {
        this.input = input;
        outputLines = new ArrayList<>();
    }

    public void remove() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(input)) {
            String line = null;
            do{
                line = reader.readLine();
                String[] words = line.split("[\\w]([aeiouâãäåæçèéêëìíîïðñòóôõøùúûü])");
                StringBuilder builder = new StringBuilder();
                for(String word : words){
                    builder.append(word);
                }
                outputLines.add(builder.toString());
            } while(line != null);
        }
    }

    public void write(String file) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(String line : outputLines){
                writer.write(line);
            }
        }
	}

}

// du byter inte ut rätt tecken (aouåeiyäö) och byter inte ut dem rätt
// din kod krashar eftersom du försöker göra split på null vid filslut på rad 25
// du skriver ingen header
// du räknar inte antalet utbytta tecken
// poäng: 10 - 1 - 2 - 3 - 1 = 3p
