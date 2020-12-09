package u1; //inte nödvändigt valfritt

/*Uppgift 1 (10 poäng) 
1. Skapa en klass Box som innehåller tre flyttal som representerar längd, bredd och höjd. 
2. Klassen skall vara oföränderlig (immutable). 
3. Skapa en konstruktor som tar de tre värdena som parametrar och en konstruktor utan argument som initierar alla medlemsvariabler till ett. 
4. Gör klassen till en instans av Comparable samt implementera equals() och andra relevanta metoder. 
Sortering skall gå från lägst till högst och i ordningen längd, bredd och sist höjd. 
Implementationen av equals() skall matcha implementationen av Comparable. 
5. Gör en toString-metod som ger ut data på formen: (längd, bredd, höjd) där varje tal skall skrivas ut med två decimaler. 
*/

public class Box implements Comparable<Box>{
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Box(){
        this.length = 1.0;
        this.width = 1.0;
        this.height = 1.0;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    /**
     * Compares two boxes from small length, width, height to big natural order.
     * @param other the other box to be compared.
     */
    //Sortering skall gå från lägst till högst och i ordningen längd, bredd och sist höjd.
    //Finns två lösningar antingen snabb (<>) eller enkel(Comparator) Hampus föredrar Comparator lite
    //jag föredrar kopiera compare variablerna och sedan <> (vilket gav full poäng)
    @Override
    public int compareTo(Box other) {
        if (this == other)
            return 0;
        else if (Double.doubleToLongBits(length) < Double.doubleToLongBits(other.length))
            return -1;
        else if (Double.doubleToLongBits(length) > Double.doubleToLongBits(other.length))
            return 1;
        else if (Double.doubleToLongBits(width) < Double.doubleToLongBits(other.width))
            return -1;
        else if (Double.doubleToLongBits(width) > Double.doubleToLongBits(other.width))
            return 1;
        else if (Double.doubleToLongBits(height) < Double.doubleToLongBits(other.height))
            return -1;
        else if (Double.doubleToLongBits(height) > Double.doubleToLongBits(other.height))
            return 1;
        else return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(height);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Box other = (Box) obj;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
            return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", length, width, height);
    }
}
