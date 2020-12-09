package u4;

public enum Attribute {
    STR(0), CON(1), DEX(2), INT(3), WIS(4), CHA(5);
    final static int MIN_VALUE = 3;
    final static int MAX_VALUE = 20;

    private int order;

    private Attribute(final int order) {
        this.order = order;
    }

    public int get() {
        return order;
    }
}