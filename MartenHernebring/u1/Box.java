public class Box implements Comparable<Box>{
    double length, width, height;

    Box(){
        length = 1;
        width = 1;
        height = 1;
    }

    Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
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
        if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
            return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", length, width, height);
    }
    
}

// Dina medlemsvariabler och konstruktorer är package-private! Dålig inkapsling.
// poäng: 10 - 3 = 7p
