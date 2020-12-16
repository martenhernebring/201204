import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RemoveVocals{
    public static void main(String[] args) {
        if(args.length != 2){
            System.err.println("Usage RemoveVocals [from-file] [to-file]");
            System.exit(-1);
        } else{
            Path input = Path.of(args[0]);
            checkFile(input);
            var handler = new VocalsHandler(input);
            try{
                handler.remove();
            } catch(IOException ex){
                System.err.println("Problems reading file " + input);
            }
            try {
                handler.write(args[1]);
            } catch (IOException e) {
                System.err.println("Problems writing to file " + args[1]);
            }
        }
    }

    private static void checkFile(Path input) {
        if(!Files.exists(input)){
            System.err.printf("%s does not exist. Try with different file");
            System.exit(-1);
        } else if(!Files.isReadable(input)){
            System.err.printf("%s is not readable. Try with different file");
            System.exit(-1);
        }
    }
}

// du kontrollerar inte att utfilen inte finns
// 