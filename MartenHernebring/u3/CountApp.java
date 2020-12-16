import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountApp {
    public static void main(String[] args) throws InterruptedException {
        int threads = args.length;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            final String file = args[i];
            service.submit(() -> {
                int counter = 0;
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                    while (true) {
                        String line = reader.readLine();
                        if (line == null)
                            break;
                        counter += line.length();
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                printCount(counter, file);
            });
        }
        service.shutdown();
        service.awaitTermination(2, TimeUnit.MINUTES);
    }

    private static void printCount(int counter, String file) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.newLine();
            writer.write(counter);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

// du hanterar inte dubbletter av filer
// du räknar inte med nyrader
// din kod innehåller inte metoden som efterfrågas
// poäng: 10 - 1 - 1 - 1 = 7p
