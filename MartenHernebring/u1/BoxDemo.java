import java.util.Arrays;

public class BoxDemo {
    public static void main(String[] args) {
        Box[] boxes = {new Box(0.5, 2.121, 1.001), new Box()};
        Arrays.sort(boxes);
        for(Box box : boxes){
            System.out.printf("Box %s [length, width, height]%n", box);
        }
    }
}
