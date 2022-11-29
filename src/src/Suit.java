public enum Suit {
    DIAMONDS(1),
    CLUBS(2),
    HEARTS(3),
    SPADES(4);

    private final int suitIndex;

    Suit(final int suitIndex) {
        this.suitIndex = suitIndex;
    }

    public int getSuitIndex() {
        return this.suitIndex;
    }
}